package fabbrica.produzione;

import java.util.ArrayList;

public class Macchina {
    private String nome;
    private boolean acceso;

    public Macchina(String nome, boolean acceso) {
        this.nome = nome;
        this.acceso = acceso;
    }

    public String getNome() { return nome; }

    public void setNome() {
        if(nome.equals("")) {
            System.out.println("Errore. Nome vuoto");
        } else {
            this.nome = nome;
        }
    }

    public void accendi () {
        acceso = true;
    }

    public void spegni() {
        acceso = false;
    }

    public void creaProdotto(String prodotto) {
        if (acceso) {
            System.out.println("Sto creando questo prodotto: " + prodotto);
        } else {
            stampaStato();
        }
    }

    public void stampaStato() {
        if (acceso) {
            System.out.println(nome + ": accesa.");
        } else {
        System.out.println(nome + ": spenta.");
        } 

    }
}