import java.util.Scanner;
import java.util.ArrayList;

class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        if (isAvailable) {
            System.out.println("Available: Yes");
        } else {
            System.out.println("Available: No");
        }
        
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Scanner scannerStr) {
        System.out.println("You chose to add a book.");
        System.out.println("Title: ");
        String title = scannerStr.nextLine();

        System.out.println("Author");
        String author = scannerStr.nextLine();

        Book newBook = new Book(title, author, true);
        this.books.add(newBook);
    }

    public void displayBooks() {
        //mostra tutti i libri AVAILABLE in biblioteca
        if(this.books.size() == 0) {
            System.out.println("No available book in the library. Sorry.");
        } else {
            System.out.println("Libri disponibili in biblioteca");
            for (int i = 0; i < books.size(); i++) {
                if (this.books.get(i).isAvailable) {
                    System.out.println("- Title: " + this.books.get(i).title + " | " + "Author: " + this.books.get(i).author);
                }
            } 
        }
    }

    public void borrowBook(Scanner scannerStr) {
        //prendi libro in prestito SOLO se disponibile
        boolean removed = false;

        if(this.books.size() == 0) {
            System.out.println("No available book in the library. Sorry.");
        } else {
            System.out.println("Write the title of the book to borrow.");
            String title = scannerStr.nextLine();

            for (int i = 0; i < books.size(); i++) {
                if (this.books.get(i).title.equals(title)) {
                    this.books.get(i).isAvailable = false;
                    System.out.println("Enjoy your reading!");
                    removed = true;
                }
            }

            if (!removed) {
                System.out.println("Book not found...");
            }

        }   

    }

    public void returnBook(Scanner scannerStr) {
        System.out.println("Write the title of the book to return");
        String returnedBook = scannerStr.nextLine();

        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).title.equals(returnedBook)) {
                this.books.get(i).isAvailable = true;
                System.out.println("Thanks!");
            } else {
                System.out.println("Book not found in our system.");
            }
        }

    }

    public void searchBook(Scanner scannerNum, Scanner scannerStr) {
        System.out.println("Are you looking for a book? Select 1. title or 2. author");
        int scelta = scannerNum.nextInt();

        switch (scelta) {
            case 1:
                System.out.println("Write the title of the book: ");
                String title = scannerStr.nextLine();

                for (int i = 0; i < books.size(); i++) {
                    if (this.books.get(i).title.equals(title)) {
                        this.books.get(i).isAvailable = false;
                        System.out.println("Enjoy your reading!");
                        removed = true;
                    }
                }

        }
    }
}

public class GestioneBiblioteca {
    public static void main(String[] args) {
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);

        Library library = new Library();

        boolean continua = true;

        while (continua) {

            System.out.println("\nMENU:");
            System.out.println("1 - Add book");
            System.out.println("2 - Display books");
            System.out.println("3 - Borrow book");
            System.out.println("4 - Return book");
            System.out.println("5 - Search book");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");

            int scelta = scannerNum.nextInt();

            switch (scelta) {
                case 1:
                    library.addBook(scannerStr);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    library.borrowBook(scannerStr);
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scannerNum.close();
        scannerStr.close();
    }
}