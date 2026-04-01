///due famiglie di ogg diverse. una per i capi principali;
// una per le rifinitura
//setter controlla che prezzo sia maggiore di 0 e robe non vuote
class CapoPrincipale {
    private int codice;
    private static int codiceCounter = 0;
    private String nome;
    private String tessuto;
    private String colore;
    private String taglia;
    private float prezzo;

    CapoPrincipale(String nome, String tessuto, String colore, String taglia, float prezzo) {
        this.nome = nome;
        this.tessuto = tessuto;
        this.colore = colore;
        this.taglia = taglia;
        this.prezzo = prezzo;
        this.codice = ++codiceCounter;
    }

    public int getCodice() {
        return codice;
    }
    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome.isEmpty()) {
            System.out.println("Il nome non può essere vuoto.");
        } else {
            this.nome = nome;
        }
    }

    public String getTessuto() {
        return tessuto;
    }
    public void setTessuto(String tessuto) {
        if (tessuto.isEmpty()) {
            System.out.println("Il tessuto non può essere vuoto.");
        } else {
            this.tessuto = tessuto;
        }
    }

    public String getColore() {
        return colore;
    }
    public void setColore(String colore) {
        if (colore.isEmpty()) {
            System.out.println("Il colore non può essere vuoto.");
        } else {
            this.colore = colore;
        }
    }

    public String getTaglia() {
        return taglia;
    }
    public void setTaglia(String taglia) {
        if (taglia.isEmpty()) {
            System.out.println("La taglia non può essere vuota.");
        } else {
            this.taglia = taglia;
        }
    }

    public float getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(float prezzo) {
        if (prezzo <= 0) {
            System.out.println("Il prezzo deve essere maggiore di 0.");
        } else {
            this.prezzo = prezzo;
        }
    }

    public void mostraDettagli() {
        System.out.println("Codice: " + codice);
        System.out.println("Nome: " + nome);
        System.out.println("Tessuto: " + tessuto);
        System.out.println("Colore: " + colore);
        System.out.println("Taglia: " + taglia);
        System.out.println("Prezzo: " + prezzo);
    }

}

class Giacca extends CapoPrincipale {
    private int numeroBottoni;

    Giacca(String nome, String tessuto, String colore, String taglia, float prezzo, int numeroBottoni) {
        super(nome, tessuto, colore, taglia, prezzo);
        this.numeroBottoni = numeroBottoni;
    }

    @Override
    public void mostraDettagli() {
        super.mostraDettagli();
        System.out.println("Numero di bottoni: " + numeroBottoni);
    }
}

class Pantalone extends CapoPrincipale {
    private String taglio;

    Pantalone(String nome, String tessuto, String colore, String taglia, float prezzo, String taglio) {
        super(nome, tessuto, colore, taglia, prezzo);
        this.taglio = taglio;
    }

    @Override
    public void mostraDettagli() {
    super.mostraDettagli();
    System.out.println("Tipo taglio: " + taglio);
    }
}

class Gilet extends CapoPrincipale {
    private boolean conRever;
    Gilet(String nome, String tessuto, String colore, String taglia, float prezzo, boolean conRever) {
        super(nome, tessuto, colore, taglia, prezzo);
        this.conRever = conRever;
    }

    @Override
    public void mostraDettagli() {
        super.mostraDettagli();
        if (conRever) {
            System.out.println("Reverse: sì.");
        } else {
            System.out.println("Reverse: no.");
        }
    }
}

class ComponenteFinitura {
    private int codice;
    private static int codiceCounter = 0;
    private String nome;
    private String materiale;
    private String colore;
    private float prezzo;

    ComponenteFinitura(String nome, String materiale, String colore, float prezzo) {
        this.nome = nome;
        this.materiale = materiale;
        this.colore = colore;
        this.prezzo = prezzo;
        this.codice = ++codiceCounter;
    }

    public int getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome.isEmpty()) {
            System.out.println("Il nome non può essere vuoto.");
        } else {
            this.nome = nome;
        }
    }

    public String getMateriale() {
        return materiale;
    }
    public void setMateriale(String materiale) {
        if (materiale.isEmpty()) {
            System.out.println("Il materiale non può essere vuoto.");
        } else {
            this.materiale = materiale;
        }
    }

    public String getColore(){
        return colore;
    }
    public void setcolore(String colore) {
        if (colore.isEmpty()) {
            System.out.println("Il colore non può essere vuoto.");
        } else {
            this.colore = colore;
        }
    }
    
    public float getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(float prezzo) {
        if (prezzo <= 0) {
            System.out.println("Il prezzo deve essere maggiore di 0.")
        } else {
            this.prezzo = prezzo;
        }
    }

    public void mostraDettagli() {
        System.out.println("Codice: " + codice);
        System.out.println("Nome: " + nome);
        System.out.println("Materiale: " + materiale);
        System.out.println("Colore: " + colore);
        System.out.println("Prezzo: " + prezzo);
    }
}

class Cravatta extends ComponenteFinitura {
    private int larghezza; // in cm

    Cravatta(String nome, String materiale, String colore, float prezzo, int larghezza) {
        super(nome, materiale, colore, prezzo);
        this.larghezza = larghezza;
    }

    @Override
    public void mostraDettagli() {
        super.mostraDettagli();
        System.out.println("Larghezza: " + larghezza + " cm");
    }
}

class Papillon extends ComponenteFinitura {
    private String tipoChiusura;

    Papillon(String nome, String materiale, String colore, float prezzo, String tipoChiusura) {
        super(nome, materiale, colore, prezzo);
        this.tipoChiusura = tipoChiusura;
    }

    @Override
    public void mostraDettagli() {
    super.mostraDettagli();
    System.out.println("Tipo di chiusura: " + tipoChiusura);
    }
}

class Pochette extends ComponenteFinitura {
    private boolean conPieghe;

    Pochette(String nome, String materiale, String colore, float prezzo, boolean conPieghe) {
        super(nome, materiale, colore, prezzo);
        this.conPieghe = conPieghe;
    }

    @Override
    public void mostraDettagli() {
    super.mostraDettagli();
    if (conPieghe) {
        System.out.println("Con pieghe: sì.");
    } else {
        System.out.println("Con pieghe: no.");
    }
    
    }
}

public class GestoreSartoria {
    public static void main (String[] args) {
        ArrayList<CapoPrincipale> capi = new ArrayList<>();
        ArrayList<ComponenteFinitura> finiture = new ArrayList<>();

        
    }
}