import java.util.Scanner;
import java.util.ArrayList;

class Auto {
    String targa;
    String modello;

    Auto(String targa, String modello) {
        this.targa = targa;
        this.modello = modello;
    }
}

class Officina {
    ArrayList<Auto> auto = new ArrayList<>();

    public void aggiungiAuto(Scanner scanner) {
        System.out.println("Targa: ");
        String targa = scanner.nextLine();

        System.out.println("Modello: ");
        String modello = scanner.nextLine();

        Auto nuovaAuto = new Auto(targa, modello);
        this.auto.add(nuovaAuto);

    }

    public void mostraAuto () {
        if(auto.isEmpty()) {
            System.out.println("Nessuna auto in officina.");
        } else {
            System.out.println("Auto in officina: ");
        for (int i = 0; i < auto.size(); i++){
            System.out.println((i + 1) + " - " + this.auto.get(i).targa + " | " + this.auto.get(i).modello);
        }
        }      
    }
}

public class GestioneOfficina {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Officina officina = new Officina();

        boolean continua = true;

        int counter = 0;


while (counter < 2) { //minimo 2 auto
    System.out.println("Aggiungi un'auto");
    officina.aggiungiAuto(scanner);
    counter++;
}

while (continua) {
    System.out.println("\nMENU:");
    System.out.println("1 - Aggiungi auto");
    System.out.println("2 - Mostra auto");
    System.out.println("0 - Esci");

    int scelta = scanner.nextInt();
    scanner.nextLine();

    switch (scelta) {
        case 1:
            officina.aggiungiAuto(scanner);
            break;
        case 2:
            officina.mostraAuto();
            break;
        case 0:
            continua = false;
            break;
        default:
            System.out.println("Scelta non valida");
    }
}
        
    }
    
}
