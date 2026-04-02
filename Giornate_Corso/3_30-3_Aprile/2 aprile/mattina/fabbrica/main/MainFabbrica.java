package fabbrica.main;

import fabbrica.produzione.Macchina;
import fabbrica.personale.Operaio;

import java.util.ArrayList;
import java.util.Scanner;

public class MainFabbrica {
    public static void main(String[] args) {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);

        ArrayList<Operaio>  operai   = new ArrayList<>();
        ArrayList<Macchina> macchine = new ArrayList<>();

        boolean continua = true;

        while (continua) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Crea Operaio");
            System.out.println("2. Crea Macchina");
            System.out.println("3. Login");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            int scelta = scannerNum.nextInt();

            switch (scelta) {
                case 1: 
                    System.out.println("Inserisci nome operaio: ");
                    String nomeOperaio = scannerStr.nextLine();

                    do {
                        System.out.println("Qual è il suo titolo? (1. Special | 2. Dirigente)");
                        int ruolo = scannerNum.nextInt();

                        if (ruolo == 1) {
                            operai.add(new OperaioSpecial(nomeOperaio));
                        } else if (ruolo == 2) {
                            operai.add(new OperaioDirigente(nomeOperaio));
                        } else {
                            System.out.println("Errore. Inserisci un valore valido.");
                            ruolo = 0;
                        }
                    } while (ruolo == 0);
                    
                    break;
                case 2: 
                    System.out.println("Inserisci nome macchina: ");
                    String nomeMacchina = scannerStr.nextLine();
                    macchine.add(new Macchina(nomeMacchina, false));
                    
                    break;
//                    login: nome -> riconosce ruolo, chiede una di 3 azioni 
                case 3: 
                    
                    
                    boolean continua4 = true;

                    
                    System.out.println("Inserisci il tuo nome");
                    String nomeLogin = scannerStr.nextLine();

                    Operaio operaioTrovato = null;
                    for (Operaio o : operai) {
                        if (o.getNome().equals(nomeLogin)) {
                            operaioTrovato = o;
                        } else {
                            System.out.println("Nome non presente nel sistema. Riprova");
                        }
                    }
                    

                    while (continua4) {
                        System.out.println("Scegli che operazione fare: ");
                        System.out.println("1. Accendi una macchina");
                        System.out.println("2. Spegni una macchina");
                        System.out.println("3. Stampa stato di una macchina");
                        System.out.println("0. Logout");

                        int operazione = scannerNum.nextInt();
                        
                        switch (operazione) {
                            case 1:
                                if (operaioTrovato instanceof OperaioSpecial) {
                                    for (int i = 0; i < macchine.size(); i++) {
                                        System.out.println(i + ". " + macchine.get(i).getNome());
                                    }
                                    int index = scannerNum.nextInt();
                                    operaioTrovato.lavora(macchine.get(index));
                                } else {
                                    System.out.println("Accesso non consentito");
                                }
                                break;
                        
                            default:
                                break;
                        }
                    }
                    //manca case 2 e 3 ma seguono logica simile a 1
                    break;
                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }

    }
}
