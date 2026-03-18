import java.util.Scanner;
public class EsempioDoWhile {
    public static void main(String[] args){
    Scanner scanner2 = new Scanner(System.in);
    int numero;

        do {
            System.out.print("Inserisci un numero do-while (0 per uscire): ");
            numero = scanner2.nextInt();
        } while (numero != 0);

        System.out.println("Hai inserito 0, Programma terminato");
    }
}