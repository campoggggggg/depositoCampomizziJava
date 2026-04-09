package strategy;

public class EvasioneControllata implements StrategiaEvasione {

    @Override
    public void esegui(double prezzo) {
        System.out.println("Ordine evaso con verifica aggiuntiva." + (prezzo * 0.95));
    }

}