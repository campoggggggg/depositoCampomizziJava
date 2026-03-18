import java.util.Scanner;
public class EsempioCicli {
    public static void main(String[] args){
        int i = 1;  // inizializzo var

        while (i <= 5) {
            i++;    //incremento di 1
            System.out.println(i);  //printa ogni numero (2...6)
        }
        //#########################################################

        Scanner scanner = new Scanner(System.in);

        boolean continua = true; //var di controllo ciclo

        while(continua) {
            System.out.println("Inserischi un numero while (0 per uscire): ");
            int numero = scanner.nextInt();

            if (numero == 0) {
                continua = false; //rompe il ciclo
            } else {
                System.out.println("Hai inserito " + numero);
            }

        }

        System.out.println("Programma terminato");

        scanner.close();

    }
}
