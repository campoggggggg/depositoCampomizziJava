import java.util.Scanner;

public class SwitchEs {
    public static void main(String[] args){
        //input nome
        Scanner myName = new Scanner(System.in);
        System.out.println("Inserisci il tuo nome: ");
        String name = myName.nextLine();

        //input cognome
        Scanner mySurname = new Scanner(System.in);
        System.out.println("Inserisci il tuo cognome: ");
        String surname = mySurname.nextLine();

        //input password
        Scanner myPassword = new Scanner(System.in);
        System.out.println("Inserisci la password: ");
        String password = myPassword.nextLine();

        //input dell'OPZIONE da modificare
        Scanner myMod = new Scanner(System.in);
        System.out.println("Quale vuoi modificare? [nome | cognome | password] ");
        String mod = myMod.nextLine();

        switch(mod){ //switch tra nome, cognome, password
            case "nome":
                System.out.println("Inserisci di nuovo il tuo nome: ");
                name = myName.nextLine();
                break;
            case "cognome":
                System.out.println("Inserisci di nuovo il tuo cognome: ");
                surname = mySurname.nextLine();
                break;
            case "password":
                System.out.println("Inserisci di nuovo la password: ");
                password = myPassword.nextLine();
                break;
        }
        //printa tutto, con la modifica inclusa
        System.out.println("nome: " + name);
        System.out.println("cognome: " + surname);
        System.out.println("password: " + password);
    }
}
