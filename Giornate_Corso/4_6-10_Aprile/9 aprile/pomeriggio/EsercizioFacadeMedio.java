public class EsercizioFacadeMedio {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade();

        computerFacade.accendiComputer();
    }
}

class Bios {
    void inizializza () {
        System.out.println("Inizializzazione bios...");
    }

    void carica () {
        System.out.println("Caricamento bios...");
    }

    void avvia () {
        System.out.println("Bios avviato!");
    }
}

class HardDisk {
    void inizializza () {
        System.out.println("Inizializzazione hard disk...");
    }

    void carica () {
        System.out.println("Caricamento hard disk...");
    }

    void avvia () {
        System.out.println("Hard disk avviato!");
    }
}

class SistemaOperativo {
    void inizializza () {
        System.out.println("Inizializzazione sistema operativo...");
    }

    void carica () {
        System.out.println("Caricamento sistema operativo...");
    }

    void avvia () {
        System.out.println("Sistema operativo avviato!");
    }
}

class ComputerFacade {
    Bios b;
    HardDisk hd;
    SistemaOperativo so;

    public ComputerFacade () {
        b = new Bios();
        hd = new HardDisk();
        so = new SistemaOperativo();
    }

    public void accendiComputer() {
        b.inizializza();
        b.carica();
        b.avvia();

        hd.inizializza();
        hd.carica();
        hd.avvia();

        so.inizializza();
        so.carica();
        so.avvia();
    }
}