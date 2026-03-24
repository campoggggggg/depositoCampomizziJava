import java.util.Scanner;

public class EsercizioGioco {
    public static void main(String[] args) {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);

        int secretNumber = 50;
        int tentativiRimasti = 5;
        boolean resa = false;
        boolean vittoria = false;
        
        System.out.println("GIOCATORE A: inserisci un numero intero segreto tra 1 e 100");
        //A inserisce un numero, se troppo alto o basso riprova
        do {
            if (secretNumber <= 0 || secretNumber >100) {
                System.out.println("Numero non valido. Inserisci tra 1 e 100");
            } secretNumber = scannerNum.nextInt();
        } while (secretNumber <= 0 || secretNumber > 100);


        System.out.println("GIOCATORE B: prova ad indovinare. Hai 5 tentaivi");
        do {
            System.out.println("Inserisci un numero. Tentativi rimasti: " + tentativiRimasti);
            String input = scannerStr.nextLine(); //Inserisce primo numero O "mi arrendo"

            if (input.equals("mi arrendo")) {
                System.out.println("Ti sei arreso");
                resa = true; //perde
            } else {
                int numero = Integer.parseInt(input); //sennò trasformo in intero

                if (numero == secretNumber) {
                System.out.println("Hai vinto!");
                vittoria = true; //vittoria
                } else if (numero > secretNumber) {
                    tentativiRimasti--; //tolgo un tentativo 
                    System.out.println("Troppo alto...");
                    if (tentativiRimasti == 0) { //se tentaivi finiti, stampa "Hai perso" e rivela numero segreto
                        System.out.println("Hai perso... Il numero da indovinare era " + secretNumber);
                    }
                } else {
                    tentativiRimasti--;
                    System.out.println("Troppo basso...");
                    if (tentativiRimasti == 0) {//se tentaivi finiti, stampa "Hai perso" e rivela numero segreto
                        System.out.println("Hai perso... Il numero da indovinare era " + secretNumber);
                    }
                }
            }
            
        } while (tentativiRimasti > 0 && !vittoria && !resa); //continua finché ho tentativi, non ho vinto e non mi sono arreso (appena una condizione è falsa, esce dal ciclo)
        scannerNum.close();
        scannerStr.close();
    }
}