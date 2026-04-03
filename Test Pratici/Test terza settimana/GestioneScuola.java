import java.util.ArrayList;
import java.util.Scanner;

// ======================
// CLASSE ASTRATTA
// ======================
abstract class Persona {
    private String nome;
    private int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() { return nome; }
    public int getEta() { return eta; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEta(int eta) { this.eta = eta; }

    public abstract void descriviRuolo();
}

interface Registrabile {
    //stampa la modalità di registrazione della persona
    void registrazione(); 
}

// ======================
//       STUDENTE
// ======================
class Studente extends Persona implements Registrabile {
    private String classeFrequentata;
    private ArrayList<Integer> voti = new ArrayList<>();

    public Studente(String nome, int eta, String classeFrequentata) {
        super(nome, eta);
        this.classeFrequentata = classeFrequentata;
    }

    public String getClasse() {return classeFrequentata; }

    public void aggiungiVoto(int voto) {
        voti.add(voto);
    }

    public void stampaVoti() {
        if(voti.size() == 0) {
            System.out.println("Lo/la studente/ssa non ha ancora voti registrati.");
        } else {
            System.out.println("Voti: " + voti);
        }
    }

    @Override
    public void descriviRuolo() {
        System.out.println("Sono uno studente della classe " + classeFrequentata);
    }

    @Override
    public void registrazione() {
        System.out.println("Registrazione tramite modulo online");
    }
}

// ======================
//    FIGLI Studente
// ======================
class StudenteAlgebra extends Studente {
    public StudenteAlgebra (String nome, int eta, String classeFrequentata) {
        super(nome, eta, classeFrequentata);
    }
}

class StudenteInformatica extends Studente {
    public StudenteInformatica (String nome, int eta, String classeFrequentata) {
        super(nome, eta, classeFrequentata);
    }
}

// ======================
// DOCENTE
// ======================
class Docente extends Persona implements Registrabile {
    private String materia;
    private ArrayList<Studente> studenti = new ArrayList<>();

    public Docente(String nome, int eta, String materia) {
        super(nome, eta);
        this.materia = materia;
    }

    public void aggiungiStudente(Studente s) {
        studenti.add(s);
    }

    public void assegnaVoto(Studente s, int voto) {
        s.aggiungiVoto(voto);
    }

    public ArrayList<Studente> getStudenti() { return studenti; }

    @Override
    public void descriviRuolo() {
        System.out.println("Sono un docente di " + materia);
    }

    @Override
    public void registrazione() {
        System.out.println("Registrazione tramite segreteria didattica");
    }
}

// ======================
//     FIGLI docente
// ======================
class DocenteAlgebra extends Docente {
    private ArrayList<StudenteAlgebra> studentiAlgebra = new ArrayList<>();

    public DocenteAlgebra (String nome, int eta, String materia) {
        super(nome, eta, materia);
    }

    @Override
    public void aggiungiStudente (Studente s) {
        if (s.getClasse().equalsIgnoreCase("algebra")) {
            studentiAlgebra.add(s);
        } else {
            System.out.println("Errore: questo docente accetta solo studenti di Algebra.");
        }
    }
}

class DocenteInformatica extends Docente {
    private ArrayList<StudenteInformatica> studentiInformatica = new ArrayList<>();

    public DocenteInformatica (String nome, int eta, String materia) {
        super(nome, eta, materia);
    }

    @Override
    public void aggiungiStudente (Studente s) {
        if (s.getClasse().equalsIgnoreCase("informatica")) {
            studentiInformatica.add(s);
        } else {
            System.out.println("Errore: questo docente accetta solo studenti di Informatica.");
        }
    }
}


// ======================
//        MAIN
// ======================
public class GestioneScuola {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Studente> studenti = new ArrayList<>();
        ArrayList<Docente> docenti = new ArrayList<>();

        /* Studenti e docenti di esempio */
        StudenteAlgebra sAlg = new StudenteAlgebra("Luca", 16, "algebra");
        StudenteInformatica sInf = new StudenteInformatica("Sara", 17, "informatica");
        DocenteAlgebra dAlg = new DocenteAlgebra("Rossi", 45, "Algebra");
        DocenteInformatica dInf = new DocenteInformatica("Bianchi", 50, "Informatica");

