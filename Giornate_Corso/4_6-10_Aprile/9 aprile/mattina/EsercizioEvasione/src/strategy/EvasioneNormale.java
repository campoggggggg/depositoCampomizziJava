package strategy;

public class EvasioneNormale implements StrategiaEvasione {

    @Override
    public void esegui(double prezzo) {
        System.out.println("Ordine evaso con procedura standard." + (prezzo * 1.05));
    }

}