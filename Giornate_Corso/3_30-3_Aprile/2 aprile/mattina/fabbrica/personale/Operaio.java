package fabbrica.personale;

import fabbrica.produzione.Macchina;

public abstract class Operaio {
    protected String nome;
    public Operaio(String nome) {
        this.nome = nome;
    }

    public abstract void lavora(Macchina m);

    public void ferma(Macchina m) {
        m.spegni();
    }

    public abstract void stampaStato(Macchina m);
}