public class HamburgerDecoratorEsercizio {
    public static void main(String[] args) {
        Hamburger ordine = new BaseBurger();

        //avvolgi con 2 decorator
        ordine = new FormaggioDecorator(ordine);
        ordine = new BaconDecorator(ordine);

        System.out.println(ordine.getDescrizione());
        System.out.println(ordine.getPrezzo());
    }
}

//interfaccia
interface Hamburger {
    String getDescrizione();
    double getPrezzo();
}

//classe concreta
class BaseBurger implements Hamburger{
    public String getDescrizione() {
        return "Burger base";
    }
    
    public double getPrezzo() {
        return 4.0;
    }
}

//decoratore astratto, tiene riferimento all'oggetto.
abstract class DecoratoreH implements Hamburger {
    protected Hamburger hamburger;

    public DecoratoreH(Hamburger hamburger) {
        this.hamburger = hamburger;
    }
}

//decoratore: formaggio
class FormaggioDecorator extends DecoratoreH {

    public FormaggioDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    public String getDescrizione() {
        return hamburger.getDescrizione() + " + Formaggio";
    }

    public double getPrezzo() {
        return hamburger.getPrezzo() + 0.5;
    }
}

//decoratore: bacon
class BaconDecorator extends DecoratoreH {

    public BaconDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    public String getDescrizione() {
        return hamburger.getDescrizione() + " + Bacon";
    }

    public double getPrezzo() {
        return hamburger.getPrezzo() + 0.8;
    }
}