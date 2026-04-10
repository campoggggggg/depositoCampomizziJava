package decorator;

//seconda classe concreta implementa l'interfaccia Computer 
public class ComputerBaseUfficio implements Computer{
    @Override
    public String getDescrizione() {
        return "PC ufficio base";
    }

    @Override
    public double getPrezzo() {
        return 400.0;
    }
}
