package decorator;

//decoratore astratto. implementa interfaccia astratta
public abstract class DecoratoreComputer implements Computer{
    protected Computer computer;

    public DecoratoreComputer(Computer computer) {
        this.computer = computer;
    }

    /*
    @Override
    public String getDescrizione() {
        return decoratorePC.getDescrizione();
    }
    
    @Override
    public double getPrezzo() {
        return decoratorePC.getPrezzo();
    }
    */
    
}
