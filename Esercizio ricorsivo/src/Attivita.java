import java.util.List;

public class Attivita {
    private int id;
    private String alias;
    private boolean lavorata;
    private int parentId;

    //Classe attività con i dati della tabella richiesta ed i metodi per prelevare ed inserire nuovi dati.
    public Attivita(int id, String alias, boolean lavorata, int parentId){
        this.id=id;
        this.alias=alias;
        this.lavorata=lavorata;
        this.parentId=parentId;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getAlias(){
        return alias;
    }
    public void setAlias(String alias){
        this.alias=alias;
    }
    public boolean getLavorata(){
        return lavorata;
    }

    public void setLavorata(boolean lavorata){
        this.lavorata=lavorata;
    }

    public int getParentId(){
        return parentId;
    }

    public void setParentId(){
        this.parentId=parentId;
    }

    public void controlloLavorata(int id, List<Attivita> list, int n){
        n++;
        //1 è l'id del primo nodo, senza genitori, quindi se risulta lavorato non ho nient'altro da controllare, sono alla fine del problema.
        if (id == 1) {
            if (list.get(0).getLavorata()) {
                System.out.println("Non ci sono attività da lavorare");
            }
        }
        else {

            //cerco a quale elemento della lista corrisponde l'id cercato.
            for (int i = 0; i < 6; i++) {
                if (list.get(i).getId() == id) {
                    lavorata = list.get(i).getLavorata();
                    parentId = list.get(i).getParentId();

                    break;
                }
            }


            //se lavorata è vero assegno ad id il valore  dell'id del parent e controllo al prossimo richiamo che anche lavorata del parent sia true (finchè non si trova un'attività non lavorata o non si arriva alla prima attività della lista.)
            if (lavorata) {
                System.out.println("Attivita lavorata " + id);
                id = parentId;
                //se sono alla prima chiamata e l'id è già lavorato, esco dal loop perchè la richiesta è già soddisfatta.
                if (n == 1) {
                    id = 1;
                }
                controlloLavorata(id, list, n);
            } else {
                //se sono alla prima chiamata  e l'attività non è lavorata verifico che possa esserlo, aggiorno l'id all'id parent e ricomincio la ricerca.
                if (n == 1) {
                    id = parentId;
                    controlloLavorata(id, list, n);
                }
                //se invece trovo con un'attività non lavorata successivamente alla prima chiamata, fermo la funzione e segnalo l'attività che è da lavorare per poter procedere.
                else {
                    System.out.println("Attivita da  lavorare " + id);
                }

            }
        }
    }

}
