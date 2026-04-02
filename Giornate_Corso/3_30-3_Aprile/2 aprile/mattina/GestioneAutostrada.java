import java.util.ArrayList;
import java.util.Scanner;

abstract class Veicolo {
    //incapsulamento att private, accessi controllati da get e modifica con set
    private String targa;
    private double velocita;
    private int numeroAssi;

    Veicolo(String targa, double velocita, int numeroAssi) {
        this.targa = targa;
        setVelocita(velocita);
        setNumeroAssi(numeroAssi);
    }

    public String getTarga() {
        return targa;
    }

    public double getVelocita() {
        return velocita;
    }

    public int getNumeroAssi() {
        return numeroAssi;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public void setVelocita(double velocita) {
        if (velocita >= 0) {
            this.velocita = velocita;
        } else {
            System.out.println("Errore velocità deve essere positiva");
        }
    }

    public void setNumeroAssi(int numeroAssi) {
        if (numeroAssi >= 1 && numeroAssi <= 6) {
            this.numeroAssi = numeroAssi;
        } else {
            System.out.println("Errore numero assi non valido");
        }
    }

    public abstract double calcolaPedaggio();

    public String toString() {
        return "Targa: " + targa +
            " | Velocita max: " + velocita +
            " | Assi: " + numeroAssi;
    }
}

//classi ereditano dalla super Veicolo

class Auto extends Veicolo {
    private double peso;
    Auto(String targa, double velocita, int numeroAssi, double peso) {
        super(targa, velocita, numeroAssi);
        this.peso = peso;
    }

    public double calcolaPedaggio(){
        if (peso >= 400) {
            return 12.99;
        } else return 8.99;
    }

    @Override //polimorfismo, estende il toString del super
    public String toString() {
        return "##Auto##\n" + super.toString() + " | Peso: " + peso;
    }
}

class Camion extends Veicolo {
    private String tipoCarico;
    Camion(String targa, double velocita, int numeroAssi, String tipoCarico) {
        super(targa, velocita, numeroAssi);
        this.tipoCarico = tipoCarico;
    }

    public double calcolaPedaggio() {
        if (tipoCarico.equals("eccezionali")) {
            return 19.99;
        } else if (tipoCarico.equals("scomponibili")) {
            return 15.99;
        } else return 0;
    }

    @Override
    public String toString() {
        return "##Camion##\n" + super.toString() + " | Tipo carico: " + tipoCarico;
    }
}

class Moto extends Veicolo {
    private int cilindrata;
    Moto(String targa, double velocita, int numeroAssi, int cilindrata) {
        super(targa, velocita, numeroAssi);
        this.cilindrata = cilindrata;
    }

    public double calcolaPedaggio() {
        if (cilindrata >= 250) {
            return 14.99;
        } else return 8.99;
    }

    @Override
    public String toString() {
        return "##Moto##\n" + super.toString() + " | Cilindrata: " + cilindrata;
    }
}

public class GestioneAutostrada {
    public static void main (String[] args) {
        ArrayList<Veicolo> veicoli = new ArrayList<>();

        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        boolean continua = true;

        while (continua) {
            System.out.println("\n=== MENU AUTOSTRADALE ===");
            System.out.println("1. Aggiungi Auto");
            System.out.println("2. Aggiungi Camion");
            System.out.println("3. Aggiungi Moto");
            System.out.println("4. Mostra veicoli e pedaggi");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            int scelta = scannerNum.nextInt();

            switch (scelta) {
                case 1:
                    // da implementare: leggi dati, crea Auto, aggiungi a veicoli
                    System.out.println("Targa: ");
                    String targa = scannerStr.nextLine();
                    System.out.println("Velocità Max: ");
                    double velocita = scannerNum.nextDouble();
                    System.out.println("Numero assi: ");
                    int numeroAssi = scannerNum.nextInt();
                    System.out.println("Peso: ");
                    double peso = scannerNum.nextDouble();

                    //polimorfismo
                    veicoli.add(new Auto(targa, velocita, numeroAssi, peso));
                    break;
                case 2:
                    System.out.println("Targa: ");
                    String targa2 = scannerStr.nextLine();
                    System.out.println("Velocità Max: ");
                    double velocita2 = scannerNum.nextDouble();
                    System.out.println("Numero assi: ");
                    int numeroAssi2 = scannerNum.nextInt();
                    System.out.println("Tipo carico: ");
                    String tipoCarico = scannerStr.nextLine();

                    //polimorfismo
                    veicoli.add(new Camion(targa2, velocita2, numeroAssi2, tipoCarico));
                    break;
                case 3:
                    System.out.println("Targa: ");
                    String targa3 = scannerStr.nextLine();
                    System.out.println("Velocità Max: ");
                    double velocita3 = scannerNum.nextDouble();
                    System.out.println("Numero assi: ");
                    int numeroAssi3 = scannerNum.nextInt();
                    System.out.println("Cilindrata: ");
                    int cilindrata = scannerNum.nextInt();

                    //polimorfismo
                    veicoli.add(new Moto(targa3, velocita3, numeroAssi3, cilindrata));
                    break;
                case 4:
                    // polimorfismo: ogni veicolo chiama il proprio calcolaPedaggio()
                    for (int i = 0; i < veicoli.size(); i++) {
                        System.out.println(veicoli.get(i));
                        System.out.println("Pedaggio: " + veicoli.get(i).calcolaPedaggio());
                        System.out.println("---");
                    }
                    break;
                case 0:
                    System.out.println("Uscita.");
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
        scannerNum.close();
        scannerStr.close();
    }
    
    
}
