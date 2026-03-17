import java.util.Scanner;
public class Ex17pome_3 {
    public static void main(String[] args) {
        //Input Sconto
        Scanner myDiscount = new Scanner(System.in);
        System.out.println("Inserisci un codice sconto: ");
        String discount = myDiscount.nextLine();
        
        //Input importo
        Scanner myAmount = new Scanner(System.in);
        System.out.println("Inserisci l'importo della spesa: ");
        double amount = myAmount.nextDouble();

        double correctAmount = (double) amount;
        
        if (discount.equals("SCONTO10")) {                  //col codice sconto SCONTO10, leva il 10% dal totale della spesa
            double newAmount = correctAmount - correctAmount*0.1;
            System.out.println("L'importo scontato è: " + newAmount);
        } else if (discount.equals("SCONTO20")) {           //col codice sconto SCONTO20, leva il 20% dal totale della spesa
            double newAmount = correctAmount - correctAmount*0.2;
            System.out.println("L'importo scontato è: " + newAmount);
        } else if (discount.equals("VIP")) {                //col codice sconto VIP, leva il 30% dal totale della spesa SSE la spesa è di 100+ 
            if(correctAmount >= 100) {
            double newAmount = correctAmount - correctAmount*0.3;
            System.out.println("L'importo scontato è: " + newAmount);
            }
        } else {                                                     //per codici non validi (nessuno dei 3 precedenti)
            System.out.println("Codice non valido");
        }
    }
    
}
