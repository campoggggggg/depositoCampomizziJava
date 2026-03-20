import java.util.ArrayList;
import java.util.Scanner;

public class Test {


    static void aggiungiProdotto(ArrayList<String> prod, ArrayList<Integer> qnt, Scanner scannerStr, Scanner scannerNum) {
        System.out.println("Aggiungi nome prodotto: ");
        String prodotto = scannerStr.nextLine();
        if (prodotto.equals("")) {//se è vuoto print ERR
            System.out.println("Err nome vuoto");
        } else {
            prod.add(prodotto);//alloca il nome del prodotto nell'arrList
            System.out.println("Aggiungi quantità: ");
        int quantità = scannerNum.nextInt();//qui prendo le quantità del prodotto in questione
        if (quantità <= 0 ) {//se <= 0 ERR
            System.out.println("Err quantità non positiva");
        } else {
            qnt.add(quantità);//alloca 
        }
        }

                
    }

    static void visualizzaProdotti (ArrayList<String> prod, ArrayList<Integer> qnt) {
        if (prod.size() == 0) {//se listaProdotti è vuota ERR
            System.err.println("Err lista prodotti vuota");
        } else {
            System.out.print("Lista prodotti inseriti: ");
            for (int i = 0; i < prod.size(); i++) {//stampa prodotto e quantità vicine, muove l'indice sull'ArrList
                System.err.print("\n" + prod.get(i) + " | quantità: " + qnt.get(i));
            }   
        }
    }

    static void cercaProdotto(ArrayList<String> prod, ArrayList<Integer> qnt, Scanner scannerStr) {
        boolean trovato = false;//se non trovo prodotto, rimane false e stampa messaggio di errore
        System.out.println("Scrivi il nome da cercare: ");
        String prodotto = scannerStr.nextLine();
        for (int i = 0; i < prod.size(); i++) {
            if(prod.get(i).toLowerCase().equals(prodotto.toLowerCase())) { //comparazione tra il nome inserito (prodotto) e l'ArrList (prod)
                trovato = true; //se sto in questo blocco l'ho trovato
                System.out.println("Prodotto trovato. " + prod.get(i) + " | Quantità: " + qnt.get(i));
            }
        }
        if (!trovato) {
            System.out.println("Prodotto non trovato.");
        }
    }

    static void modificaQuantità(ArrayList<String> prod, ArrayList<Integer> qnt, Scanner scannerStr, Scanner scannerNum) {
        //stessa logica di cerca prodotto, con le adeguate modifiche
        boolean trovato = false;
        System.out.println("Scrivi il nome del prodotto per cambiarne la quantità: ");
        String prodotto = scannerStr.nextLine();
        for (int i = 0; i < prod.size(); i++) {
            if(prod.get(i).toLowerCase().equals(prodotto.toLowerCase())) {
                trovato = true;
                System.out.println("Prodotto trovato. " + prod.get(i) + " | Quantità: " + qnt.get(i));
                System.out.println("Inserisci la nuova quantità: ");
                int newQnt = scannerNum.nextInt();//unica differenza è la nuova quantità da inserire
                qnt.set(i, newQnt); //con set() cambio la memoria in i con il nuovo int newQnt
                System.out.println("Quantità cambiata! " + prod.get(i) + " | Quantità: " + qnt.get(i));
            } 
        }
        if (!trovato) {
            System.out.println("Prodotto non trovato.");
        }
    }

    static void rimuoviProdotto(ArrayList<String> prod, ArrayList<Integer> qnt, Scanner scannerStr) {
        //stessa logica di cerca prodotto, con le adeguate modifiche
        boolean trovato = false;
        System.out.println("Prodotto da eliminare: ");
        String prodotto = scannerStr.nextLine();
        for (int i = 0; i < prod.size(); i++) {
            if(prod.get(i).toLowerCase().equals(prodotto.toLowerCase())) {
                trovato = true;
                System.out.println("Prodotto trovato. " + prod.get(i) + " eliminato. ");
                prod.remove(i); //rimuovi Prodotto
                qnt.remove(i); //rimuovi Quantità
            } 
        }
        if (!trovato) {
            System.out.println("Prodotto non trovato.");
        }
    }

    static int calcolaTotalePezziProdotti(ArrayList<Integer> qnt) {
        //inizializzo somma a 0, itero sulla dimensione della lista e aggiungo ad ogni passaggio la quantità di un prodotto.
        int somma = 0;
        for (int i = 0; i < qnt.size(); i++) {
            somma += qnt.get(i);
        }
        return somma;
    }






    public static void main(String[] args) {
        
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);
        int scelta; //per lo switch

        ArrayList<String> listaProdotti = new ArrayList<>();
        ArrayList<Integer> listaQuantità = new ArrayList<>();

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Aggiungi prodotto");
            System.out.println("2. Visualizza produzione");
            System.out.println("3. Cerca prodotto");
            System.out.println("4. Modifica prodotto");
            System.out.println("5. Rimuovi prodotto");
            System.out.println("6. Calcola totale pezzi prodotti ");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            scelta = scannerNum.nextInt();

            switch (scelta) {
                case 1:
                    aggiungiProdotto(listaProdotti, listaQuantità, scannerStr, scannerNum);
                    break;

                case 2:
                    visualizzaProdotti(listaProdotti, listaQuantità);
                    break;

                case 3:
                    cercaProdotto(listaProdotti, listaQuantità, scannerStr);
                    break;

                case 4:
                    modificaQuantità(listaProdotti, listaQuantità, scannerStr, scannerNum);
                    break;

                case 5:
                    rimuoviProdotto(listaProdotti, listaQuantità, scannerStr);
                    break;
                
                case 6:
                System.out.println("Il totale dei pezzi prodotti di oggi è: " + calcolaTotalePezziProdotti(listaQuantità));
                    break;

                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova");
		            scelta = 1;
            }

        } while (scelta != 0);

        scannerStr.close();
        scannerNum.close();

    }


}
