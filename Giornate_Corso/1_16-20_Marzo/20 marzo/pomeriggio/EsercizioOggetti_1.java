class Libro {
    String titolo;
    String autore;
    double prezzo;
    static int totaleLibri;

    Libro(String titolo, String autore, double prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
        totaleLibri++;
    }

    void mostraInfo() {
        System.out.println("Titolo: " + titolo);
        System.out.println("Autore: " + autore);
        System.out.println("Prezzo: " + prezzo);
    }
}

public class EsercizioOggetti_1 {

    public static void main(String[] args) {
        Libro primoLibro = new Libro("Paperinik", "Elisa Penna", 5.99);
        Libro secondoLibro = new Libro("L'insostenibile leggerezza dell'essere", "M. Kundera", 9.99);
        
        /*
        primoLibro.titolo = "Paperinik";
        primoLibro.autore = "Elisa Penna";
        primoLibro.prezzo = 5.99;
        */
        

        /*
        secondoLibro.titolo = "L'insostenibile leggerezza dell'essere";
        secondoLibro.autore = "M. Kundera";
        secondoLibro.prezzo = 9.99;
        */
        
        primoLibro.mostraInfo();
        secondoLibro.mostraInfo();
        
    }
    
}
