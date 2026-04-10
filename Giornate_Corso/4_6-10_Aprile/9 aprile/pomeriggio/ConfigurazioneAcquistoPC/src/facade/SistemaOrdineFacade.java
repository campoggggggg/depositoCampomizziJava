package facade;

import decorator.*;
import strategy.*;

public class SistemaOrdineFacade {
    private Computer computer;
    private PagamentoContext pagamento = new PagamentoContext(null);
    CC cc = new CC();
    PP pp = new PP();

    //metodo 1 configurazione base
    public void scegliConfigurazioneBase(String tipo) {
        if (tipo.toUpperCase().equals("GAMING")) {
            computer = new ComputerBaseGaming();
        } else if (tipo.toUpperCase().equals("UFFICIO")){
            computer = new ComputerBaseUfficio(); 
        } else {
            System.out.println("Opzione non valida.");
        }
    } 

    //metodo 2 - funzioni decorator
    public void aggiungiRam() {
        computer = new RamExtra(computer);
    }

    public void aggiungiSSD() {
        computer = new SsdExtra(computer);
    }

    public void aggiungiSchedaVideo() {
        computer = new SchedaVideoExtra(computer);
    }

    public void aggiungiRaffreddamento() {
        computer = new RaffreddamentoExtra(computer);
    }

    //metodo 3 - visualizza stato ordine
    public void visualizzaRiepilogo () {
        System.out.println(computer.getDescrizione());
        System.out.println(computer.getPrezzo());
    }

    //metodo 4 - scegli forma pagamento
    public void scegliPagamento (String metodo) {
        switch(metodo) {
            case "CC": 
                pagamento.setMetodo(cc);
                break;
            case "PP":
                pagamento.setMetodo(pp);
                break;
            default:
                System.out.println("Scelta non valida.");
        }
    }

    //metodo 5 - conferma ordine
    public void confermaOrdine() {
        if (computer == null) {
            System.out.println("Nessun computer selezionato");
            return;
        }

        System.out.println("Ordine confermato! ");
        visualizzaRiepilogo();
        pagamento.eseguiPagamento(computer.getPrezzo());
        computer = null;
    }
}