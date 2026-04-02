import fabbrica.personale.Operaio;

class OperaioDirigente extends Operaio {
    OperaioDirigente(String nome){
        super(nome);
    }

    public void stampaStato(){
        m.stampaStato();
    }
}