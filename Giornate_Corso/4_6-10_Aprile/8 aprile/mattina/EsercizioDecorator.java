public class EsercizioDecorator {
    public static void main(String[] args) {
        //inizializz
        Messaggio msg = new MessaggioBase();

        //decoratori
        msg = new DecoratoreMaiuscolo(msg);
        //un decoratore "avvolge" un oggetto, quindi lo chiamo nelle parentesi

        //stampa
        System.out.println(msg.getContenuto());
    }
}

interface Messaggio {
    String getContenuto();
}

//classe concreta
class MessaggioBase implements Messaggio {

    public String getContenuto () {
        return "Un messaggio semplice. ";
    }
}

//Decorator base astratto (TIENE RIFERIMENTO ALL'OGGETTO)
abstract class MessaggioDecorator implements Messaggio {
    protected Messaggio msg;

    public MessaggioDecorator(Messaggio msg) {
        this.msg = msg;
    }
}

// decorator concreto (AGGIUNGE COMPORTAMENTO)
class DecoratoreMaiuscolo extends MessaggioDecorator {

    public DecoratoreMaiuscolo(Messaggio msg) {
        super(msg); // passa msg al decorator base
    }

    public String getContenuto() {
        return msg.getContenuto().toUpperCase();
    }
}