import java.util.ArrayList;
import java.util.Scanner;

class Astronauta {
    private String nome;
    private String email;
    float creditoOssigeno;
    private static int contatoreAstronauta = 0;
    private int idAstronauta; 
    int numeroOperazioniEseguite = 0;

    Astronauta(String nome, String email, float creditoOssigeno) {
        this.nome = nome;
        this.email = email;
        this.creditoOssigeno = creditoOssigeno;
        contatoreAstronauta++;
        this.idAstronauta = contatoreAstronauta; 
    }
    public String ToString() {
        return "ID: " + idAstronauta + ", Nome: " + nome + ", Email: " + email + ", Credito Ossigeno: " + creditoOssigeno;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }


    public int getId() {
        return idAstronauta;
    }
}

class StazioneSpaziale {
    ArrayList<String> esperimenti = new ArrayList<>();
    ArrayList<Integer> valutazioni = new ArrayList<>();

}

class Scienziato extends Astronauta {

    Scienziato(String nome, String email, float creditoOssigeno) {
        super(nome, email, creditoOssigeno);
    }
}

class ScienziatoCapo extends Scienziato {

    ScienziatoCapo(String nome, String email, float creditoOssigeno) {
        super(nome, email, creditoOssigeno);
    }
}

class Ispettore extends Astronauta {

    Ispettore(String nome, String email, float creditoOssigeno) {
        super(nome, email, creditoOssigeno);
    }
}

class IspettoreEsperto extends Ispettore {

    IspettoreEsperto(String nome, String email, float creditoOssigeno) {
        super(nome, email, creditoOssigeno);
    }
}


public class MissioneSpaziale {
    public static void main(String[] args) {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);

        ArrayList<Astronauta> astronauti = new ArrayList<>();
        StazioneSpaziale stazione = new StazioneSpaziale();

        int currentIdLogin = 0;

        boolean continua = true;

        //primo login
        System.out.println("LOGIN. Inserisci ID:");
        int idLogin = scannerNum.nextInt();
        currentIdLogin = idLogin;

        for (int i = 0; i < astronauti.size(); i++) {
            if (astronauti.get(i).getId() == idLogin) {
                System.out.println("Benvenuto");
                break;
            } else {
                // Logica per inserire il primo astronauta
                System.out.println("ID non trovato. Inserisci il primo astronauta.");
                System.out.println("Inserisci nome:");
                String nome = scannerStr.nextLine();

                System.out.println("Inserisci email:");
                String email = scannerStr.nextLine();

                float creditoOssigeno = (float) Math.random()*100;

                System.out.println("Inserisci ruolo (s = scienziato | i = ispettore):");
                String ruolo;
                do {
                    ruolo = scannerStr.nextLine();
                    if (!ruolo.equals("s") && !ruolo.equals("i")) {
                        System.out.println("Ruolo non valido. Inserisci 's' per scienziato o 'i' per ispettore:");
                    }
                } while (!ruolo.equals("s") && !ruolo.equals("i"));
                if (ruolo.equals("s")) {
                    Scienziato scienziato = new Scienziato(nome, email, creditoOssigeno);
                    astronauti.add(scienziato);
                } else {
                    Ispettore ispettore = new Ispettore(nome, email, creditoOssigeno);
                    astronauti.add(ispettore);
                }
            }
        }
        //fine primo login

