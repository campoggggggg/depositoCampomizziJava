import java.util.Scanner;
public class Ex17pome_2 {
    public static void main(String[] args) {
        //Input UN
        Scanner myText = new Scanner(System.in);
        System.out.println("Inserisci un Username: ");
        String Username = myText.nextLine();
        
        //Input psw
        System.out.println("Inserisci una Password: ");
        String Password = myText.nextLine();

        if (Username.toLowerCase().equals("admin") && Password.toLowerCase().equals("1234")) {
            System.out.println("Accesso consentito"); //se sono corretti
        } else if (!Username.toLowerCase().equals("admin") ^ !Password.toLowerCase().equals("1234")) {
            System.out.println("Credenziali errate"); //se solo uno è corretto
        } else System.out.println("Accesso negato"); //se sono entrambi sbagliati
    }
    
}
