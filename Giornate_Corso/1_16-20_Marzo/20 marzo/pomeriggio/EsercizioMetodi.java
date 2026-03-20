import java.util.Scanner;

class Veicolo {
    String marca;
    String modello;
    int anno;
    double prezzo;

    Veicolo(String marca, String modello, int anno, double prezzo) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.prezzo = prezzo;
    }
}

public class EsercizioMetodi {
    public static void main(String[] args) {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);

        Veicolo pippo = new Veicolo("", "", 1, 1);

        int scelta;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Inserisci dati veicolo");
            System.out.println("2. Visualizza veicolo");
            System.out.println("3. Modifica prezzo");
            System.out.println("4. Verifica età veicolo");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            scelta = scannerNum.nextInt();

            switch (scelta) {
                case 1:
                    aggiungiInfo(pippo, scannerStr, scannerNum);
                    break;

                case 2:
                    visualizzaVeicolo(pippo);
                    break;

                case 3:
                    modificaPrezzo(pippo, scannerNum);
                    break;

                case 4:
                    etàVeicolo(pippo);
                    break;

                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova");
		    scelta = 1;
            }

        } while (scelta != 0);
    }

    public static void aggiungiInfo(Veicolo pippo, Scanner scannerStr, Scanner scannerNum) {
        System.out.println("Inserisci i dati del veicolo: ");

        System.out.println("Marca: ");
        pippo.marca = scannerStr.nextLine();
        System.out.println("modello: ");
        pippo.modello = scannerStr.nextLine();

        do { //check per anno valido tra 1900 e 2026
            System.out.println("Anno: ");
            pippo.anno = scannerNum.nextInt();
            if (pippo.anno <= 1900 || pippo.anno >= 2027) {
                System.out.println("Anno non valido. Riprova.");
            } 
        }while (pippo.anno <= 1900 || pippo.anno >= 2027);

        do {//check prezzo maggiore di zero
            System.out.println("prezzo: ");
            pippo.prezzo = scannerNum.nextDouble();
            if (pippo.prezzo < 0) {
                System.out.println("Prezzo non valido. Riprova.");
            } 
        } while (pippo.prezzo < 0);
    }

    public static void visualizzaVeicolo(Veicolo pippo) {
        //controllo se vuoto?? vedi da michela boolean in Veicolo
        //System.out.println("Ecco le info del veicolo.");
        System.out.println("Marca: " + pippo.marca);
        System.out.println("modello: " + pippo.modello);
        System.out.println("Anno: " + pippo.anno);
        System.out.println("prezzo: " + pippo.prezzo + " E");
    }

    public static void modificaPrezzo(Veicolo pippo, Scanner scannerNum) {
        System.out.println("Inserire nuovo prezzo: ");
        double newPrezzo = scannerNum.nextDouble(); //prendi nuovo prezzo
        if (newPrezzo > 0) {
            pippo.prezzo = newPrezzo;
            System.out.println("Info aggiornate: ");
            visualizzaVeicolo(pippo);
        } else {
            System.out.println("Err valore non valido.");
        }
    }

    public static void etàVeicolo(Veicolo pippo) { //check età con qualche if
        int età = (2026 - pippo.anno);
        if (età < 5) {
            System.out.println("Il veicolo è NUOVO");
        } else if (età >= 5 && età <= 15) {
            System.out.println("Il veicolo è USATO");
        } else {
            System.out.println("Il veicolo è VECCHIO");
        }
    }
}