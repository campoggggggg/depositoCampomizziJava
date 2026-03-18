import java.util.Scanner;

public class EsercizioBancomat {
    public static void main(String[] args) {
        float credit = 1000;
        System.out.println("Credito iniziale: 1000E");

        Scanner scanner = new Scanner(System.in);
        int select;
        int withdrawal;
        int deposit;

        do {
            System.out.println("\nScegliere un'opzione:\n1. Visualizza saldo\n2. Preleva\n3. Deposita\n4. Esci");
            select = scanner.nextInt();

            switch (select) {
                case 1: //visualizza saldo
                    System.out.println("Saldo attuale: " + credit + "E");
                    break;
                case 2: //preleva
                    System.out.println("Inserire importo da prelevare: ");
                    withdrawal = scanner.nextInt();
                    if (withdrawal > credit) {
                        System.out.println("Fondi insufficienti.");
                    } else {
                        credit -= withdrawal; //ritira i soldi, credito - prelievo
                        System.out.println("Ok. Nuovo credito: " + credit);
                    }
                    break;
                case 3:
                    System.out.println("Inserire importo da depositare: ");
                    deposit = scanner.nextInt();
                    credit += deposit;
                    System.out.println("Ok. Nuovo credito: " + credit);
                    break;
                case 4:
                    System.out.println("Arrivederci!");
                    select = 42; //esce dal while
                    break;
                default: //per scelta non valida
                    System.out.println("Scelta non valida");
                    select = 1; // solo per tornare nel while (il problema dell'usare il DoWhile per questi menù)
                    break;
            }
        } while (select > 0 && select < 5);

        scanner.close();
    }
    
}
