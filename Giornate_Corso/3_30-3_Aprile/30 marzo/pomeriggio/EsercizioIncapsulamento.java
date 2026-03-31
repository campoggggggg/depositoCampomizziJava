import java.util.Scanner;
import java.util.ArrayList;
import java.sql.*;

class Studente {
    private String nome;
    private double voto;
    private static int contatore = 0; //statico autoincrement
    private int id;

    Studente(String nome, double voto) {
        this.nome = nome;
        this.voto = voto;
        contatore++;
        this.id = contatore;
    }

    public String getNome() {
        return this.nome;
    }

    public double getVoto() {
        return this.voto;
    }

    public void setVoto(double nuovoVoto) {
        if (nuovoVoto < 0 || nuovoVoto > 10) {
            System.out.println("Voto non valido.");
        } else {
            this.voto = nuovoVoto;
        }
    }

    public void stampa() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Voto: " + this.voto);
        System.out.println("----");
    }

}


public class EsercizioIncapsulamento {
    public static void main (String[] args) {
        //prova connessione DB
        String host = "localhost";
        String port = "8889";
        String url = "jdbc:mysql://" + host + ":" + port + "/scuola";
        String user = "root";
        String psw = "Gastly1!";


        try (Connection conn = DriverManager.getConnection(url, user, psw)) {
            System.out.println("Connessione riuscita.");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM studenti");

            while (rs.next()) { //query che stampa tutti glis tudenti nel DB di SQL e aggiunti qui. PROBLEMA Gli ID sono incrementali ma indipendenti tra mySQL e Java
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Voto: " + rs.getDouble("voto"));
                System.out.println("----");
            }
        } catch (SQLException e) {  
            System.out.println("Errore: " + e.getMessage());
        }


        //chiaramente il DB è gestito solo qui. Il menù successivo non lo gestisce. da implementare

        Studente studente1 = new Studente("Gabriele", 4);
        //stampa dati studente
        System.out.println("Dati di prova (FUORI DAL DB mySQL)");
        studente1.stampa();
        
        //cambio voto (non valido)
        studente1.setVoto(-5);
        studente1.stampa(); //voto non cambia

        //cambio voto (valido)
        studente1.setVoto(6);
        studente1.stampa(); //voto cambia

        //gestire lista studenti tramite arraylist
        ArrayList<Studente> studenti = new ArrayList<>();
        studenti.add(studente1);

        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        boolean continua = true;

        while (continua) {
            System.out.println("\nMENU:");
            System.out.println("1 - Aggiungi studente");
            System.out.println("2 - Elimina studente");
            System.out.println("3 - Cerca studente");
            System.out.println("0 - Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = scannerNum.nextInt();

            switch (scelta) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scannerStr.nextLine();

                    System.out.print("Voto: ");
                    double voto = scannerNum.nextDouble();

                    Studente nuovoStudente = new Studente(nome, voto);
                    studenti.add(nuovoStudente);
                    break;
                case 2:
                    System.out.print("Nome studente da eliminare (dalla lista): ");
                    String nomeDaEliminare = scannerStr.nextLine();
                    boolean trovato1 = false;
                    for (int i = 0; i < studenti.size(); i++) {
                        if (studenti.get(i).getNome().equalsIgnoreCase(nomeDaEliminare)) {
                            System.out.println("Fatto. Studente " + studenti.get(i).getNome() + " eliminato.");
                            studenti.remove(i);
                            trovato1 = true;
                            break;
                        }
                    }
                    if (!trovato1) {
                        System.out.println("Studente non trovato.");
                    }
                    break;
                case 3:
                    System.out.print("Nome studente da cercare: ");
                    String nomeDaCercare = scannerStr.nextLine();
                    boolean trovato2 = false;
                    for (int i = 0; i < studenti.size(); i++) {
                        if (studenti.get(i).getNome().equalsIgnoreCase(nomeDaCercare)) {
                            studenti.get(i).stampa();
                            trovato2 = true;
                            break;
                        }
                    }
                    if (!trovato2) {
                        System.out.println("Studente non trovato.");
                    }
                    break;
                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }


        
    }
    
}
