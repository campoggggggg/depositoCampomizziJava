import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    String accountHolderName; //nome titolare
    Double balance; //saldo

    BankAccount(String accountHolderName, double balance) { //costruttore
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // metodo toString per stampa facile
    public String toString() {
        return "account holder: " + accountHolderName + " - Balance: " + balance;
    }

}

public class BankSim {
    public static void deposit(BankAccount account, Scanner scnrNum) {
        System.out.println("How much do you want to deposit? ");
        double amount = scnrNum.nextDouble();
        account.balance += amount;
        System.out.println("Done. New deposit: " + account.balance);
    }

    public static void withdraw(BankAccount account, Scanner scnrNum) {
        System.out.println("How much do you want to withdraw? ");
        double amount = scnrNum.nextDouble();
        if (amount > account.balance) {
            System.out.println("Insufficient funds. Current balance: " + account.balance);
        } else {
            account.balance -= amount;
            System.out.println("Done. New balance: " + account.balance);
        }
    }
    public static void addAccount(ArrayList<BankAccount> accounts, Scanner scnrNum, Scanner scnrStr) {
            System.out.println("Name: ");
            String name = scnrStr.nextLine();

            System.out.println("Balance: ");
            double balance = scnrNum.nextDouble();

            BankAccount newAccount = new BankAccount(name, balance);
            accounts.add(newAccount);
}

    public static BankAccount selectAccount (ArrayList<BankAccount> accounts, Scanner scnrNum) {
        System.out.println("Which account do you want to operate with: ");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i+1) + " - " + accounts.get(i));
        }

        int p = scnrNum.nextInt();
        return accounts.get(i);
    }

    public static void displayBalance(BankAccount account) {
        System.out.println("Current balance: " + account.balance);
    }

    public static void main(String[] args) {
        Scanner scnrNum = new Scanner(System.in);
        Scanner scnrStr = new Scanner(System.in);
        
        ArrayList<BankAccount> accounts = new ArrayList<>();

        //inizializzo 2 account
        BankAccount account1 = new BankAccount("Gabriele", 0.92);
        BankAccount account2 = new BankAccount("Lorenzo", 15000);
        accounts.add(account1);
        accounts.add(account2);

        boolean continua = true;

        while (continua) {

            System.out.println("\nMENU:");
            System.out.println("1 - Deposit");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Display balance");
            System.out.println("4 - Add account");
            System.out.println("0 - Exit");
            System.out.print("Scegli un'opzione: ");

            int scelta = scnrNum.nextInt();

            switch (scelta) {
                case 1:
                    deposit(selectAccount(accounts, scnrNum), scnrNum);
                    break;
                case 2:
                    withdraw(selectAccount(accounts, scnrNum), scnrNum);
                    break;
                case 3:
                    displayBalance(selectAccount(accounts, scnrNum));
                    break;
                case 4:
                    addAccount(accounts, scnrNum, scnrStr);
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida, riprova");
            }
        }

        scnrNum.close();
        scnrStr.close();
    }


}
