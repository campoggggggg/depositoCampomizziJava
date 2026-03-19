public class ProvaFunzioni {
    static void saluta() {
    System.out.println("Ciao, mondo!");
    }

    static int somma(int a, int b) {
        return a + b;
    }

    public static void main(String[] args){
        saluta(); //chiamata del metodo
        System.out.println(somma(10, 20)); //output: 30
    }
}