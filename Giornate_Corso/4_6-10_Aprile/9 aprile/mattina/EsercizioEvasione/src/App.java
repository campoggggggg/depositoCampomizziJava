import java.util.Scanner;

import observer.CentroPriorita;
import observer.OrdineObserverConcreto;
import ordine.Ordine;
import strategy.EvasioneNormale;

//non testato e manca qualche opzione del menu

public class App {
    public static void main(String[] args) throws Exception {
        //creo oggetti fuori dallo ciclo
        Ordine ordine = null;
        CentroPriorita centro = null;
        OrdineObserverConcreto observer = null;

        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n=== MENU CENTRO PRIORITA ===");
            System.out.println("1. Crea un ordine");
            System.out.println("2. Crea il centro di priorita");
            System.out.println("3. Registra l'observer");
            System.out.println("4. Cambia stato del centro");
            System.out.println("5. Visualizza strategy corrente dell'ordine");
            System.out.println("6. Esegui evasione");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {

                case 1://inserisci manualmente Ordine e crealo con evasione normale di default
                    System.out.print("Inserisci ID ordine: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Inserisci nome cliente: ");
                    String cliente = scanner.nextLine();

                    System.out.print("Inserisci prodotto: ");
                    String prodotto = scanner.nextLine();

                    System.out.print("Inserisci prezzo: ");
                    double prezzo = scanner.nextDouble();
                    scanner.nextLine();

                    ordine = new Ordine(id, cliente, prodotto, new EvasioneNormale(), prezzo);
                    System.out.println("Ordine creato correttamente.");
                    break;

                case 2: //crea centroP
                    centro = new CentroPriorita("NORMALE");
                    System.out.println("Centro creato. Stato iniziale: NORMALE");
                    break;

                case 3://add observer
                    if (ordine == null || centro == null) {
                        System.out.println("Crea prima l'ordine (1) e il centro (2).");
                        break;
                    }
                    observer = new OrdineObserverConcreto(ordine);
                    centro.aggiungiObserver(observer);
                    System.out.println("Observer registrato.");
                    break;

                case 4://cambio stato 
                    if (centro == null) {
                        System.out.println("Crea prima il centro (2).");
                        break;
                    }
                    System.out.println("Seleziona nuovo stato:");
                    System.out.println("1. NORMALE");
                    System.out.println("2. PRIORITA");
                    System.out.println("3. CONTROLLO");
                    System.out.print("Scelta: ");
                    int statoScelta = scanner.nextInt();
                    scanner.nextLine();

                    switch (statoScelta) {
                        case 1:
                            centro.setStato("NORMALE");
                            break;
                        case 2:
                            centro.setStato("PRIORITA");
                            break;
                        case 3:
                            centro.setStato("CONTROLLO");
                            break;
                        default:
                            System.out.println("Stato non valido.");
                    }
                    break;

                case 5:
                    if (ordine == null) {
                        System.out.println("Crea prima l'ordine (1).");
                        break;
                    }
                    
                    //da finire

                case 6://eseguiEvasione, strategy
                    if (ordine == null) {
                        System.out.println("Crea prima l'ordine (1).");
                        break;
                    }
                    ordine.eseguiEvasione();
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
