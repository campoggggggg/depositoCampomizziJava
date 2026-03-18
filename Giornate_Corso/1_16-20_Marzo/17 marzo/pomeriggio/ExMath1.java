import java.util.Scanner;

public class ExMath1 {
    public static void main(String[] args) {
        //fase di input
        Scanner myNum = new Scanner(System.in);
        System.out.println("Inserisci un numero: ");
        int Num1 = myNum.nextInt();
        System.out.println("Inserisci un altro numero: ");
        int Num2 = myNum.nextInt();

        //operazioni mateamtiche
        System.out.println("Il Max tra i due è: " + Math.max(Num1, Num2));    
        System.out.println("Il min tra i due è: " + Math.min(Num1, Num2));    
        System.out.println("La radice quadrata del primo è: " + Math.sqrt(Num1));        
        System.out.println("Il valore assoluto del secondo è: " + Math.abs(Num2));
    }
}
