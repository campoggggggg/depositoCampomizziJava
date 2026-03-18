import java.util.Scanner;

public class EsCon {
    public static void main(String[] args){
    Scanner myObj1 = new Scanner(System.in); //create a scanner object
    System.out.println("Inserisci un numero per controllare se è positivo o negativo:"); 

    int num1 = myObj1.nextInt(); //assegna numero
    if(num1 > 0){ //check positivo
        System.out.println("Il numero è positivo.");
    } else if(num1 < 0){ //check negativo
        System.out.println("Il numero è negativo.");
    } else { //check = 0
        System.out.println("Il numero è zero.");
    }

    Scanner myObj2 = new Scanner(System.in);
    Scanner myObj3 = new Scanner(System.in);

    System.out.println("Inserisci il primo numero:");
    int num2 = myObj2.nextInt();
    System.out.println("Inserisci il secondo numero:");
    int num3 = myObj3.nextInt();

    if (num2 > num3){ 
        System.out.println("Il primo numero è maggiore.");
    } else if(num2 < num3){
        System.out.println("Il secondo numero è maggiore.");
    } else {
        System.out.println("I numeri sono uguali.");
    }
    
    Scanner myAge = new Scanner(System.in);
    System.out.println("Inserisci la tua età:");

    int age = myAge.nextInt();
    if (age < 18){ //check età
        System.out.println("Sei minorenne.");
    } else {
        System.out.println("Sei maggiorenne.");
    }

    Scanner myYear = new Scanner(System.in);
    System.out.println("Inserisci un anno:");
    int year = myYear.nextInt();
    if(year % 4 == 0 || (year % 100 == 0 && year % 400 == 0)){ //check bisestile
        System.out.println("L'anno è bisestile.");
    } else {
        System.out.println("L'anno non è bisestile.");
    }
    }
}
