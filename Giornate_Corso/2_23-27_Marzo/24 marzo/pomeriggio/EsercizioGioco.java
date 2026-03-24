import java.util.Scanner;

public class EsercizioGioco {

    public static void assegnaGioco(Scanner scannerS, Scanner scannerN, Team team1, Team team2, Team team3) {
        System.out.println("Inserisci i dati del nuovo gioco!");
        System.out.println("Titolo: ");
        String nuovoTitolo = scannerS.nextLine();
        System.out.println("Genere: ");
        String nuovoGenere = scannerS.nextLine();
        System.out.println("Costo: ");
        double nuovoCosto = scannerN.nextDouble();

        Gioco nuovoGioco = new Gioco(nuovoTitolo, nuovoGenere, nuovoCosto,1 );

        System.out.println("A quale team vogliamo assegnarlo? ");
        System.out.println("1. Team A");
        System.out.println("2. Team B");
        System.out.println("3. Team C");
        int nuovoTeam = scannerN.nextInt();

        boolean continua = true;
        while (continua) {
            if(nuovoTeam == 1) {
                team1.gioco = nuovoGioco;
                continua = false;
            } else if (nuovoTeam == 2) {
                team2.gioco = nuovoGioco;
                continua = false;
            } else if (nuovoTeam == 3) {
                team3.gioco = nuovoGioco;
                continua = false;
            } else {
                System.out.println("Valore non valido. Riprova");
            }
        }
        

    
       
    }

    public static void visualizzaTeam(Team team1, Team team2, Team team3) {
        System.out.println("\nTeam A:");
        team1.mostraTeam();
        System.out.println("\nTeam B:");
        team2.mostraTeam();
        System.out.println("\nTeam C:");
        team3.mostraTeam();

    }

    public static void maxPrezzo(Team team1, Team team2, Team team3) {
        Team[] teams = {team1, team2, team3};
        Team teamMax = teams[0];

        for (int i = 0; i < teams.length; i++) {
            if (teams[i].gioco.costo > teamMax.gioco.costo) {
                teamMax = teams[i];
            }
        }
        System.out.println("Il gioco più costoso è: " + teamMax.gioco.titolo + " e si trova in: " + teamMax.nome);
    }

    public static void modificaStatoGioco(Scanner scannerS, Scanner scannerN, Team team1, Team team2, Team team3) {
        System.out.println("Scegli un team? ");
        System.out.println("1. Team A");
        System.out.println("2. Team B");
        System.out.println("3. Team C");
        
        Team tempTeam = null;

        boolean continua = true;
        while (continua) {
            int nuovoTeam = scannerN.nextInt();

            if(nuovoTeam == 1) {
                tempTeam = team1;
                continua = false;
            } else if (nuovoTeam == 2) {
                tempTeam = team2;
                continua = false;
            } else if (nuovoTeam == 3) {
                tempTeam = team3;
                continua = false;
            } else {
                System.out.println("Valore non valido. Riprova");
            }
        }

        System.out.println("Giochi del team scelto: ");
        tempTeam.gioco.mostraGioco();
        System.out.println("A quale vuoi modificare lo stato? ");
        String titoloGioco = scannerS.nextLine();

        if (tempTeam.gioco.titolo.equals(titoloGioco)) {
            System.out.println("Inserisci il nuovo stato del gioco");
            System.out.println("1. In sviluppo\n2. In test\n3. Pubblicato");
            int nuovoStato = scannerN.nextInt();
            tempTeam.gioco.stato = nuovoStato;
        } else {
            System.out.println("Gioco non trovato");
        }

    }

    public static void creaTeam(Scanner scannerS, Scanner scannerN, Team team1, Team team2, Team team3) {
        System.out.println("Inserisci nome del nuovo team: ");
        String nomeTeam = scannerS.nextLine();
        Team nuovoTeam = new Team(nomeTeam, null, 0);
    }
    public static void main(String[] args) {
        
        Scanner scannerS = new Scanner(System.in);
        Scanner scannerN = new Scanner(System.in);
        int scelta;

        //SITUAZIONE INIZIALE
        Gioco gioco1 = new Gioco("Gioco A", "Roguelike", 9.99, 1);
        Gioco gioco2 = new Gioco("Gioco B", "RPG", 39.99, 2);
        Gioco gioco3 = new Gioco("Gioco C", "MOBA", 0.99, 3);

        Team team1 = new Team("Team A", gioco1, 5);
        Team team2 = new Team("Team B", gioco2, 3);
        Team team3 = new Team("Team C", gioco3, 4);

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Assegna un gioco");
            System.out.println("2. Visualizza i team");
            System.out.println("3. Cerca il gioco più costoso");
            System.out.println("4. Modifica lo stato di un gioco");
            System.out.println("5. Crea nuovo team");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            scelta = scannerN.nextInt();

            switch (scelta) {
                case 1:
                    assegnaGioco(scannerS, scannerN, team1, team2, team3);
                    break;
                case 2:
                    visualizzaTeam(team1, team2, team3);
                    break;
                case 3:
                    maxPrezzo(team1, team2, team3);
                    break;
                case 4:
                    modificaStatoGioco(scannerS, scannerN, team1, team2, team3);
                    break;
                case 5:
                    creaTeam(scannerS, scannerN, team1, team2, team3);
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova");
		    scelta = 1;
            }

        } while (scelta != 0);

        scannerS.close();
        scannerN.close();

    }
}

class Gioco {
    String titolo;
    String genere;
    double costo;
    int stato;


    Gioco (String titolo, String genere, double costo, int stato) {
        this.titolo = titolo;
        this.genere = genere;
        this.costo = costo;
        this.stato = stato;
    }
    void mostraGioco () {
        String statoText = "";
        System.out.println("Titolo: " + titolo);
        System.out.println("Genere: " + genere);
        System.out.println("Costo: " + costo);
        if (stato == 1) {
            statoText = "In sviluppo";
        } else if (stato == 2) {
            statoText = "In test";
        } else if (stato == 3) {
            statoText = "Pubblicato";
        }
        System.out.println("Stato: " + statoText);
    }
}

class Team {
    String nome;
    Gioco gioco;
    int numMembri;

    Team (String nome, Gioco gioco, int numMembri) {
        this.nome = nome;
        this.gioco = gioco;
        this.numMembri = numMembri;
    }

    void mostraTeam () {
        System.out.println("Nome: " + nome);
        System.out.println("Gioco: " + gioco.titolo);
        System.out.println("Membri: " + numMembri);
    }
}