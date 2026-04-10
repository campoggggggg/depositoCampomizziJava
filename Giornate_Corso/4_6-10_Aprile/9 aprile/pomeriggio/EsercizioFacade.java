public class EsercizioFacade {
    public static void main(String[] args) {
        //creo facade
        GestioneLuciFacade GestioneLuci = new GestioneLuciFacade();

        GestioneLuci.accendiTutte();
    }
}

/*
    SOTTOSISTEMA 1
*/
class LuceCamera {

    public void accendi() {
        System.out.println("Luce camera accesa");
    }

}


/*
    SOTTOSISTEMA 2
*/
class LuceCucina {

    public void accendi() {
        System.out.println("Luce cucina accesa");
    }


}

/*
    FACADE
    Nasconde tutta la complessità del sistema
*/
class GestioneLuciFacade {

    private LuceCamera lcam;
    private LuceCucina lcuc;

    

    public GestioneLuciFacade() {
        lcam = new LuceCamera();
        lcuc = new LuceCucina();
    }

    // metodo semplice che usa molti oggetti interni
    public void accendiTutte() {
        lcam.accendi();
        lcuc.accendi();
    }

}