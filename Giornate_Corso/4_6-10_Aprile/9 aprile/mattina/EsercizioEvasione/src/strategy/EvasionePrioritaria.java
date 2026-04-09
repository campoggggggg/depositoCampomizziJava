package strategy;

public class EvasionePrioritaria implements StrategiaEvasione {

    @Override
    public void esegui(double prezzo) {
        System.out.println("Ordine evaso con corsia prioritaria." + (prezzo * 1.15));
    }

}