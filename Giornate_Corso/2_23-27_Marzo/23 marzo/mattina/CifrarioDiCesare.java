import java.util.Scanner;

/*
da correggere. String è già un'array, non c'è
*/

public class CifrarioDiCesare {
    public static void main(String[] args) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //array dell'alfabeto

        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        System.out.println("Inserisci la FRASE da decryptare");
        String myPhrase = scannerStr.nextLine();

        System.out.println("Inserisci la CHIAVE");
        int myKey = scannerInt.nextInt();

        //array temporaneo. Trasformo la frase in un array di char per poterlo scorrere
        char temp[] = myPhrase.toCharArray();

        for (int i = 0; i < temp.length; i++) { //scorri la frase
            for (int j = 0; j < alphabet.length; j++){ //scorri l'alfabeto
                if (temp[i] == alphabet[j]) { // se c'è corrispondenza
                    temp[i] = alphabet[(j + myKey) % 26]; //il char nella frase diventa uguale a quello nell'alfabeto spostato di myKey-posizioni
                    break; //esce dal for (su j). Non serve controllare le altre lettere
                }
            }
        }

        String newPhrase = String.copyValueOf(temp);//trasforma l'array di char in uno string
        System.out.println("La nuova frase è: " + newPhrase);
    }

}
