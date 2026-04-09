package ordine;
import strategy.StrategiaEvasione;

public class Ordine {
    private int id;
    private String cliente;
    private String prodotto;
    private StrategiaEvasione strategiaCurr;
    private double prezzo;
    
    public Ordine(int id, String cliente, String prodotto, StrategiaEvasione strategiaCurr, double prezzo) {
        this.id = id;
        this.cliente = cliente;
        this.prodotto = prodotto;
        this.strategiaCurr = strategiaCurr;
        this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProdotto() {
        return prodotto;
    }

    public void setProdotto(String prodotto) {
        this.prodotto = prodotto;
    }

    public StrategiaEvasione getStrategiaCurr() {
        return strategiaCurr;
    }

    public void setStrategiaCurr(StrategiaEvasione strategiaCurr) {
        this.strategiaCurr = strategiaCurr;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    //FINE GETTER E SETTER

    public void eseguiEvasione() { 
        strategiaCurr.esegui(prezzo);
    }
    
}