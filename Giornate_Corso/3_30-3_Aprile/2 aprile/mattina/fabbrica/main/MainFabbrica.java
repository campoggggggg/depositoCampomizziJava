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

                    //riprendi qui. finisci logica crea macchina. poi login: nome -> riconosce ruolo, chiede una di 3 azioni 
                    break;
                case 3: // login + azione
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
