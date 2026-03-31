import java.util.Scanner;
import java.util.ArrayList;
import java.sql.*;

class Aereo {
    private String modello;
    private int numeroPosti;
    private String codiceVolo;
    private static int contatoreAereo = 0;
    private int idAereo;


    Aereo(String modello, int numeroPosti, String codiceVolo) {
        this.modello = modello;
        this.numeroPosti = numeroPosti;
        this.codiceVolo = codiceVolo;
    }

    public String getModello() {
        return this.modello;
    }

    public int getNumeroPosti() {
        return this.numeroPosti;
    }

    public String getCodiceVolo() {
        return this.codiceVolo;
    }

    public void setModello(String nuovoModello) {
        this.modello = nuovoModello;
    }

    public void setNumeroPosti(int nuovoNumeroPosti) {
        if (nuovoNumeroPosti <= 0) {
            System.out.println("Numero di posti non valido.");
        } else {
            this.numeroPosti = nuovoNumeroPosti;
        }
    }

    public void setCodiceVolo(String nuovoCodiceVolo) {
        this.codiceVolo = nuovoCodiceVolo;
    }

    public void mostraInfoAereo() {
        System.out.println("ID: " + this.idAereo);
        System.out.println("Modello: " + this.modello);
        System.out.println("Numero posti: " + this.numeroPosti);
        System.out.println("Codice volo: " + this.codiceVolo);
    }

}

class Pilota {
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;
    private static int contatorePilota = 0;
    private int idPilota;

    Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        this.oreVolo = oreVolo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getNumeroBrevetto() {
        return this.numeroBrevetto;
    }

    public int getOreVolo() {
        return this.oreVolo;
    }

    public void setNome(String nuovoNome) {
        this.nome = nuovoNome;
    }

    public void setNumeroBrevetto(String nuovoNumeroBrevetto) {
        this.numeroBrevetto = nuovoNumeroBrevetto;
    }

    public void setOreVolo(int nuoveOreVolo) {
        if (nuoveOreVolo < 0) {
            System.out.println("Ore di volo non valide.");
        } else {
            this.oreVolo = nuoveOreVolo;
        }
    }

    public void mostraInfoPilota() {
        System.out.println("ID: " + this.idPilota);
        System.out.println("Nome: " + this.nome);
        System.out.println("Numero brevetto: " + this.numeroBrevetto);
        System.out.println("Ore di volo: " + this.oreVolo);
    }
}

class compagniaAerea {
    private String nome;
    private ArrayList<Aereo> flotta;
    private ArrayList<Pilota> piloti;
    private static int contatoreCompagnia = 0;
    private int idCompagnia;

    compagniaAerea(String nome) {
        this.nome = nome;
        this.flotta = new ArrayList<>();
        this.piloti = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nuovoNome) {
        this.nome = nuovoNome;
    }

    public void aggiungiAereo(Aereo aereo) {
        this.flotta.add(aereo);
    }

    public void aggiungiPilota(Pilota pilota) {
        this.piloti.add(pilota);
    }

    public void mostraInfo() {
        System.out.println("Flotta: ");
        for (int i = 0; i < flotta.size(); i++) {
            System.out.println("Aereo " + (i + 1) + ": Modello: " + flotta.get(i).getModello() + ", Numero posti: " + flotta.get(i).getNumeroPosti() + ", Codice volo: " + flotta.get(i).getCodiceVolo());
        }
        System.out.println("Piloti: ");
        for (int i = 0; i < piloti.size(); i++) {
            System.out.println("Pilota " + (i + 1) + ": Nome: " + piloti.get(i).getNome() + ", Numero brevetto: " + piloti.get(i).getNumeroBrevetto() + ", Ore di volo: " + piloti.get(i).getOreVolo());
        }
    }

}

