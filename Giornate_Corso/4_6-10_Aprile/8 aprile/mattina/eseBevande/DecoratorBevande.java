package eseBevande;

public class DecoratorBevande {

}

/*
    INTERFACCIA BASE
*/
interface Bevanda {

    String getDescrizione();
    double getCosto();

}


/*
    CLASSE BASE CONCRETA
*/
class Caffe implements Bevanda {

    public String getDescrizione() {
        return "Caffè";
    }

    public double getCosto() {
        return 1.0;
    }

}

class Te implements Bevanda {

    public String getDescrizione() {
        return "té";
    }

    public double getCosto() {
        return 2.0;
    }

}

class CioccolataCalda implements Bevanda {

    public String getDescrizione() {
        return "Cioccolata calda";
    }

    public double getCosto() {
        return 3.5;
    }

}


/*
    DECORATOR ASTRATTO
*/
abstract class Decoratore implements Bevanda {

    protected Bevanda bevanda;

    public Decoratore(Bevanda bevanda) {
        this.bevanda = bevanda;
    }

}


/*
    DECORATORE: LATTE
*/
class Latte extends Decoratore {

    public Latte(Bevanda bevanda) {
        super(bevanda);
    }

    public String getDescrizione() {
        return bevanda.getDescrizione() + " + Latte";
    }

    public double getCosto() {
        return bevanda.getCosto() + 0.5;
    }

}


/*
    DECORATORE: ZUCCHERO
*/
class Zucchero extends Decoratore {

    public Zucchero(Bevanda bevanda) {
        super(bevanda);
    }

    public String getDescrizione() {
        return bevanda.getDescrizione() + " + Zucchero";
    }

    public double getCosto() {
        return bevanda.getCosto() + 0.2;
    }

}

/*
    DECORATORE: CACAO
*/
class Cacao extends Decoratore {

    public Cacao(Bevanda bevanda) {
        super(bevanda);
    }

    public String getDescrizione() {
        return bevanda.getDescrizione() + " + Cacao";
    }

    public double getCosto() {
        return bevanda.getCosto() + 0.2;
    }

}

/*
    DECORATORE: PANNA
*/
class Panna extends Decoratore {

    public Panna(Bevanda bevanda) {
        super(bevanda);
    }

    public String getDescrizione() {
        return bevanda.getDescrizione() + " + Panna";
    }

    public double getCosto() {
        return bevanda.getCosto();
    }

}

/*
    DECORATORE: CANNELLA
*/
class Cannella extends Decoratore {

    public Cannella(Bevanda bevanda) {
        super(bevanda);
    }

    public String getDescrizione() {
        return bevanda.getDescrizione() + " + Cannella";
    }

    public double getCosto() {
        return bevanda.getCosto() + 0.2;
    }

}