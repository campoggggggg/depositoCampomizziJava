public class ProvaFunzioni {
    static void saluta() {
    System.out.println("Ciao, mondo!");
    }

    static int somma(int a, int b) {
        return a + b;
    }

    static void mostra (int numero) {
        System.out.println("Numero: " + (10 + numero));
    }

    static void mostra (String testo) {
        System.out.println("Testo: " + testo);
    }

    public static void main(String[] args){
        saluta(); //chiamata del metodo
        System.out.println(somma(10, 20)); //output: 30

        mostra(10); //chiama int
        mostra("Francesco Totti"); //chiama String
    }
}