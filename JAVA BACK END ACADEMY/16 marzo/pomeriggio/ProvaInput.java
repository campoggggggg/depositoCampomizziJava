import java.util.Scanner; //import the Scanner class
class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); //create a scanner object
        System.out.println("Enter username:"); 

        String userName = myObj.nextLine(); //read user input
        System.out.println("Username is: " + userName);
    }
}