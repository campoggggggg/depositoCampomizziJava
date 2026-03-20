class Auto {
    //Attributi (variabili)
    String marca;
    int anno;
    double prezzo;

    //metodi (funzioni)
    void mostraInfo() {
        System.out.println(marca + " - " + anno + " - " + " E" + prezzo);
    }
}

class Studente {
    String nome; //var di istanza
    static int totaleStudenti = 0; // Var statica

    Studente(String nome) {
        this.nome = nome;
        totaleStudenti++; //incremento per ogni nuovo oggetto
    }
}

public class ProvaOggetti {
    public static void main(String[] args) {
        Auto miaAuto = new Auto();//creazione oggetto.   Auto() è un costruttore
        miaAuto.marca = "Tesla";
        miaAuto.anno = 2023;
        miaAuto.prezzo = 59999.99;

        miaAuto.mostraInfo();
    }
   
}