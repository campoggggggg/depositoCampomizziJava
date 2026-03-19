import java.util.Scanner;

public class EsercizioCalcolatrice {

    static float somma (float a, float b) {
        return a + b;
    }

    static float sottrazione (float a, float b) {
        return a - b;
    }

    static float moltiplicazione (float a, float b) {
        return a * b;
    }

    static float divisione (float a, float b) {
        if (b == 0) {
            System.out.println("Err div0");
            return 42;
        } else {
            return a / b;
        }
    }

    static float potenza (float a, float b) { //fa schifo, poi mi metto a pensarla ricorsiva
        if (b == 0) return 1; //base
        if (b == 1) return a;
        if (b == 2) return a*a;

        while (b  > 2) {    //2 perche ho un prodotto base a*a che prende due numeri tra i b possibili. 
            a *= a;
            b = b - 1;  //b scende di uno. se > 2, moltiplico di nuovo per a, sennò ho finito.
        }
        return a;
    }

    public static void main(String[] args) {
        
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        int select, tot;
        float a, b;
        String confirm;



        do {
            System.out.println("Menù:\n1. Somma\n2. Sottrazione\n3. Moltiplicazione\n4. Divisione\n5. Potenza\n6. Esci");
            select = scannerInt.nextInt();
            switch (select) {
                case 1:
                    System.out.println("Inserisci il primo: ");
                    a = scannerInt.nextFloat();
                    System.out.println("il secondo: ");
                    b = scannerInt.nextFloat();
                    do {
                        System.out.println("Vuoi inserirne un altro? (s/n)");
                        confirm = scannerStr.nextLine();
                        if (confirm.equals("s")){ //se vuole, inserisce un altro
                            a = somma(a, b); 
                            System.out.println("Inserisci: ");
                            b = scannerInt.nextFloat();         // cosi in a registro la somma dei primi due, in b ho il nuovo numero.
                        } else if (!confirm.equals("n")) {
                            System.out.println("Valore non valido. inserisci (s/n).");
                        }
                    } while (!confirm.equals("s") || !confirm.equals("n"));

                    System.out.println("La loro somma è: " + somma(a, b));
                    break;

                case 2:
                    System.out.println("Inserisci 2 numeri: ");
                    System.out.println("il primo: ");
                    a = scannerInt.nextFloat();
                    System.out.println("il secondo: ");
                    b = scannerInt.nextFloat();
                    System.out.println("La loro sottrazione è: " + sottrazione(a, b));
                    break;

                case 3:
                    System.out.println("Inserisci 2 numeri: ");
                    System.out.println("il primo: ");
                    a = scannerInt.nextFloat();
                    System.out.println("il secondo: ");
                    b = scannerInt.nextFloat();
                    do {
                        System.out.println("Vuoi inserirne un altro? (s/n)");
                        confirm = scannerStr.nextLine();
                        if (confirm.equals("s")){ //se vuole, inserisce un altro
                            a = moltiplicazione(a, b); 
                            System.out.println("Inserisci: ");
                            b = scannerInt.nextFloat();         // cosi in a registro la moltiplicazione dei primi due, in b ho il nuovo numero.
                        } else if (!confirm.equals("n")) {
                            System.out.println("Valore non valido. inserisci (s/n).");
                        }
                    } while (!confirm.equals("s") || !confirm.equals("n"));

                    System.out.println("La loro moltiplicazione è: " + moltiplicazione(a, b));
                    break;

                case 4:
                    System.out.println("Inserisci 2 numeri: ");
                    System.out.println("numeratore: ");
                    a = scannerInt.nextFloat();
                    System.out.println("denominatore: ");
                    b = scannerInt.nextFloat();
                    if (b == 0){    //eccezione per la divisione per 0
                        System.out.println("Err div0");
                    } else {
                    System.out.println("La loro divisione è: " + divisione(a, b));
                    }
                    break;

                case 5:
                    System.out.println("Inserisci 2 numeri: ");
                    System.out.println("il primo: ");
                    a = scannerInt.nextFloat();
                    System.out.println("il secondo: ");
                    b = scannerInt.nextFloat();
                    System.out.println("La potenza è: " + potenza(a, b));
                    break;
                case 6:
                    System.out.println("Arrivederci!");
                    break;

                default:
                    System.out.println("Valore invalido! scegli un numero tra 1 e 5.");
                    System.out.println("------------------");
                select = 1; //se si mette un valore invalido, select torna su 1 per rientrare nel ciclo
            }
        } while(select != 6); //se non selezioni esci, rientra nel ciclo
        
    }
}
