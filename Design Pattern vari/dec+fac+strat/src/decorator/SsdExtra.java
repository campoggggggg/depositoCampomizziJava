package decorator;

public class SsdExtra extends DecoratoreComputer{

    public SsdExtra(Computer computer) {
        super(computer);
    }
    
    public String getDescrizione() {
        return computer.getDescrizione() + " + SSD 1TB";
    }

    public double getPrezzo () {
        return computer.getPrezzo() + 120.0;
        
    }
}
