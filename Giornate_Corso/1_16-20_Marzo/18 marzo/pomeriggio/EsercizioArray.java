import java.util.Scanner;

public class EsercizioArray {
    public static void main(String[] args) {
        //inizializzo
        String[] arrayDolci = new String[10];
        int[] qntDolci = new int[10];
        int totDolci = 0;

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        int numDolciDiversi;

        //chiedo quanti dolci voglio
        do {
        System.out.println("Quanti dolci diversi vuoi? ");
        numDolciDiversi = scannerInt.nextInt();

        if (numDolciDiversi > 10) { //check se ci sono troppi dolci
            System.out.println("Troppi dolci diversi. Riprova.");
        }

        } while (numDolciDiversi > 10);



        for ( int i = 0; i < numDolciDiversi; i++) {    //input array
            System.out.println("Che dolce vuoi? ");
            arrayDolci[i] = scannerString.nextLine();   //tipo dolce
            do {
                System.out.println("E quanti " + arrayDolci[i] + " vuoi? ");
                qntDolci[i] = scannerInt.nextInt();     //quantità dolce

                if(qntDolci[i] < 0) {
                    System.out.println("Non inserire una quantità negativa. Riprova.");
                }
            } while (qntDolci[i] < 0);                   //se la quantità non è min di 0
        }
        
        for ( int i = 0; i < numDolciDiversi; i++) { //stampo dolce e quantità vicino
            System.out.print(arrayDolci[i] + ": " + qntDolci[i] + " ");
        }

        for ( int i = 0; i < numDolciDiversi; i++) { //somma dolci totali
            totDolci += qntDolci[i];
        }
        System.out.println("Il numero totale di dolci è: " + totDolci);

        scannerInt.close();
        scannerString.close();
    }
}