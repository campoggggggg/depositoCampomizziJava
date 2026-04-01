import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("GIACCA");
        super.mostraDettagli();
        System.out.println("Numero di bottoni: " + numeroBottoni);
        System.out.println("-----------------");
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
        System.out.println("PANTALONE");
    super.mostraDettagli();
    System.out.println("Tipo taglio: " + taglio);
    System.out.println("-----------------");
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
        System.out.println("GILET");
        super.mostraDettagli();
        if (conRever) {
            System.out.println("Reverse: sì.");
        } else {
            System.out.println("Reverse: no.");
        }
        System.out.println("-----------------");
    }
}

class ComponenteFinitura {
    private int codice;
    private static int codiceCounter = 3; //AL di capi prende i primi 3 numeri per l'id.
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
            System.out.println("Il prezzo deve essere maggiore di 0.");
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
        System.out.println("CRAVATTA");
        super.mostraDettagli();
        System.out.println("Larghezza: " + larghezza + " cm");
        System.out.println("-----------------");
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
        System.out.println("PAPILLON");
    super.mostraDettagli();
    System.out.println("Tipo di chiusura: " + tipoChiusura);
    System.out.println("-----------------");
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
        System.out.println("POCHETTE");
        super.mostraDettagli();
        if (conPieghe) {
            System.out.println("Con pieghe: sì.");
        } else {
            System.out.println("Con pieghe: no.");
        }
        System.out.println("-----------------");
    }
}

class Completo {
    private String nome;
    private ArrayList<CapoPrincipale> capi;
    private ArrayList<ComponenteFinitura> finiture;

    Completo (String nome) {
        this.nome = nome;
        this.capi = new ArrayList<>();
        this.finiture = new ArrayList<>();
    }

    public void aggiungiCapo (CapoPrincipale capo) {
        capi.add(capo);
    }

    public void aggiungiFinitura (ComponenteFinitura finitura) {
        finiture.add(finitura);
    }

    public String getNome() {
        return nome;
    }

    public void mostraCompleto () {
        System.out.println("\n####CAPI PRINCIPALI####\n");
        for (CapoPrincipale c : capi) {
            c.mostraDettagli();
        }
        System.out.println("\n#######FINITURE#######\n");
        for (ComponenteFinitura f : finiture) {
            f.mostraDettagli();
        } 
    }

    public float prezzoTotale() {
        float tot = 0;

        for (CapoPrincipale c : capi) {
            tot += c.getPrezzo();
        }
        
        for (ComponenteFinitura f : finiture) {
            tot += f.getPrezzo();
        }
        return tot;
    }
}

