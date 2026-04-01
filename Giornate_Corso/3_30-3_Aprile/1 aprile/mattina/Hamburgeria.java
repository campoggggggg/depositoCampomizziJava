 ///ristorante gestisce menu. 
 /// commestibile è padre di cibo e bevande.
 /// cibo è padre di hamburger e dessert
 /// hamburger è padre di cheeseburger, vegburger e double bacon
 /// bevande è padre di frullato e spremuta

import java.util.Scanner;
import java.util.ArrayList;

class Ristorante {
    private String nome;
    private ArrayList<Commestibile> menù;

    public Ristorante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void aggiungiAlMenù(Commestibile item) {
        menù.add(item);

    }
}

class Commestibile {
    private String nome;

    public Commestibile (String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void prepara() {
        System.out.print("In Preparazione... " + getNome());
    }
}

class Cibo extends Commestibile{

    public Cibo(String nome) {
        super(nome);
    }
}

class Bevande extends Commestibile {

    public Bevande(String nome) {
        super(nome);
    }
}

class Frullato extends Bevande {
    public Frullato(String nome) {
        super(nome);
    }

    @Override
    public void prepara() {
        super.prepara();
        System.out.println(": fragole, latte, ghiaccio");
    }
}

class Spremuta extends Bevande {
    public Spremuta(String nome) {
        super(nome);
    }

    @Override
    public void prepara() {
        super.prepara();
        System.out.println(": arancia");
    }
}

class Hamburger extends Cibo {

    public Hamburger(String nome) {
        super(nome);
    }
}

class Cheeseburger extends Hamburger {
    public Cheeseburger (String nome) {
        super(nome);
    }

    @Override
    public void prepara() {
        super.prepara();
        System.out.println(": pane, carne, formaggio, ketchup");
    }
}

class VegBurger extends Hamburger {
    public VegBurger (String nome) {
        super(nome);
    }

    @Override
    public void prepara() {
        super.prepara();
        System.out.println(": pane integrale, burger vegetale, insalata, pomodoro");
    }
}

class DoubleBacon extends Hamburger {
    public DoubleBacon (String nome) {
        super(nome);
    }

    @Override
    public void prepara() {
        super.prepara();
        System.out.println(": pane, doppia carne, bacon, formaggio, salsa speciale");
    }
}

class Dessert extends Cibo {
    public Dessert (String nome) {
        super(nome);
    }

    @Override
    public void prepara() {
        super.prepara();
        System.out.println("Tiramisù");
    }
}

class Schermo {

    public void inPreparazione(Cibo cibo) {
        cibo.prepara();
    }
}

public class Hamburgeria {
    public static void main(String[] args) {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);

        Ristorante pub = new Ristorante("pub");
        Ristorante ff = new Ristorante("fast food");

        ArrayList<Commestibile> menù = new ArrayList<>();
        ArrayList<Dessert> dolci = new ArrayList<>();
        ArrayList<Hamburger> panini = new ArrayList<>();
        Schermo schermo = new Schermo();

        boolean continua = true;
        boolean continua2 = true;

        while (continua) {
            System.out.println("Chi sei: \n1. Gestore di ristorante\n2. Cliente");
            int ruolo = scannerNum.nextInt();

            switch (ruolo) { //da sistemare per aggiungere prodotti al menù
                case 1:
                    System.out.println("Qual è il tuo ristorante? \n1. Pub\n2. Fast Food");
                    int sceltaR = scannerNum.nextInt();

                    if (sceltaR == 1) {
                        System.out.println("Item da aggiungere al menù:");
                        String nomeItem = scannerStr.nextLine();
                        System.out.println("Sezione:\n1. Cibo\n2. Bevande");
                        int sezione = scannerNum.nextInt();
                        if (sezione == 1) {
                            Cibo item = new Cibo(nomeItem);
                        } else if (sezione == 2) {
                            Bevande item = new Bevande(nomeItem);
                        }

                        pub.aggiungiAlMenù(item); //da finire

                    } else if (sceltaR == 2) {
                        System.out.println("Item da aggiungere al menù:");
                        String nomeItem = scannerStr.nextLine();
                        Commestibile item = new Commestibile(nomeItem);
                        ff.aggiungiAlMenù(item);
                    }
                    break;

                case 2:

                    while (continua2) {
                    System.out.println("Scegli il tuo panino:");
                    System.out.println("1. Cheeseburger");
                    System.out.println("2. VegBurger");
                    System.out.println("3. Double Bacon");
                    System.out.println("4. Dolce del giorno");
                    System.out.println("0. Per terminare l'ordine");

                    int scelta = scannerNum.nextInt();


                    switch (scelta) {
                        case 1:
                            Cheeseburger cheeseburger = new Cheeseburger("Cheeseburger");
                            panini.add(cheeseburger);
                            break;
                        case 2:
                            VegBurger vegburger = new VegBurger("VegBurger");
                            panini.add(vegburger);
                            break;
                        case 3:
                            DoubleBacon doublebacon = new DoubleBacon("Double Bacon");
                            panini.add(doublebacon);
                            break;
                        case 4:
                            Dessert dessert = new Dessert("Dolce del giorno: ");
                            dolci.add(dessert);
                            break;
                        case 0:
                            continua2 = false;
                            break;
                        default:
                            System.out.println("Scelta non valida, riprova.");
                    }

                }//fine case2

                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        }
        
        
        System.out.println("Panini in cucina...");
        for (int i = 0; i < panini.size(); i++) {
            Hamburger panino = panini.get(i);
            schermo.inPreparazione(panino);
        }

        System.out.println("Dolci in cucina...");
        for (int i = 0; i < dolci.size(); i++) {
            Dessert dolce = dolci.get(i);
            schermo.inPreparazione(dolce);
        }



        scannerStr.close();
        scannerNum.close();

    }//end main
}
