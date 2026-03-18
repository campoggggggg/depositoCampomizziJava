import java.util.Scanner;
public class EsercizioFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quanti voti vuoi inserire? ");
        int numVoti = scanner.nextInt();


        int voto;


        //Ciclo while di validazione
        while (numVoti <= 0){
            System.out.println("Numero non valido. Inserire un altro numero");
            numVoti = scanner.nextInt();
        }

            for (int i=0; i < numVoti; i++) {

                //do-while che controlla se il voto è fra 0 e 30
                do {
                    System.out.println("Inserisci il voto " + (i+1) + "-esimo");
                    voto = scanner.nextInt();
                    
                    if (voto < 0 || voto > 30){
                        System.out.println("Numero non valido.");
                    }

                } while (voto < 0 || voto > 30);

                //Dai la valutazione al voto
                if (voto >= 18 && voto < 24) {
                    System.out.println("Sufficiente.");
                } else if (voto >= 24) {
                    System.out.println("Buono/ottimo.");
                } else {
                    System.out.println("Insufficiente.");
                }
        }

        System.out.println("Il numero totale di voti è: " + numVoti);
        scanner.close();
    }
}
