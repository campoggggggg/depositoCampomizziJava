package eseBevande;

import java.util.Scanner;

public class MainBevande {
    public static void main(String[] args) {
        GestoreOrdini gestore = GestoreOrdini.getInstance();
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n══ CAFFETTERIA ══");
            System.out.println("1 - Crea nuova bevanda");
            System.out.println("2 - Aggiungi ingrediente extra");
            System.out.println("3 - Visualizza bevanda corrente");
            System.out.println("4 - Conferma ordine");
            System.out.println("5 - Visualizza storico ordini");
            System.out.println("0 - Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1: //selezione bevanda
                    System.out.println("Scegli bevanda base:");
                    System.out.println("1 - Caffè (1.00€)");
                    System.out.println("2 - Tè (2.00€)");
                    System.out.println("3 - Cioccolata calda (3.50€)");                    

                    Bevanda base = null;
                    int sceltaBevanda;
                    do {
                        System.out.print("Scelta: ");
                        sceltaBevanda = scanner.nextInt();
                    
                        if (sceltaBevanda == 1) {
                            base = new Caffe();
                        } else if (sceltaBevanda == 2) {
                            base = new Te();
                        } else if (sceltaBevanda == 3) {
                            base = new CioccolataCalda();
                        } else {
                            System.out.println("Scelta non valida.");
                            sceltaBevanda = 42;
                        }

                    } while (sceltaBevanda == 42);

                    gestore.setBevandaCorrente(base);
                    System.out.println("Nuova bevanda: " + base.getDescrizione());
                    
                    break;
                case 2:
                    if (gestore.getBevandaCorrente() == null) {
                        System.out.println("Nessuna bevanda base selezionata");
                        break;
                    }

                    System.out.println("Scegli extra:");
                    System.out.println("1 - Latte (+0.50€)");
                    System.out.println("2 - Zucchero (+0.20€)");
                    System.out.println("3 - Cacao (+0.20€)");
                    System.out.println("4 - Panna (gratis)");
                    System.out.println("5 - Cannella (+0.20€)");
                    
                    Bevanda decorata = null;
                    int sceltaExtra;
                    do {
                        System.out.print("Scelta: ");
                        sceltaExtra = scanner.nextInt();

                        if (sceltaExtra == 1) {
                            decorata = new Latte(gestore.getBevandaCorrente());
                        } else if (sceltaExtra == 2) {
                            decorata = new Zucchero(gestore.getBevandaCorrente());
                        } else if (sceltaExtra == 3) {
                            decorata = new Cacao(gestore.getBevandaCorrente());
                        } else if (sceltaExtra == 4) {
                            decorata = new Panna(gestore.getBevandaCorrente());
                        } else if (sceltaExtra == 5) {
                            decorata = new Cannella(gestore.getBevandaCorrente());
                        } else {
                            System.out.println("Scelta non valida.");
                            sceltaExtra = 42; 
                        }

                    } while (sceltaExtra == 42);

                    gestore.decoraBevandaCorrente(decorata);
                    System.out.println("Extra aggiunto: " + decorata.getDescrizione());
                    break;
                    
                case 3:
                    gestore.visualizzaOrdineCorrente();
                    break;
                case 4:
                    gestore.confermaOrdine();
                    break;
                case 5:
                    gestore.visualizzaStorico();
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;

                default:
                    System.out.println("Opzione non valida.");
            }
        } while (scelta != 0);
    }
}
