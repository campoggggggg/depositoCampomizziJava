import java.util.Scanner;

public static void main(String[] args) {

    int age = 0;
    Scanner scannerStr = new Scanner(System.in);
    Scanner scannerInt = new Scanner(System.in);


    System.out.println("Inserisci il nome");
    String myName = scannerStr.nextLine();

    System.out.println("Inserisci la data di nascita! Giorno:");
    int myDay = scannerInt.nextInt();
    System.out.println("Mese");
    int myMonth = scannerInt.nextInt();
    System.out.println("Anno");
    int myYear = scannerInt.nextInt();

    if (myMonth <= 3) {
        if (myDay <= 23) {
            age = 2026 - myYear;
        } else age = 2026 - myYear - 1;
    } else age = 2026 - myYear - 1;

    System.out.println("Che giorno della settimana è oggi?");
    int dayOfTheWeek = scannerInt.nextInt();
    int untilSaturday = 6 - dayOfTheWeek;

    System.out.println("Nome: " + myName);
    System.out.println("Età: " + age);
    System.out.println("Mancano " + untilSaturday + " giorni a sabato");

    scannerStr.close();
    scannerInt.close();
}

