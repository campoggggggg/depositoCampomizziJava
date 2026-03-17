import java.util.Arrays;
public class ProvaEscChar{
    public static void main(String[] args){
                
        //escape characters
        System.out.println("Print di prova: l\'animale. \"The Sopranos\". 5\\17"); //test print per escape characters

        //altri ec
        System.out.println("Wow! \nOra sono a capo. \tOra invece tabbo. \bqui faccio un backspace e vediamo il \fform feed. (form feed). Infine, \r carriamo.");

        //split frasi in un array di parole
        String str = "Hello World";
        String[] words = str.split("\\s");  //divide la stringa in un array quando vede uno spazio
        System.out.println(Arrays.toString(words)); //printo l'Array creato prima
    }
}