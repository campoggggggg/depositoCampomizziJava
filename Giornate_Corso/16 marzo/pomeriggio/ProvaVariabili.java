public class ProvaVariabili {
    public static void main(String[] args){
        //Char
        char provaChar = 'a';
        System.out.println(provaChar);
        //String
        String provaTesto = "Ciao Mondo";
        String testo = "Prova";
        System.out.println(testo.charAt(0)); //stampa 0_esima lettera della stringa

        //Stampa concatenata
        String testo2 = "Mondo";
        System.out.println("Ciao " + testo2);
        String firstPart = "Ciao ";
        String secondPart = "Mondo";
        String fullPart = firstPart + secondPart;
        System.out.println(fullPart);

        //int
        int provaNumero = 12;
        //valorizzazione seq e conc
        int x = 5, y = 6, z = 50;
        System.out.println(x+y+z);
        //oppure 
        int a, b, c;
        a = b = c = 50;
        System.out.println(a+b+c);
        //float
        float provaFloat = 3.14f;

        //boolean
        boolean provaBool;
        provaBool = false;
        provaBool = true;

        //Final var
        final int PROVANUMERO = 15;

        }
}
