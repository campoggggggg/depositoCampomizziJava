import java.util.Scanner;
public class EsempioFor {
    public static void main(String[] args){
    
        Scanner scanner = new Scanner(System.in);

        //richiede numero all'utente
        System.out.println("Inserisci un numero: ");
        int numero = scanner.nextInt();

        //Stampa la tabellina del numero scelto
        System.out.println("Tabellina del " + numero + ": ");

        //Ciclo da 1 a 10
        for (int i = 1; i<=10; i++) {
            System.out.println(numero + "x" + i + " = " + (numero*i));
        }

    }
    
}
