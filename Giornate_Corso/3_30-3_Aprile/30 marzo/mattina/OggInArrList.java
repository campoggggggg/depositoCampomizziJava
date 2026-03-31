import java.util.ArrayList;

class Autoes {
    String marca;   //parametro1
    int anno;       //parametro2

    Auto (String marca, int anno) { //costruttore
        this.marca = marca;
        this.anno = anno;
    }
}

public class OggInArrList {
    public static void main (String[] args) {
        ArrayList<Auto> autoList = new ArrayList<>();
        autoList.add(new Auto("Tesla", 2023));
        autoList.add(new Auto("Ford", 2020));

        for (Auto auto : autoList) {
            System.out.println(auto.marca + " - " + auto.anno);
        }
    }

    public String toString() {
        return "Nome: " + nome + " - Eta: " + eta;
    }
}