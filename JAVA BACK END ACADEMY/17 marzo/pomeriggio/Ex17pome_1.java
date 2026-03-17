import java.util.Scanner;
public class Ex17pome_1 {
    public static void main(String[] args) {
        //Input username
        Scanner myUsername = new Scanner(System.in);
        System.out.println("Inserisci Username: ");
        String Username = myUsername.nextLine();

        if (Username.length() == 0) { //se l'utente mette un username vuoto, da non valido
            System.out.println("Username non valido");
        } else if (Username.length() < 5) { //qui se troppo corto
            System.out.println("Username troppo corto");
        } else System.out.println("Username valido");
    }
}