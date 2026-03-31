public class Person {

    //campi privati (incapsulamento)
    private String name;
    private int età;

    //costruttore pubblico
    public Persona(String name, int età) {
        this.nome = nome;
        this.età = età;
    }

    //metodo priv utilizzato dalla classe
    private boolean verificaMaggiorenne() {
        return this.età >= 18;
    }
    //metodo pubblico che usa il metodo privato
    public void stampaStatus(){
        if(verificaMaggiorenne()) {
            System.out.println(this.nome + "è maggiorenne");
        } else {
            System.out.println(this.nome + "non è maggiorenne");
        }
    }

    //getter
    public String getName() {
        return name;
    }
    //setter
    public void setName (String newName) {
        this.name = newName;
    }
    //get e set servono per ciò che è PRIVATO, altrimenti non ci spreco tempo
}

public class ProvaIncapsulamento {
    public static void main(String[] args) {
        Person myObj = new Person();
        myObj.setName("Pippo");
        System.out.println(myObj.getName());
    }
}
