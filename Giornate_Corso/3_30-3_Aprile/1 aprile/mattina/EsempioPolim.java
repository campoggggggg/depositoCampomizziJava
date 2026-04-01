class Persona {
    private String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    void saluta() {
        System.out.println("Ciao, sono " + nome);
    }
}

class Pirata extends Persona {

    public Pirata(String nome) {
        super(nome);
    }

    @Override
    void saluta() {
        System.out.println("Ciao! Sono il pirata " + getNome());
    }
}

class GestoreOggetti {

    void salutaPersona(Persona persona) {
        persona.saluta();
    }
}

public class EsempioPolim {
    public static void main(String[] args) {
        Persona persona = new Persona("Mario");
        Pirata pirata = new Pirata("Jack Sparrow");
        GestoreOggetti gestore = new GestoreOggetti();

        gestore.salutaPersona(persona);
        
        gestore.salutaPersona(pirata);
    }
}