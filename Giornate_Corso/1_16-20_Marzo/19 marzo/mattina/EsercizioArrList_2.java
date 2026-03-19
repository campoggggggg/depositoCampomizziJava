import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EsercizioArrList_2 {
    public static void main(String[] args){

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Float> grades = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        ArrayList<ArrayList<Object>> student = new ArrayList<>();


        String tempName;
        float tempGrade;
        int tempAge;
        int select;

        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        //blocco menù con le opzioni
        do {
            System.out.println("Menù:\n1. Aggiungi nome\n2. Visualizza\n3. Cerca\n4. Rimuovi\n5. Modifica\n6. Esci");
            select = scannerInt.nextInt();

            switch (select) {
                case 1:
                    System.out.println("Scrivi il nome da inserire: ");
                    tempName = scannerStr.nextLine();
                    names.add(tempName);
                    System.out.println("Età: ");
                    tempAge = scannerInt.nextInt();
                    ages.add(tempAge);
                    System.out.println("Voto: ");
                    tempGrade = scannerInt.nextInt();
                    grades.add(tempGrade);
                    System.out.println("------------------");

                    break;

                case 2:
                    if (names.size() == 0) {
                        System.out.println("La lista è vuota.");
                        System.out.println("------------------");
                    } else { //stampa la lista dove ogni persona ha voto ed età corrispondente
                        System.out.println("La lista è: ");
                        for (int i = 0; i < names.size(); i++) {
                            System.out.println("Nome: " + names.get(i));
                            System.out.println("Età: " + ages.get(i));
                            System.out.println("Voto: " + grades.get(i));
                            System.out.println("------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Scrivi il nome da cercare: ");
                    tempName = scannerStr.nextLine();
                    for (int i = 0; i < names.size(); i++) {
                        if(names.get(i).toLowerCase().equals(tempName.toLowerCase())) { //check iterativo "nomeScritto" con ogni nome nella lista
                            System.out.println("Nome trovato! in posizione: " + (i + 1));
                            System.out.println("------------------");
                        } else {
                            System.out.println("Nome non trovato");
                            System.out.println("------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Scrivi il nome da eliminare: ");
                    tempName = scannerStr.nextLine();
                    for (int i = 0; i < names.size(); i++) {    //check iterativo ma qui elimina
                        if(names.get(i).toLowerCase().equals(tempName.toLowerCase())) {
                            names.remove(i);
                            System.out.println("Nome rimosso.");
                            System.out.println("------------------");
                        } else {
                            System.out.println("Nome non trovato");
                            System.out.println("------------------");
                        }
                    }
                    break;
                
                case 5:
                    //codice
                    break;

                case 6:
                    System.out.println("Arrivederci!");
                    break;

                default:
                    System.out.println("Valore invalido! Riprova.");
                    System.out.println("------------------");
                select = 1; //se si mette un valore invalido, select torna su 1 per rientrare nel ciclo
            }
        } while(select != 5);

        scannerInt.close();
        scannerStr.close();


    }
    
}
