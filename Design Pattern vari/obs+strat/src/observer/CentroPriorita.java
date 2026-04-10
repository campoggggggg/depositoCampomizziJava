package observer;

import java.util.ArrayList;

public class CentroPriorita {

    private String stato;
    private ArrayList<OrdineObserver> observers = new ArrayList<>();

    public CentroPriorita(String stato) {
        this.stato = stato;
    }

    public void aggiungiObserver(OrdineObserver o) {
        observers.add(o);
    }

    public void rimuoviObserver(OrdineObserver o) {
        observers.remove(o);
    }

    public void setStato(String stato) {
        this.stato = stato;
        notifica();
    }

    public String getStato() {
        return stato;
    }

    public void notifica() {
        for(OrdineObserver o : observers) {
            o.aggiorna(stato);
        }
    }
}