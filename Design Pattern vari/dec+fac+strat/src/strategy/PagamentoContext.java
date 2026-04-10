package strategy;

public class PagamentoContext {

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