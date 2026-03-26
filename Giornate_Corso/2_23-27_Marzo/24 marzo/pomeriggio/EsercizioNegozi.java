import java.util.Scanner;

public class EsercizioNegozi {

    public static void inserisciProdotto(Negozio negozio1, Negozio negozio2, Negozio negozio3, Scanner scannerStr, Scanner scannerNum) {
        System.out.println("In quale negozio vuoi inserire il prodotto? ");
        System.out.println("1. Conad\n2. Lidl\n3. Eurospin");
        int sceltaNegozio = scannerNum.nextInt();

        System.out.println("Come si chiama il prodotto? ");
        String nomeProdotto = scannerStr.nextLine();
        System.out.println("Prezzo del prodotto? ");
        float prezzoProdotto = scannerNum.nextDouble();
        System.out.println("Quantità del prodotto? ");
        int qntProdotto = scannerNum.nextInt();

        
        Prodotto nuovoProdotto = new Prodotto(nomeProdotto, prezzoProdotto, qntProdotto);

        if (sceltaNegozio == 1) {
            negozio1.prodotto = nuovoProdotto;
        } else if (sceltaNegozio == 2) {
            negozio2.prodotto = nuovoProdotto;
        } else if (sceltaNegozio == 3) {
            negozio3.prodotto = nuovoProdotto;
        } else {
            System.out.println("Scelta non valida.");
        }

    }

    public static void visualizzaDati(Negozio negozio1, Negozio negozio2, Negozio negozio3) {
        System.out.println("Ecco la lista completa dei prodotti: ");
        System.out.println(negozio1);
        System.out.println(negozio1.prodotto);
        System.out.println("------------------------");
        System.out.println(negozio2);
        System.out.println(negozio2.prodotto);
        System.out.println("------------------------");
        System.out.println(negozio3);
        System.out.println(negozio3.prodotto);
        System.out.println("------------------------");
    }

    public static void maxPrezzo(Negozio negozio1, Negozio negozio2, Negozio negozio3) {
        Negozio[] negozi = {negozio1, negozio2, negozio3};
        Negozio negozioMax = negozi[0];

        for (int i = 0; i < negozi.length; i++) {
            if (negozi[i].prodotto.prezzo > negozioMax.prodotto.prezzo) {
                negozioMax = negozi[i];
            }
        }
        System.out.println("Il prodotto con il prezzo più alto è: " + negozioMax.prodotto + " e si trova in: " + negozioMax);
    }

    modificaQuantità(Negozio negozio1, Negozio negozio2, Negozio negozio3, Scanner scannerNum, Scanner scannerStr) {
        Negozio[] negozi = {negozio1,negozio2, negozio3};
        System.out.println("In quale negozio vuoi modificare la quantità di prodotto? ");
        System.out.println("1. Conad\n2. Lidl\n3. Eurospin");
        int sceltaNegozio = scannerNum.nextInt();
        System.out.println("Quale prodotto vuoi modificare? ");
        String modificaProdotto = scannerStr.nextLine();
        if (negozi[sceltaNegozio].prodotto.equals(modificaProdotto)) {
            System.out.println("Inserisci la nuova quantità");
            int nuovaQuantità = scannerNum.nextDouble();
            negozi[sceltaNegozio].prodotto.quantità = nuovaQuantità;
        } else {
            System.out.println("Prodotto non trovato");
        }
        
    }

    //DA FINIRE
    public static void vendiProdotto(Negozio negozio1, Negozio negozio2, Negozio negozio3, Scanner scannerNum, Scanner scannerStr) {
        Negozio[] negozi = {negozio1,negozio2, negozio3};
        System.out.println("Da quale negozio vuoi vendere il prodotto? ");
        System.out.println("1. Conad\n2. Lidl\n3. Eurospin");
        int sceltaNegozio = scannerNum.nextInt();
        System.out.println("Quale prodotto vuoi vendere? ");
        String vendiProdotto =  scannerStr.nextLine();
        if (negozi[sceltaNegozio].prodotto.nome.equals(vendiProdotto)) {
            System.out.println("Quantità? ");
            //negozi[sceltaNegozio].prodotto = ?
        } else {
            System.out.println("Prodotto non trovato");
        }
    }

        public static void main(String[] args) {

        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        int scelta;

        Prodotto prodotto1 = new Prodotto("Pasta", 4.99, 10);
        Prodotto prodotto2 = new Prodotto("Biscotti", 3.49, 7);
        Prodotto prodotto3 = new Prodotto("Surgelati", 12.19, 40);
        Negozio negozio1 = new Negozio("Conad", prodotto1);
        Negozio negozio2 = new Negozio("Lidl", prodotto2);
        Negozio negozio3 = new Negozio("Eurospin", prodotto3);

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Inserisci prodotto in un negozio");
            System.out.println("2. Visualizza dati di tutti i negozi");
            System.out.println("3. Cerca il negozio con il prodotto più costoso");
            System.out.println("4. Modifica quantità di un prodotto");
            System.out.println("5. Vendi prodotti da un negozio");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            scelta = scannerStr.nextInt();

            switch (scelta) {
                case 1:
                    inserisciProdotto(negozio1, negozio2, negozio3, scannerStr, scannerNum);
                    break;
                case 2:
                    visualizzaDati(negozio1, negozio2, negozio3);
                    break;
                case 3:
                    prezzoMax();
                    break;
                case 4:
                    modificaQuantità();
                    break;
                case 5:
                    vendiProdotto();
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova");
		    scelta = 1;
            }

        } while (scelta != 0);

        scannerNum.close();
        scannerStr.close();

    }
}


class Prodotto {
    String nome;
    double prezzo;
    int quantità;
    static int totaleProdotti;

    Prodotto (String nome, double prezzo, int quantità) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantità = quantità;
        totaleProdotti++;
    }
}

class Negozio {
    String nome;
    Prodotto prodotto;

    Negozio (String nome, Prodotto prodotto) {
        this.nome = nome;
        this.prodotto = prodotto;
    }

}