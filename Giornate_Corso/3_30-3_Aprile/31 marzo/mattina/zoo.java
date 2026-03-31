import java.util.ArrayList;

class Animale {
    String nome;
    int età;

    Animale (String nome, int età) { //costruttore
        this.nome = nome;
        this.età = età;
    }

    public String faiVerso() {
        return "verso";
    }

    public String toString() {        // rappresentazione stringa dell'oggetto
        return nome + " | " + età;
    }

}

class Cane extends Animale {

    Cane(String nome, int età) {
        super(nome, età); //figlio di animale, costuttore deve richiamare il fatto di "essere super"
    }

    public String faiVerso() { //override implicito
        return "bau";
    }
}

class Gatto extends Animale { //analogo a cane

    Gatto(String nome, int età) {
        super(nome, età);
    }

    public String faiVerso() {
        return "miao";
    }
}

public class zoo {

    public static void main (String[] args) {
        ArrayList<Animale> animali = new ArrayList<>(); //arraylist animali

        //dichiarazione di 3 animali dentro l'arraylist
        Cane c1 = new Cane("Freddie", 12);
        Gatto g1 = new Gatto("Artù", 1);
        Cane c2 = new Cane("Kira", 4);

        //li metto nell'arraylist
        animali.add(c1);
        animali.add(c2);
        animali.add(g1);

        for (int i = 0; i < animali.size(); i++) {//stampa l'arraylist di animali con nome, età e verso corrispondente
            System.out.printf("animale %d: %s | %s%n", (i+1), animali.get(i), animali.get(i).faiVerso());
        }

    }
}
