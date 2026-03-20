class Persona {
    String nome;
    int età;
    String città;
    static int totalePersone;

    Persona(String nome, int età, String città){
        this.nome = nome;
        this.età = età;
        this.città = città;
        totalePersone++;
    }

    void mostraInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Età: " + età);
        System.out.println(città);
    }


}

public class EsercizioOggetti_2 {
    public static void main(String[] args){
        Persona persona1 = new Persona("Papà", 63, "Caracas");
        Persona persona2 = new Persona("Mamma", 60, "Monaco");

        persona1.mostraInfo();
        persona2.mostraInfo();
    }
    
}
