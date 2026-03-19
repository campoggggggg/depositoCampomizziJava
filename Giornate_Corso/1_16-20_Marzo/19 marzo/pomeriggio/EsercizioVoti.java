import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EsercizioVoti {


        static double calcolaMedia(ArrayList<Integer> voti) {
            int somma = 0;
            for (int i = 0; i < voti.size(); i++){
                somma += voti.get(i);
            }
            return somma/voti.size();
        }

        static int trovaMax (ArrayList<Integer> voti) {
            return Collections.max(voti);
        }

        static int trovaMin (ArrayList<Integer> voti) {
            return Collections.min(voti);
        }

        static String verificaPromozione(double media) {
            if (media >= 6) {
                return "Promosso.";
            } else {
                return "Bocciato.";
            }
        }



    public static void main(String[] args) {

        Scanner scannerNum = new Scanner(System.in);
        //Scanner scannerStr = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        //ArrayList<ArrayList<Object>> studentsAndGrades = new ArrayList<>();

        int totalNumberOfGrades;
        int select = 1, grade;


        System.out.println("Quanti voti vuoi inserire a studente? ");
        totalNumberOfGrades = scannerNum.nextInt();

        for (int i = 0; i < totalNumberOfGrades; i++) {
            System.out.println("Inserisci voto: ");
            grade = scannerNum.nextInt();
            grades.add(grade);
        }

        do {
            System.out.println("Menù:\n1. Media\n2. Voto più alto\n3. Voto più basso\n4. Verifica promozione\n5. Esci");
            select = scannerNum.nextInt();
            switch (select) {
                case 1:
                    System.out.println("La media è: " + calcolaMedia(grades));
                    break;

                case 2:
                    System.out.println("Il voto più alto è: " + trovaMax(grades));
                    break;

                case 3:
                    System.out.println("Il voto più basso è: " + trovaMin(grades));
                    break;

                case 4:
                    double media = calcolaMedia(grades);
                    System.out.println(verificaPromozione(media));
                    break;

                case 5:
                    System.out.println("Arrivederci!");
                    break;

                default:
                    System.out.println("Valore invalido! Riprova.");
                    System.out.println("------------------");
                    select = 1; //se si mette un valore invalido, select torna su 1 per rientrare nel ciclo
            }
        } while(select != 5);

        scannerNum.close();
    }
}