public class GestioneFlotta {
    public static void main(String[] args) {
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        //prova connessione DB
        String host = "localhost";
        String port = "8889";
        String url = "jdbc:mysql://" + host + ":" + port + "/flotta";
        String user = "root";
        String psw = "Gastly1!";

        try (Connection conn = DriverManager.getConnection(url, user, psw)) {
            System.out.println("Connessione riuscita.");

            boolean continua = true;

            while (continua) {
                System.out.println("\nMENU:");
                System.out.println("1 - Aggiungi aereo");
                System.out.println("2 - Aggiungi pilota");
                System.out.println("3 - Rimuovi aereo");
                System.out.println("4 - Rimuovi pilota");
                System.out.println("5 - Modifica aereo");
                System.out.println("6 - Modifica pilota");
                System.out.println("7 - Stampa compagnia");
                System.out.println("0 - Esci");
                System.out.print("Scegli: ");
                int scelta = scannerNum.nextInt();

                switch (scelta) {
                    case 1:
                        System.out.print("Modello: ");
                        String modello = scannerStr.nextLine();

                        System.out.print("Numero posti: ");
                        int posti = scannerNum.nextInt();

                        System.out.print("Codice volo: ");
                        String codice = scannerStr.nextLine();

                        System.out.print("ID compagnia (1=Alitalia, 2=RyanAir): ");
                        int idC = scannerNum.nextInt();

                        //query con ?
                        PreparedStatement psAddA = conn.prepareStatement(
                            """
                            INSERT INTO aerei (
                                modello,
                                numero_posti,
                                codice_volo,
                                id_compagnia
                                )

                                VALUES (?, ?, ?, ?);
                                
                                """
                        );

                        psAddA.setString(1, modello);
                        psAddA.setInt(2, posti);
                        psAddA.setString(3, codice);
                        psAddA.setInt(4, idC);
                        psAddA.executeUpdate();
                        break;

                    case 2:
                        System.out.print("Nome: ");
                        String nome = scannerStr.nextLine();

                        System.out.print("Numero brevetto: ");
                        String brevetto = scannerStr.nextLine();

                        System.out.print("Ore volo: ");
                        int oreVolo = scannerNum.nextInt();

                        System.out.print("ID compagnia (1=Alitalia, 2=RyanAir): ");
                        int idCP = scannerNum.nextInt();

                        //query con ?
                        PreparedStatement psAddP = conn.prepareStatement(
                            """
                            INSERT INTO piloti (
                                nome,
                                numero_brevetto,
                                ore_volo,
                                id_compagnia
                                )

                                VALUES (?, ?, ?, ?);
                                
                                """
                        );

                        psAddP.setString(1, nome);
                        psAddP.setString(2, brevetto);
                        psAddP.setInt(3, oreVolo);
                        psAddP.setInt(4, idCP);
                        psAddP.executeUpdate();
                        break;

                    case 3:
                        //aggiungi una stampa di tutti gli aerei con id e modello
                        //altrimenti sarebbe da conoscere prima l'ID dell'aereo da rimuovere
                        System.out.println("ID aereo da rimuovere: ");
                        int idAereoRimosso = scannerNum.nextInt();

                        PreparedStatement psRimA = conn.prepareStatement(
                            """
                            DELETE FROM aerei
                            WHERE id = ?;
                            
                            """
                        );

                        psRimA.setInt(1, idAereoRimosso);
                        psRimA.executeUpdate();
                        break;

                    case 4:
                        System.out.println("ID pilota da rimuovere: ");
                        int idPilotaRimosso = scannerNum.nextInt();

                        PreparedStatement psRimP = conn.prepareStatement(
                            """
                            DELETE FROM piloti
                            WHERE id = ?;
                            
                            """
                        );

                        psRimP.setInt(1, idPilotaRimosso);
                        psRimP.executeUpdate();
                        break;

                    case 5:
                        //modifica dei valori nell'aereo
                        break;

                    case 6:
                        //modifica dei valori nel pilota
                        break;
                    
                    case 7:
                        System.out.println("Compagnia: ");
                        System.out.println("1 - Alitalia");
                        System.out.println("2 - RyanAir");

                        int idCompagnia = scannerNum.nextInt();

                        PreparedStatement psStampaA = conn.prepareStatement(
                            """
                            SELECT a.modello, a.numero_posti, a.codice_volo
                            JOIN compagnie c ON a.id_compagnia = c.id
                            WHERE a.id_compagnia = ?;
                            
                            """
                        );

                        psStampaA.setInt(1, idCompagnia);
                        ResultSet rsA = psStampaA.executeQuery();
                        while (rsA.next()) {
                            System.out.println("Modello: " + rsA.getString("modello") + ", Numero posti: " + rsA.getInt("numero_posti") + ", Codice volo: " + rsA.getString("codice_volo"));
                        }

                        PreparedStatement psStampaP = conn.prepareStatement(
                            """
                            SELECT p.nome, p.numero_brevetto, p.ore_volo
                            FROM piloti p
                            JOIN compagnie c ON p.id_compagnia = c.id
                            WHERE p.id_compagnia = ?;
                            """
                        );
                        psStampaP.setInt(1, idCompagnia);
                        ResultSet rsP = psStampaP.executeQuery();
                        while (rsP.next()) {
                            System.out.println("Nome: " + rsP.getString("nome") + ", Numero brevetto: " + rsP.getString("numero_brevetto") + ", Ore volo: " + rsP.getInt("ore_volo"));
                        }
                }   


            }

            } catch (SQLException e) {  
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
