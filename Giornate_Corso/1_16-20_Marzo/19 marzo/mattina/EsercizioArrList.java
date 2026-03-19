import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EsercizioArrList {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Float> studentGrades = new ArrayList<>(); //float per fini futuri. ad esempio per la media voti
        ArrayList<Integer> studentAge = new ArrayList<>();

        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        String tempName;
        int tempAge;
        float tempGrade;
        int toCancel;
        int originalStudentSize;
        boolean check = true;

        //blocco inserimento nome o per finire
        do {
            System.out.println("Inserisci il nome: ");
            tempName = scannerStr.nextLine();

            if (!tempName.equals("fine")) {//nel momento in cui non inserisci fine, aggiungi le info
                studentNames.add(tempName);         
                System.out.println("Età: ");
                tempAge = scannerInt.nextInt();
                studentAge.add(tempAge);
                System.out.println("Voto: ");
                tempGrade = scannerInt.nextInt();
                studentGrades.add(tempGrade);

                System.out.println("Info inserite. Continuare o scrivere \'fine\' per terminare.");
            }
        } while(!tempName.equals("fine"));

        //ordinamento
        Collections.sort(studentNames);
        originalStudentSize = studentNames.size();
        System.out.println("Ecco la lista di nomi in ordine alfabetico: " + studentNames);
        System.out.println("Totale studenti: " + originalStudentSize);

        //blocco per eliminare nomi
        while (check) {
            System.out.println("Vuoi eliminare il nome di uno studente dalla lista? (s/n) ");
            String confirm = scannerStr.nextLine();
            if (confirm.equals("s")) {
                System.out.println("Quale vuoi eliminare? ");
                toCancel = scannerInt.nextInt(); //toCancel è l'intero per entrare nella lista e rimuovere quell'elemento
                studentNames.remove(toCancel - 1);  //rimuove 
            } else if (confirm.equals("n")) {
                System.out.println("Ok, ora hai " + studentNames.size() + " studenti.");
                if (originalStudentSize != studentNames.size()) { //SE ho rimosso, avrò size diversa dall'originale, quindi stampi la nuova lista.
                    System.out.println("Ecco la nuova lista: " + studentNames);
                }
                check = false; //rompe il ciclo
            } else {
                System.out.println("Valore non valido. Inserisci (s/n). ");
            }

        }

        //good practice
        scannerInt.close();
        scannerStr.close();
    }
    
}

