import java.util.ArrayList;
import java.util.Scanner;

abstract class VeicoloConsegna {
    protected String targa;
    protected float caricoMassimo;

    VeicoloConsegna (String targa, float caricoMassimo) {
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }

    public abstract void consegnaPacco(String destinazione, float pesoPacco);

    public void mostraInfo() {
        System.out.println("Targa: " + targa + " | Carico massimo: " + caricoMassimo + " kg");
    }
}

interface Tracciabile {
    void tracciaConsegna(String codiceTracking); //simula tracciabilità
}

class Furgone extends VeicoloConsegna {
    Furgone (String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    @Override
    public void consegnaPacco(String destinazione, float pesoPacco) {
        if (pesoPacco > caricoMassimo) {
            System.out.println("Pacco troppo pesante");
            return;
        }
        System.out.println("targa: " + targa + " consegna in via strada, con  destinazione " + destinazione);
    }
}

class Drone extends VeicoloConsegna implements Tracciabile {
    Drone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    @Override
    public void tracciaConsegna (String codiceTracking) {
        System.out.println("Tracking code: " + codiceTracking);
    }

    @Override
    public void consegnaPacco (String destinazione, float pesoPacco) {
        if (pesoPacco > caricoMassimo) {
            System.out.println("Pacco troppo pesante");
            return;
        }
        System.out.println("targa: " + targa + " volo in via strada, con  destinazione " + destinazione);
    }
}

public class EsercizioAstrazione1 {
    public static void main (String[] args) {
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        ArrayList<VeicoloConsegna> veicoli = new ArrayList<>();

        System.out.println("Tipo veicolo (1. Furgone, 2. Drone): ");
        int tipoVeicolo = scannerNum.nextInt();
        System.out.println("Targa: ");
        String targa = scannerStr.nextLine();
        System.out.println("Carico massimo: ");
        float caricoMassimo = scannerNum.nextFloat();

        if (tipoVeicolo == 1) {
            veicoli.add(new Furgone(targa, caricoMassimo));
        } else if (tipoVeicolo == 2) {
            veicoli.add(new Drone(targa, caricoMassimo));
        }

        for (VeicoloConsegna v : veicoli) {
            System.out.println("Destinazione: ");
            String destinazione = scannerStr.nextLine();
            System.out.println("Peso pacco: ");
            float pesoPacco = scannerNum.nextFloat();

            v.consegnaPacco(destinazione, pesoPacco);

            //se v è tracciabile (cioè ho implementato l'interfaccia Tracciabile)
            //allora t è tracciabile e posso chiamare il metodo tracciaConsegna
            if (v instanceof Tracciabile t) { 
                t.tracciaConsegna("TRACK123");
            }
        }
    }
}