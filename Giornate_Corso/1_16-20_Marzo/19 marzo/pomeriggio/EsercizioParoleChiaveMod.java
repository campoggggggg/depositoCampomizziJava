public class EsercizioParoleChiaveMod {

    static double sommaBase(double a, double b) {
        return a + b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }
    static double multiply(double a, double b, double c) {
        return a * b * c;
    }

    static int sumFirstN(int n) {
        if (n == 1) return 1;
        return (n + sumFirstN(n - 1));
    }

    
    static int modifyPrimitive (double a) {
        return (int) a;
    }

    static void modifyArray (double arr[]) {
        arr[0] = 0;
    }


    //main
    public static void main(String[] args){
        System.out.println("La funzione sommaBase: ");
        System.out.println(sommaBase(3.14, 2.71));
        System.out.println("-----------------------");
        System.out.println("La funzione sumFirstN: ");
        System.out.println(sumFirstN(100));
        System.out.println("-----------------------");

        int x = multiply(3, 4);
        System.out.println("int: " + x);
        double y = multiply(3.14, 2.71, 5.68);
        System.out.println("double: " + y);

        System.out.println("-----------------------");


        double numero = 123.456789;
        System.out.println(modifyPrimitive(numero));


        System.out.println("-----------------------");

        int array[] = {10, 21, 32};

    }
    
}
