import java.util.Scanner;

public class ExSwitch_1 {
    public static void main(String[] args){
        //stampa il menù e chiedi l'opzione da inserire
        Scanner myOpt = new Scanner(System.in);
        System.out.println("Scegliere un opzione: \n1. Visualizza profilo \n2. Modifica nome \n3. Logout");
        int option = myOpt.nextInt();

        switch (option){
            case 1: //se sceglie di visualizzare il profilo
                System.out.println("Profilo utente visualizzato");
                break;

            case 2: //se vuole modificare il nome
                Scanner myName = new Scanner(System.in);
                System.out.println("Inserisci il nuovo nome: ");
                String newName = myName.nextLine();
                System.out.println("aggiornato in: " + newName);
                break;

            case 3: //per il logout
                System.out.println("Logout effettuato");
                break;
            
            default: //caso in cui si inserisce qualcosa diverso da 1, 2 o 3
                System.out.println("Scelta non valida");

        }
        
    }
}