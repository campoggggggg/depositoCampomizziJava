package eseBevande;

import java.util.ArrayList;

public class GestoreOrdini {
    private static GestoreOrdini instance;

    private Bevanda bevandaCorrente;
    private ArrayList<String> storicoOrdini = new ArrayList<>();

    //costruttore privato impedisce new GestoreOrdini all'esterno
    private GestoreOrdini() {}

    public static GestoreOrdini getInstance() {
        if (instance == null) {
            instance = new GestoreOrdini();
        }
        return instance;
    }

    //imposta bevanda base corrente
    public void setBevandaCorrente (Bevanda bevanda) {
        bevandaCorrente = bevanda;
    }

    //aggiungi decoratore alla bevanda corrente
    public void decoraBevandaCorrente (Bevanda bevandaDecorata) {
        bevandaCorrente = bevandaDecorata;
    }

    //getBevandaCorrente
    public Bevanda getBevandaCorrente() {
        return bevandaCorrente;
    }

    //stampa ordine corrente
    public void visualizzaOrdineCorrente() {
        if (bevandaCorrente == null) {
            System.out.println("Nessuna bevanda selezionata.");
            return;
        }
        System.out.println("Ordine corrente: " + bevandaCorrente.getDescrizione());
        System.out.printf("Costo totale: " + bevandaCorrente.getCosto());
    }

    //conferma ordine corrente
    public void confermaOrdine () {
        if (bevandaCorrente == null) {
            System.out.println("Nessuna bevanda selezionata.");
            return;
        }

        String riepilogo = bevandaCorrente.getDescrizione() + " | " + bevandaCorrente.getCosto() + "€";

        storicoOrdini.add(riepilogo);
        System.out.println("Ordine confermato: " + riepilogo);
        bevandaCorrente = null;
    }

    //stampa storico ordine
    public void visualizzaStorico() {
        if (storicoOrdini.isEmpty()) {
            System.out.println("Nessun ordine nello storico.");
            return;
        }

        System.out.println("── STORICO ORDINI ──");
        for (int i = 0; i < storicoOrdini.size(); i++) {
            System.out.println((i + 1) + ". " + storicoOrdini.get(i));
        }
    }
}