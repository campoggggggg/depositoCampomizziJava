import java.util.Scanner;

public class EsercizioFunzioni {

    static int factorial (int n) {
        int temp = 1;
        while (n > 1) {
            temp = temp * n;
            n = n - 1;
        }
        return temp;
    }

    static void factorial (String n) {
        System.out.println("Inserisci un numero valido.");
    }

    public static void main(String[] args) {
        
        Scanner scannerStr = new Scanner(System.in);
        System.out.println("Inserisci il numero: ");
        String str = scannerStr.nextLine();

        if (!str.matches("[0-9]+")) { //verifica che la stringa sia solo cifre (idea non mia)
            factorial (str);
        } else {
            int num = Integer.parseInt(str);
            int risultato = factorial(num);
            System.out.println("Il fattoriale è: " + risultato);
        }

    }
    
}
