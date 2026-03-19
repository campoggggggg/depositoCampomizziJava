public class EsempioRicorsione {

    int fattoriale (int n) {
        if (n==1) return 1;
        return n* fattoriale (n-1);
    }

    static void modifica(int[] arr) {
        arr[0] = 99; //questa modifica sarà visibile all'esterno
    }
    public static void main(String[] args) {
        
        int[] numeri = {1, 2 ,3};
        modifica(numeri);
        System.out.println(numeri[0]); //output 99
    }

}
