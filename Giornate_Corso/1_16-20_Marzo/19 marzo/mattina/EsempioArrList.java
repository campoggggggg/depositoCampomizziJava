import java.util.ArrayList;
import java.util.Collections;

public class EsempioArrList{
    public static void main(String[] args){

        ArrayList<Integer> numeri = new ArrayList<>();
        numeri.add(10);
        numeri.add(20);
        numeri.add(30);

//#endregion
        ArrayList<String> nomi = new ArrayList<>();
        nomi.add("Alice");
        nomi.add("Bob");
        nomi.add("Carlo");

        System.out.println("Primo nome: " + nomi.get(0));
        
//#endregion
        ArrayList<Integer> numbers = new ArrayList<>();

        //add 10 random num
        for (int i = 0; i < 10 ; i++) {
            numbers.add((int) (Math.random() * 100) + 1);
        }

        //stampa lista originale
        System.out.println("Lista originale: " + numbers);

        //ordinamento
        Collections.sort(numbers);

        //stampa ordinata
        System.out.println("Lista ordinata: " + numbers);

    }
}