public class ProvaArray {
    public static void main(String[] args){
        int[] valori = {1, 2, 3, 4, 5}; //iniz. diretta. Anche su java si conta la posizione da zero.

        int[] numeri = new int[5]; //Array dim. 5
        //una volta dichiarata la dimensione dell'array non può cambiare
    
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("Primo numero: " + numbers[0]); //accesso diretto

        //riempimento array con for
        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = i + 1;
        }

        //stampa elementi array
        System.out.println("Gli elementi dell'array sono: ");
        for (int i = 0; i < numeri.length; i++) {
            System.out.print(numeri[i] + " ");
        }

        //Array 2d := Matrici
        int[][] matrice = new int[3][3];

        //iniz. diretta
        int[][] matricePred = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };




    }
}