        while (continua) {
            System.out.println("MENU'");
            System.out.println("1. Aggiungi astronauta");
            System.out.println("2. Visualizza dati astronauta");
            System.out.println("3. Ripeti login");
            System.out.println("4. Operazione (s = aggiungi esperimetnto | i = aggiungi valutazione)");
            System.out.println("0. Esci");
            int scelta = scannerNum.nextInt();
            switch (scelta) {
                case 1:
                    //logica per inserire nuovo astronauta
                    System.out.println("Inserisci nome:");
                    String nome = scannerStr.nextLine();

                    System.out.println("Inserisci email:");
                    String email = scannerStr.nextLine();

                    float creditoOssigeno = (float) Math.random()*100;

                    System.out.println("Inserisci ruolo (s = scienziato | i = ispettore):");
                    String ruolo;
                    do {
                        ruolo = scannerStr.nextLine();
                        if (!ruolo.equals("s") && !ruolo.equals("i")) {
                            System.out.println("Ruolo non valido. Inserisci 's' per scienziato o 'i' per ispettore:");
                        }
                    } while (!ruolo.equals("s") && !ruolo.equals("i"));
                    if (ruolo.equals("s")) {
                        Scienziato scienziato = new Scienziato(nome, email, creditoOssigeno);
                        astronauti.add(scienziato);
                    } else {
                        Ispettore ispettore = new Ispettore(nome, email, creditoOssigeno);
                        astronauti.add(ispettore);
                    }


                    break;
                case 2:
                    // Logica per visualizzare i dati di un astronauta
                    System.out.println("Inserisci ID astronauta da visualizzare:");
                    int idShow = scannerNum.nextInt();

                    for (int i = 0; i < astronauti.size(); i++) {
                        if (astronauti.get(i).getId() == idShow) {
                            System.out.println(astronauti.get(i).ToString());
                            break;
                        } else {
                            System.out.println("ID non trovato.");
                            break;
                        }
                    }

                    break; //serve???
                case 3:
                    // Logica per ripetere il login
                    System.out.println("LOGOUT in corso, attendere...");
                    System.out.println(".\n.\n.\n.\n.");
                    System.out.println("LOGIN. Inserisci ID:");
                    int newIdLogin = scannerNum.nextInt();
                    currentIdLogin = newIdLogin;

                    for (int i = 0; i < astronauti.size(); i++) {
                        if (astronauti.get(i).getId() == newIdLogin) {
                            System.out.println("Benvenuto");
                            float nuovoCreditoOssigeno = (float) Math.random()*100;
                            astronauti.get(i).creditoOssigeno = nuovoCreditoOssigeno;
                            break;
                        } else {
                            System.out.println("ID non trovato. Inserisci un ID valido:");
                            break;
                        } 
                    }
                    break;
                case 4:
                    // Logica per eseguire un'operazione: switch con 4 opzioni ed entra a seconda del ruolo dell'astronauta loggato
                    int accesso = 0;
                    if (astronauti.get(currentIdLogin - 1) instanceof ScienziatoCapo) {
                        accesso = 1;
                    } else if (astronauti.get(currentIdLogin - 1) instanceof IspettoreEsperto) {
                        accesso = 2;
                    } else if (astronauti.get(currentIdLogin - 1) instanceof Scienziato) {
                        accesso = 3;
                    } else if (astronauti.get(currentIdLogin - 1) instanceof Ispettore) {
                        accesso = 4;
                    }

                    switch(accesso) {
                        case 1:
                            //switch in uno switch per scegliere il menu: stampa o aggiungi SCIENZIATO CAPO
                            System.out.println("scegli operazione: 1. aggiungi esperimento | 2. stampa esperimenti");
                            int sceltaScienziato = scannerNum.nextInt();

                            boolean continuaScienziato = true;

                            while (continuaScienziato) { 
                                switch (sceltaScienziato) {
                                    case 1:
                                        System.out.println("Aggiungi esperimento");
                                        String esperimento = scannerStr.nextLine();
                                        stazione.esperimenti.add(esperimento);
                                        astronauti.get(currentIdLogin - 1).numeroOperazioniEseguite++;
                                        continuaScienziato = false;
                                        break;
                                    case 2:
                                        System.out.println("Esperimenti in corso:");
                                        for (int i = 0; i < stazione.esperimenti.size(); i++) {
                                            System.out.printf("Esperimento %d: %s%n", (i+1), stazione.esperimenti.get(i));
                                        }
                                        continuaScienziato = false;
                                        break;
                                    default:
                                        System.out.println("Scelta non valida. Scegli 1 per aggiungere esperimento o 2 per stampare esperimenti:");
                                }
                            }
                            break; //fine case 1 accesso
                        case 2:
                            //switch in uno switch per scegliere il menu: stampa o aggiungi ISPETTORE ESPERTO
                            System.out.println("scegli operazione: 1. aggiungi valutazione | 2. stampa valutazioni");
                            int sceltaIspettore = scannerNum.nextInt();

                            boolean continuaIspettore = true;

                            while (continuaIspettore) { 
                                switch (sceltaIspettore) {
                                    case 1:
                                        System.out.println("Aggiungi valutazione");
                                        int valutazione = scannerNum.nextInt();
                                        stazione.valutazioni.add(valutazione);
                                        astronauti.get(currentIdLogin - 1).numeroOperazioniEseguite++;
                                        continuaIspettore = false;
                                        break;
                                    case 2:
                                        System.out.println("Valutazioni in corso:");
                                        for (int i = 0; i < stazione.valutazioni.size(); i++) {
                                            System.out.printf("Valutazione %d: %d%n", (i+1), stazione.valutazioni.get(i));
                                        }
                                        continuaIspettore = false;
                                        break;
                                    default:
                                        System.out.println("Scelta non valida. Scegli 1 per aggiungere valutazione o 2 per stampare valutazioni:");
                                }
                            }
                            break; //fine case 2 accesso
                        case 3:
                            System.out.println("Aggiungi esperimento");
                            String esperimento = scannerStr.nextLine();
                            stazione.esperimenti.add(esperimento);
                            astronauti.get(currentIdLogin - 1).numeroOperazioniEseguite++;
                            break;
                        case 4:
                            System.out.println("Aggiungi valutazione");
                            int valutazione = scannerNum.nextInt();
                            stazione.valutazioni.add(valutazione);
                            astronauti.get(currentIdLogin - 1).numeroOperazioniEseguite++;
                            break;
                    }




/*
                    if (currentIdLogin != 0) {                        
                        if (astronauti.get(currentIdLogin - 1) instanceof Scienziato) {
                            if (astronauti.get(currentIdLogin - 1).numeroOperazioniEseguite < 3) {
                                System.out.println("Aggiungi esperimento");
                                String esperimento = scannerStr.nextLine();
                                stazione.esperimenti.add(esperimento);
                                astronauti.get(currentIdLogin - 1).numeroOperazioniEseguite++;
                            } else {
                                System.out.println("Ora " + astronauti.get(currentIdLogin - 1).getNome() + " è uno scienziato capo");
                                //ora puo scegliere se aggiungere espeerimento o stampare tutti gli esperimenti
                            }  
                        } else if (astronauti.get(currentIdLogin - 1) instanceof Ispettore) {
                            if (astronauti.get(currentIdLogin - 1).numeroOperazioniEseguite < 3) {
                                System.out.println("Aggiungi valutazione");
                                int valutazione = scannerNum.nextInt();
                                stazione.valutazioni.add(valutazione);
                                astronauti.get(currentIdLogin - 1).numeroOperazioniEseguite++;
                            } else {
                                System.out.println("Ora " + astronauti.get(currentIdLogin - 1).getNome() + " è un ispettore esperto");
                                //ora puo scegliere se aggiungere valutazione o stampare tutte le valutazioni
                            }
                            System.out.println("Aggiungi valutazione");
                            int valutazione = scannerNum.nextInt();
                            stazione.valutazioni.add(valutazione);
                            astronauti.get(currentIdLogin - 1).numeroOperazioniEseguite++;
                        }
                    }
*/


                    break; //case4 del menu principale
                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }
}