public class GestoreSartoria {
    public static void main (String[] args) {
        Scanner scannerNum = new Scanner(System.in);
        //Scanner scannerStr = new Scanner(System.in);

        ArrayList<Completo> completi = new ArrayList<>();
        ArrayList<CapoPrincipale> capi = new ArrayList<>();
        ArrayList<ComponenteFinitura> finiture = new ArrayList<>();

        //popolo AL con oggetti prefef
        Giacca g1 = new Giacca("Sonic", "Tela", "blu", "XL", 99.99f, 3);
        Pantalone p1 = new Pantalone("Sonic", "tela", "blu", "XL", 49.99f, "lungo");
        Gilet j1 = new Gilet("Sonic", "tela", "grigio", "XL", 35.99f, false);
        Cravatta c1 = new Cravatta("Sonic", "cotone", "blu scuro", 19.99f, 10);
        Papillon pap1 = new Papillon("Sonic", "Tela", "Blu scuro", 19.99f, "Clip");
        Pochette poc1 = new Pochette("Sonic", "Pelle", "Blu", 19.99f, false);

        capi.add(g1); finiture.add(c1);
        capi.add(p1); finiture.add(pap1);
        capi.add(j1); finiture.add(poc1);

        Completo completoSonic = new Completo("Sonic");
        completoSonic.aggiungiCapo(g1);
        completoSonic.aggiungiCapo(p1);
        completoSonic.aggiungiCapo(j1);
        completoSonic.aggiungiFinitura(c1);
        completoSonic.aggiungiFinitura(pap1);
        completoSonic.aggiungiFinitura(poc1);

        Giacca g2 = new Giacca("Super Mario", "Cotone", "rosso", "M", 89.99f, 5);
        Pantalone p2 = new Pantalone("Super Mario", "Denim", "blu", "M", 44.99f, "corto");
        Gilet j2 = new Gilet("Super Mario", "Cotone", "rosso", "M", 29.99f, true);
        Cravatta c2 = new Cravatta("Super Mario", "Seta", "rosso", 24.99f, 8);
        Papillon pap2 = new Papillon("Super Mario", "Cotone", "rosso", 14.99f, "Nodo");
        Pochette poc2 = new Pochette("Super Mario", "Seta", "rosso", 14.99f, true);

        capi.add(g2); finiture.add(c2);
        capi.add(p2); finiture.add(pap2);
        capi.add(j2); finiture.add(poc2);

        Completo completoMario = new Completo("Super Mario");
        completoMario.aggiungiCapo(g2);
        completoMario.aggiungiCapo(p2);
        completoMario.aggiungiCapo(j2);
        completoMario.aggiungiFinitura(c2);
        completoMario.aggiungiFinitura(pap2);
        completoMario.aggiungiFinitura(poc2);


        Giacca g3 = new Giacca("Yoshi", "Lino", "verde", "L", 79.99f, 2);
        Pantalone p3 = new Pantalone("Yoshi", "Lino", "bianco", "L", 39.99f, "lungo");
        Gilet j3 = new Gilet("Yoshi", "Lino", "verde", "L", 25.99f, false);
        Cravatta c3 = new Cravatta("Yoshi", "Cotone", "verde", 17.99f, 6);
        Papillon pap3 = new Papillon("Yoshi", "Lino", "verde", 12.99f, "Velcro");
        Pochette poc3 = new Pochette("Yoshi", "Cotone", "bianco", 12.99f, false);

        capi.add(g3); finiture.add(c3);
        capi.add(p3); finiture.add(pap3);
        capi.add(j3); finiture.add(poc3);

        Completo completoYoshi = new Completo("Yoshi");
        completoYoshi.aggiungiCapo(g3);
        completoYoshi.aggiungiCapo(p3);
        completoYoshi.aggiungiCapo(j3);
        completoYoshi.aggiungiFinitura(c3);
        completoYoshi.aggiungiFinitura(pap3);
        completoYoshi.aggiungiFinitura(poc3);

        Giacca g4 = new Giacca("Pikachu", "Velluto", "giallo", "S", 109.99f, 4);
        Pantalone p4 = new Pantalone("Pikachu", "Velluto", "giallo", "S", 54.99f, "corto");
        Gilet j4 = new Gilet("Pikachu", "Velluto", "giallo", "S", 39.99f, true);
        Cravatta c4 = new Cravatta("Pikachu", "Seta", "giallo", 22.99f, 7);
        Papillon pap4 = new Papillon("Pikachu", "Velluto", "nero", 16.99f, "Clip");
        Pochette poc4 = new Pochette("Pikachu", "Seta", "giallo", 16.99f, true);

        capi.add(g4); finiture.add(c4);
        capi.add(p4); finiture.add(pap4);
        capi.add(j4); finiture.add(poc4);

        Completo completoPikachu = new Completo("Pikachu");
        completoPikachu.aggiungiCapo(g4);
        completoPikachu.aggiungiCapo(p4);
        completoPikachu.aggiungiCapo(j4);
        completoPikachu.aggiungiFinitura(c4);
        completoPikachu.aggiungiFinitura(pap4);
        completoPikachu.aggiungiFinitura(poc4);

        completi.add(completoSonic);
        completi.add(completoMario);
        completi.add(completoYoshi);
        completi.add(completoPikachu);

        //inizio menù
        boolean continua = true;

        while (continua) {
            System.out.println("\n--- Lista di tutti i completi ---\n");
            
            for (int i = 0; i < completi.size(); i++) {
                System.out.println((i + 1) + ". " + completi.get(i).getNome()); //stampa lista dei completi disponibili
            }

            System.out.println("0. Esci\n");

            int scelta = scannerNum.nextInt();

            if (scelta >= 1 && scelta <= completi.size()) {
                completi.get(scelta - 1).mostraCompleto();
                System.out.println("Prezzo totale: " + completi.get(scelta - 1).prezzoTotale());
            } else if (scelta == 0) {
                continua = false;
            } else {
                System.out.println("Scelta non valida");
            }
        }

        scannerNum.close();
        //scannerStr.close();
    }
}