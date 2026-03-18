public class ProvaConcatenazione {
    public static void main (String[] args){
        String firstName = "Gabriele";
        String lastName = "Campomizzi";
        System.out.println(firstName + " " + lastName); //concateno in modo manuale
        System.out.println(firstName.concat(lastName)); //concateno con il metodo (non c'è lo spazio)
        
        //escape characters
        System.out.println("Print di prova: l\'animale. \"The Sopranos\". 5\\17"); //test print per escape characters

        //altri ec
        System.out.println("Wow! \nOra sono a capo. \tOra invece tabbo. \bqui faccio un backspace e vediamo il \fform feed. (form feed). Infine, \r carriamo.");

    }
}
