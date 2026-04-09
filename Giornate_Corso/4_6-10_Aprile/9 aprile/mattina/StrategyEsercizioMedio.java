import java.util.Scanner;

public class StrategyEsercizioMedio {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CC carta = new CC();
        PP paypal = new PP();

        PagamentoContext context = new PagamentoContext(carta);

        int scelta;

        System.out.print("Importo da pagare: ");
        double imp = sc.nextDouble();


        System.out.println("\n--- METODO DI PAGAMENTO ---");
        System.out.println("1. Carta di credito");
        System.out.println("2. PayPal");
        System.out.println("0. Esci");
        System.out.print("Scelta: ");
        scelta = sc.nextInt();

        switch(scelta) {
            case 1:
                context.setMetodo(carta);
                context.eseguiPagamento(imp);
                break;
            
            case 2:
                context.setMetodo(paypal);
                context.eseguiPagamento(imp);
                break;

            default:
                System.out.println("Scelta non valida.");

        }

    }
}


/*
    INTERFACCIA STRATEGY
*/
interface MetodoPagamento {
    void paga(double importo);
}


/*
    STRATEGIE CONCRETE
*/
class CC implements MetodoPagamento {

    @Override
    public void paga(double importo) {
        System.out.println("Pagato con carta di credito. Importo: " + importo + "E");
    }

}

class PP implements MetodoPagamento {

    @Override
    public void paga(double importo) {
        System.out.println("Pagato con carta di credito. Importo: " + importo + "E");
    }

}


/*
    CONTEXT
*/
class PagamentoContext {

    private MetodoPagamento metodo;

    public PagamentoContext(MetodoPagamento metodo) {
        this.metodo = metodo;
    }

    public void setMetodo(MetodoPagamento metodo) {
        this.metodo = metodo;
    }

    public void eseguiPagamento(double imp) {
        metodo.paga(imp);
    }

}
