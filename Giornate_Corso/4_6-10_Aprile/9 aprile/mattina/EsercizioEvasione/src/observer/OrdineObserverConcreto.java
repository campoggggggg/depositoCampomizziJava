package observer;

import ordine.Ordine;
import strategy.EvasioneControllata;
import strategy.EvasioneNormale;
import strategy.EvasionePrioritaria;

public class OrdineObserverConcreto implements OrdineObserver {
    private Ordine ordine;

    public OrdineObserverConcreto(Ordine ordine) {
        this.ordine = ordine;
    }

    @Override
    public void aggiorna(String statoCorrente) { //aggiorna direttamente lo stato corrente
        if (statoCorrente.equals("PRIORITA")) {
            ordine.setStrategiaCurr(new EvasionePrioritaria());
        } else if (statoCorrente.equals("CONTROLLO")) {
            ordine.setStrategiaCurr(new EvasioneControllata());
        } else {
            ordine.setStrategiaCurr(new EvasioneNormale());
        }
        System.out.println("Strategia aggiornata per stato: " + statoCorrente);    }
    
}