        studenti.add(sAlg);
        studenti.add(sInf);
        docenti.add(dAlg);
        docenti.add(dInf);


        int scelta;

        do {
            System.out.println("\n1. Crea Studente");
            System.out.println("2. Crea Docente");
            System.out.println("3. Assegna voto"); //decidi il docente, poi assegna voto a uno studente
            System.out.println("4. Stampa voti studente"); //stampa TUTTI i voti di uno studente
            System.out.println("0. Esci");

            scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {

                case 1:
                    System.out.print("Nome: ");
                    String nomeS = sc.nextLine();
                    System.out.print("Età: ");
                    int etaS = sc.nextInt();
                    sc.nextLine();

                    String classe;
                    do {
                        System.out.print("Classe (algebra/informatica): ");
                        classe = sc.nextLine();
                        if (!classe.equalsIgnoreCase("algebra") && !classe.equalsIgnoreCase("informatica")) {
                            System.out.println("Classe non valida. Riprova.");
                        }
                    } while (!classe.equalsIgnoreCase("algebra") && !classe.equalsIgnoreCase("informatica"));

                    Studente nuovoStudente = new Studente(nomeS, etaS, classe);
                    studenti.add(nuovoStudente);
                    nuovoStudente.registrazione();
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nomeD = sc.nextLine();
                    System.out.print("Età: ");
                    int etaD = sc.nextInt();
                    sc.nextLine();
                    
                    String materia;
                    do {
                        System.out.print("Materia (algebra/informatica): ");
                        materia = sc.nextLine();
                        if (!materia.equalsIgnoreCase("algebra") && !materia.equalsIgnoreCase("informatica")) {
                            System.out.println("Materia non valida. Riprova.");
                        }
                    } while (!materia.equalsIgnoreCase("algebra") && !materia.equalsIgnoreCase("informatica"));

                    Docente nuovoDocente = new Docente(nomeD, etaD, materia);
                    docenti.add(nuovoDocente);
                    nuovoDocente.registrazione();
                    break;

                case 3:
                    if (docenti.size() == 0) {
                        System.out.println(("\nNon ci sono docenti registrati."));
                        break;
                    }

                    System.out.println("Seleziona docente (indice):");
                    for (int i = 0; i < docenti.size(); i++) {
                        System.out.println((i + 1) + " - " + docenti.get(i).getNome());
                    }

                    int d;
                    do { //seleziona docente solo se valido
                        d = sc.nextInt();
                        if (d <= 0 || d > docenti.size()) {
                            System.out.println("Index non valido. Riprova.");
                        }
                    } while (d <= 0 || d > docenti.size());
                    
                    ArrayList<Studente> studentiDocente = docenti.get(d - 1).getStudenti();

                    if (studentiDocente.size() == 0) {
                        System.out.println("Nessuno studente assegnato a questo docente.");
                        break;
                    }

                    System.out.println("Seleziona studente (indice):");
                    for (int i = 0; i < studentiDocente.size(); i++) {
                        System.out.println((i + 1) + " - " + studentiDocente.get(i).getNome());
                    }

                    int s;
                    do {
                        s = sc.nextInt();
                        if (s <= 0 || s > studentiDocente.size()) {
                            System.out.println("Index non valido. Riprova.");
                        }
                    } while (s <= 0 || s > studentiDocente.size());

                    System.out.print("Voto: ");
                    int voto = sc.nextInt();

                    docenti.get(d - 1).assegnaVoto(studentiDocente.get(s - 1), voto);
                    break;

                case 4: //stampa voti
                    if (studenti.size() == 0) {
                        System.out.println("\nNon ci sono studenti registrati.");
                        break;
                    }

                    System.out.println("Seleziona studente:");
                    for (int i = 0; i < studenti.size(); i++) {
                        System.out.println((i + 1) + " - " + studenti.get(i).getNome());
                    }
                    int index;
                    do {
                        index = sc.nextInt();
                        if (index <= 0 || index > studenti.size()) {
                            System.out.println("Index non valido. Riprova.");
                        }
                    } while (index <= 0 || index > studenti.size());

                    studenti.get(index - 1).stampaVoti();
                    break;
            }

        } while (scelta != 0); //fine menu

        sc.close();
    }
}