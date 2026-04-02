import fabbrica.personale.Operaio;

public class OperaioSpecial extends Operaio {
    OperaioSpecial(String nome) {
        super(nome);
    }

    public void lavora(){
        m.accendi();
    }
}