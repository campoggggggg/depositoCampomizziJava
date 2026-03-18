import java.util.Scanner;

public class EsercioWandDoW {
    public static void main(String[] args) {
        String password;
        String confirm;
        int counter = 1;
        boolean continua = true;
        boolean accesso = true;

        Scanner scanner = new Scanner(System.in);       
        while (continua){
            System.out.println("Inserisci una password: "); //chiedo password
            password = scanner.nextLine();
            
            if (password.equals("java123")) { //se la password è corretta rompi il ciclo
                System.out.println("Password corretta!");
                continua = false;
            } else if (counter < 3) { //se sono nei 3 tentativi, ripeto
                System.out.println("Password errata, riprova. Tentativi rimasti: " + (3 - counter)); //stampa tentativi rimasti
                counter++;
            } else { //tentativi finiti, termina

                System.out.println("Accesso bloccato.");
                continua = false;
                accesso = false;
            }
        }

        if (accesso) { //se ho superato l'accesso
            do {
                System.out.println("Vuoi accedere al sistema? (s/n)");
                confirm = scanner.nextLine(); //si o no?

                if (!confirm.equals("s") || !confirm.equals("n")){
                    System.out.println("Input errato. Inserire (s/n).");    //se utente inserisce qualcosa di diverso da s/n, stampa mex di errore
                }
            } while (!confirm.equals("s") && !confirm.equals("n")); //continua se non digita s o n

            if (confirm.equals("s")){
                System.out.println("Accesso effettuato");
            } else {
                System.out.println("Accesso annullato");
            }
        }
        
        scanner.close();

    }
}
