import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Ho creato una classe Attivita con i requisiti della tabella, quindi definisco le attività richieste.
        Attivita activity1 = new Attivita(1, "ACTIVITY1", true, 0);
        Attivita activity2 = new Attivita(2, "ACTIVITY2", false, 1);
        Attivita activity3 = new Attivita(3, "ACTIVITY3", true, 2);
        Attivita activity4 = new Attivita(4, "ACTIVITY4", true, 3);
        Attivita activity5 = new Attivita(5, "ACTIVITY5", false, 3);
        Attivita activity6 = new Attivita(6, "ACTIVITY6", false, 4);

        //Creo una lista con le attività create.
        List<Attivita> list = new ArrayList<>();
        list.add(activity1);
        list.add(activity2);
        list.add(activity3);
        list.add(activity4);
        list.add(activity5);
        list.add(activity6);

        //Leggo l'id del quale si vuole effettuare il controllo
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci id dell'attività che si vuole lavorare");
        int id = sc.nextInt();

        //uso n come contatore di giri all'interno del richiamo della funzione per la verifica che la prima attività selezionata non sia già lavorata.
        int n=0;

        Attivita check = null;

        //Determino l'attività corrispondente all'id scelto di cui voglio eseguire il controllo
        for (int i=0; i<6; i++)
        {
            if (list.get(i).getId()==id)
            {   String alias= list.get(i).getAlias();
               boolean lavorata=list.get(i).getLavorata();
               int parentId=list.get(i).getParentId();
               check=new Attivita(id,alias,lavorata,parentId);
                break;
            }
        }
        //chiamata alla funzione ricorsiva della classe Attività
        check.controlloLavorata(id,list,n);


    }

    }
