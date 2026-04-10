import java.util.Scanner;

import facade.SistemaOrdineFacade;

public class App {
    public static void main(String[] args) throws Exception {
        ///conf base
        /// add 1+ compone
        /// visualizza desc e prezzo
        /// scegli opzioni spedizione
        /// conferma ordine con facade
        Scanner scanner = new Scanner(System.in);
        SistemaOrdineFacade sistema = new SistemaOrdineFacade();
        int scelta;

        do {
            System.out.println("\n=== MENU CONFIGURAZIONE PC ===");
            System.out.println("1. Scegli configurazione base");
            System.out.println("2. Aggiungi componente extra");
            System.out.println("3. Visualizza descrizione e prezzo");
            System.out.println("4. Scegli metodo di pagamento");
            System.out.println("5. Conferma ordine");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {

                case 1:
                    int base;
                    do {
                        System.out.println("1. Gaming  2. Ufficio");
                        System.out.print("Scelta: ");
                        base = scanner.nextInt();
                        if (base == 1) sistema.scegliConfigurazioneBase("gaming");
                        else if (base == 2) sistema.scegliConfigurazioneBase("ufficio");
                        else System.out.println("Scelta non valida, riprova.");
                    } while (base != 1 && base != 2);
                    break;

                case 2:
                    int comp;
                    do {
                        System.out.println("1. RAM extra  2. SSD extra  3. Raffreddamento  4. Scheda video");
                        System.out.print("Scelta: ");
                        comp = scanner.nextInt();
                        if (comp == 1) sistema.aggiungiRam();
                        else if (comp == 2) sistema.aggiungiSSD();
                        else if (comp == 3) sistema.aggiungiRaffreddamento();
                        else if (comp == 4) sistema.aggiungiSchedaVideo();
                        else System.out.println("Scelta non valida, riprova.");
                    } while (comp != 1 && comp != 2 && comp != 3 && comp != 4);
                    break;
                case 3:
                    sistema.visualizzaRiepilogo();
                    break;

                case 4:
                    int pag;
                    do {
                        System.out.println("1. Carta di credito  2. PayPal");
                        System.out.print("Scelta: ");
                        pag = scanner.nextInt();
                        if (pag == 1) sistema.scegliPagamento("CC");
                        else if (pag == 2) sistema.scegliPagamento("PP");
                        else System.out.println("Scelta non valida, riprova.");
                    } while (pag != 1 && pag != 2);
                    break;
                case 5:
                    sistema.confermaOrdine();
                    break;

                case 0:
                    System.out.println("Uscita.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        scanner.close();
        
    }
}
