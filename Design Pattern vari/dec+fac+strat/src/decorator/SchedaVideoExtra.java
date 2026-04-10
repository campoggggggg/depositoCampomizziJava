package decorator;

public class SchedaVideoExtra extends DecoratoreComputer{

    public SchedaVideoExtra(Computer computer) {
        super(computer);
    }
    
    public String getDescrizione() {
        return computer.getDescrizione() + " + Scheda video extra";
    }

    public double getPrezzo () {
        return computer.getPrezzo() + 180.0;
        
    }
}
