package strategy;

public class PP implements MetodoPagamento {

    @Override
    public void paga(double importo) {
        System.out.println("Pagato con carta di credito. Importo: " + importo + "E");
    }

}