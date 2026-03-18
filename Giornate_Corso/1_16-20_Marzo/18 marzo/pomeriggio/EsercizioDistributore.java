import java.util.Scanner;

/*
Nota: ho finito prima e provato ad implementare un messaggio di conferma
nel caso in cui si seleziona 2 volte di fila la stessa bevanda.
Il resto del codice, per l'esercizio base funziona(va).
*/


public class EsercizioDistributore {
    public static void main(String[] args) {
        //credito iniziale
        float credit = 10f;
        System.out.println("Credito iniziale: 10E");

        Scanner scanner = new Scanner(System.in);
        Scanner confirm = new Scanner(System.in); //scanner di conferma.

        String confirm;
        int select;             //var di selezione dello switch
        int lastSelect = 42;         //per errori di doppio inserimento (42 a caso)
        double beverageCost; //var per la bevanda


        //creo il menù
        do {
            System.out.println("\nScegliere un'opzione:\n1. Caffe - 1.50E\n2. Cappuccino - 2E\n3. Tè - 1E\n4. Acqua - 0.50E\n0. Uscire");
            select = scanner.nextInt();

            switch (select){ //ho le varie opzioni del menu.
                case 1:
                    beverageCost = 1.5;             //costo bevanda

                    //Implementazione per conferma doppia selezione non finito.
                    if (lastSelect == select){

                        do { //controllo di voler prendere nuovamente la bevanda
                            System.out.println("Sicuro di voler comprare un altro caffé? (s/n)");
                            confirm = scanner.nextLine(); //si o no?

                            if (!confirm.equals("s") && !confirm.equals("n")){
                                System.out.println("Input errato. Inserire (s/n).");    //se utente inserisce qualcosa di diverso da s/n, stampa messaggio di errore
                            } else if (confirm.equals("s")) {
                                if (credit >= beverageCost){    //se ho i soldi per comparla
                                    credit -= beverageCost;     //la compro
                                    System.out.println("Credito residuo: " + credit + "E");
                                } else {
                                    System.out.println("Credito insufficiente!");
                                }
                            } else {
                                System.out.println("Ok, allora scegli un'altra opzione. ");
                            }
                        } while (!confirm.equals("s") && !confirm.equals("n")); //continua se non digita s o n
                        


                    }

                    }   
                case 2://analogo a sopra e per i case 3 e 4
                    beverageCost = 2;
                    if (credit >= beverageCost){
                        credit -= beverageCost;
                        System.out.println("Credito residuo: " + credit + "E");
                        break;
                    }  
                case 3:
                    beverageCost = 1;
                    if (credit >= beverageCost){
                        credit -= beverageCost;
                        System.out.println("Credito residuo: " + credit + "E");
                        break;
                    }  
                case 4:
                    beverageCost = .5;
                    if (credit >= beverageCost){
                        credit -= beverageCost;
                        System.out.println("Credito residuo: " + credit + "E");
                        break;
                    }  
                case 0:
                    float tempCredit = credit; //var temporanea per vedere il credito residuo e poi uscire
                    credit = -1; //per uscire dal ciclo
                    System.out.println("Credito residuo: " + tempCredit + "E");
                    break;
                default: //caso in cui si ha input strani
                    System.out.println("Scegliere un'opzione valida! Hai ancora " + credit + "E");
                    select = 1; //solo per rientrare nel ciclo, tanto dopo cambia con lo scanner
                    break;

            }

        } while ((select > 0 && select <= 4) && credit > 0); //se la selezione è giusta o se si ha ancora credito

    } 

}