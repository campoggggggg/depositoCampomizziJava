public class ProvaString {
    public static void main (String[] args){
        String txt = "Gabriele";
        System.out.println("La lunghezza di 'txt' è di: " + txt.length() + " lettere");
    
        System.out.println(txt.toUpperCase());  //printa tutto in MAIUSC
        System.out.println(txt.toLowerCase());//printa tutto in minusc

        System.out.println(txt.indexOf("le")); //se "e" allora output 5. Se "le" output = 6k

    }
    
}
