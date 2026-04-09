public class StrategyEsercizio {

    public static void main(String[] args) {

        int a = 4;
        int b = 3;

        // creazione operazioni
        Addizione piu = new Addizione();
        Moltiplicazione per = new Moltiplicazione();

        // calcolatrice con op iniziale
        Calcolatore calc = new Calcolatore("Calc", piu);
        calc.eseguiOperazione(a, b);

        // cambio operazione in rt
        calc.setOperazione(per);
        calc.eseguiOperazione(a, b);
    }
}


/*
    INTERFACCIA STRATEGY
*/
interface Operazione {
    int esegui(int a, int b);
}


/*
    STRATEGIE CONCRETE
*/
class Addizione implements Operazione {
    private String nome; 

    public Addizione () {
        this.nome = "Addizione";
    }

    @Override
    public int esegui(int a, int b) {
        return a + b;
    }

}

class Moltiplicazione implements Operazione {

    @Override
    public int esegui(int a, int b) {
        return a * b;
    }

}


/*
    CONTEXT
*/
class Calcolatore {

    private String nome;
    private Operazione op;

    public Calcolatore(String nome, Operazione op) {
        this.nome = nome;
        this.op = op;
    }

    public void setOperazione(Operazione op) {
        this.op = op;
    }

    public void eseguiOperazione(int a, int b) {
        System.out.println(nome + " risultato: " + op.esegui(a, b));
    }

}