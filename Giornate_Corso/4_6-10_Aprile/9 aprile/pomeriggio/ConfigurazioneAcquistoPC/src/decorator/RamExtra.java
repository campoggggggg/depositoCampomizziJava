package decorator;

public class RamExtra extends DecoratoreComputer {

    public RamExtra(Computer computer) {
        super(computer);
    }
    
    public String getDescrizione() {
        return computer.getDescrizione() + " + Ram extra";
    }

    public double getPrezzo () {
        return computer.getPrezzo() + 50.0;
        
    }

}
