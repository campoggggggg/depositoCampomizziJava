package decorator;

//decoratore concreto. 
public class RaffreddamentoExtra extends DecoratoreComputer{

    public RaffreddamentoExtra(Computer computer) {
        super(computer);
    }
    
    public String getDescrizione() {
        return computer.getDescrizione() + " + Raffreddamento extra";
    }

    public double getPrezzo () {
        return computer.getPrezzo() + 150.0;
        
    }
    
}
