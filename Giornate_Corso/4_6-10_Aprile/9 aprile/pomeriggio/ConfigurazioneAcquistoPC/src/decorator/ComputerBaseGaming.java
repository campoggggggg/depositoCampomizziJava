package decorator;

//prima classe concreta implementa l'interfaccia Computer 
public class ComputerBaseGaming implements Computer{
    
    @Override
    public String getDescrizione() {
        return "PC gaming base";
    }

    @Override
    public double getPrezzo() {
        return 600.0;
    }
}
