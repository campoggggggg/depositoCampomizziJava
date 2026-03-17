import java.util.Scanner;
public class Ex17pome {
    public static void main(String[] args) {
        //Input
        Scanner myUsername = new Scanner(System.in);
        System.out.println("Inserisci Username: ");
        String Username = myUsername.nextLine();

        if (Username.length() == 0) {
            System.out.println("Username non valido");
        } else if (Username.length() < 5) {
            System.out.println("Username troppo corto");
        } else System.out.println("Username valido");
    }
    
}
