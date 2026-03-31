class Vehicle {

    protected String brand = "Ford";       

    public void honk() {                    
        System.out.println("Tuut, tuut!");
    }
}


class Car extends Vehicle {

    String modelName = "Fiat";    //se private, il main va in quella stessa classe

}

public class EsempioEreditarietà {
    public static void main(String[] args) {

        Car myCar = new Car();

        myCar.honk();

        System.out.println(myCar.brand + " " + myCar.modelName);
    }

}