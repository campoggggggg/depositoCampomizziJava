import facade.SalesManager;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static SalesManager manager = new SalesManager();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            User currentUser = null;

            do {
                System.out.println("\n=== LOGIN ===");
                System.out.print("Username: "); String u = sc.nextLine();
                System.out.print("Password: "); String p = sc.nextLine();
                currentUser = manager.login(u, p);
                if (currentUser == null) System.out.println("Credenziali errate, riprova.");
            } while (currentUser == null);

            System.out.println("Benvenuto, " + currentUser.getUsername() + " [" + currentUser.getType() + "]");

            if (currentUser instanceof Admin) adminMenu((Admin) currentUser);
            else userMenu(currentUser);

            System.out.println("\n1.Nuovo login");
            System.out.println("0. Esci");
            System.out.println("Scelta: ");
            int exit = Integer.parseInt(sc.nextLine());
            if (exit == 0) running = false;
        }
        
        sc.close();
        System.out.println("Arrivederci!");
    }

    static void userMenu(User user) {
        int scelta;
        do {
            user.showMenu();
            System.out.print("Scelta: ");
            scelta = Integer.parseInt(sc.nextLine());
            switch (scelta) {
                case 1:
                    ArrayList<Product> products = manager.getAllProducts();
                    //mostro prezzo scontato se user è PRO
                    for (Product pr : products) {
                        double base = pr.getPrice();
                        double discounted = user.applyDiscount(base);

                        System.out.println(
                            pr.getName() +
                            " | " + pr.getDescription() +
                            " | Prezzo: EUR " + discounted
                        );
                    }
                    break;
                case 2:
                    acquisto(user);
                    break;
                case 3:
                    System.out.println("Categorie: 1=MAGLIETTE 2=PANTALONI 3=CAPPOTTI 4=SCARPE");
                    System.out.print("ID categoria: ");
                    int cat = Integer.parseInt(sc.nextLine());
                    ArrayList<Product> filtered = manager.getProductsByCategory(cat);
                    for (Product pr : filtered) System.out.println(pr);
                    break;
                case 4:
                    if (user instanceof ProUser) manager.showUserSales(user.getId());
                    else System.out.println("Opzione non disponibile.");
                    break;
                case 0:
                    System.out.println("Logout.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);
    }

    static void adminMenu(Admin admin) {
        int scelta;
        do {
            admin.showMenu();
            System.out.print("Scelta: ");
            scelta = Integer.parseInt(sc.nextLine());
            switch (scelta) {
                case 1:
                    ArrayList<Product> products = manager.getAllProducts();
                    for (Product pr : products) System.out.println(pr);
                    break;
                case 2:
                    System.out.print("ID prodotto: ");
                    int idP = Integer.parseInt(sc.nextLine());
                    if (!manager.productExists(idP)) { System.out.println("ID prodotto non valido."); break; }
                    System.out.print("Nuovo prezzo: ");
                    double prezzo = Double.parseDouble(sc.nextLine());
                    manager.updatePrice(idP, prezzo);
                    break;
                case 3:
                    System.out.print("ID prodotto: ");
                    int idQ = Integer.parseInt(sc.nextLine());
                    if (!manager.productExists(idQ)) { System.out.println("ID prodotto non valido."); break; }
                    System.out.print("Nuova quantità: ");
                    int qty = Integer.parseInt(sc.nextLine());
                    manager.updateQuantity(idQ, qty);
                    break;
                case 4:
                    System.out.print("ID prodotto: ");
                    int idD = Integer.parseInt(sc.nextLine());
                    if (!manager.productExists(idD)) { System.out.println("ID prodotto non valido."); break; }
                    System.out.print("Nuova descrizione: ");
                    String desc = sc.nextLine();
                    manager.updateDescription(idD, desc);
                    break;
                case 5:
                    System.out.print("Nuovo username: ");
                    String nu = sc.nextLine();
                    System.out.print("Password: ");
                    String np = sc.nextLine();
                    System.out.print("Tipo (NORMAL/PRO): ");
                    String nt = sc.nextLine();
                    manager.registerUser(nu, np, nt);
                    break;
                case 6:
                    manager.showAllSales();
                    break;
                case 0:
                    System.out.println("Logout.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);
    }

    static void acquisto(User user) {
        ArrayList<Product> products = manager.getAllProducts();
        for (Product pr : products) System.out.println(pr);
        System.out.print("ID prodotto: ");
        int idP = Integer.parseInt(sc.nextLine());

        //se esaurito (o nullo) esce dall'acquisto, evitando di inserire colore e taglia per un prodotto che non c'è
        Product selected = manager.getProductById(idP);
        if (selected == null || selected.getQuantity() < 1) {
            System.out.println("Prodotto non disponibile.");
            return;
        }

        System.out.println("Colori disponibili: BIANCO, NERO, ROSSO");
        System.out.print("Colore: ");
        String color = sc.nextLine().toUpperCase();
        if (!manager.isValidColor(color)) { System.out.println("Colore non valido."); return; }

        System.out.println("Taglie disponibili: S, M, L, XL");
        System.out.print("Taglia: ");
        String size = sc.nextLine().toUpperCase();
        if (!manager.isValidSize(size)) { System.out.println("Taglia non valida."); return; }

        double pricePreview = manager.getProductById(idP).getPrice();
        double discounted = user.applyDiscount(pricePreview);
        int shipmentId = 1;

        if (discounted > 100) {
            System.out.println("Totale > €100: Express gratuita assegnata automaticamente.");
        } else {
            do {
                System.out.println("Spedizioni disponibili:");
                manager.getShipments();
                System.out.print("ID spedizione: ");
                shipmentId = Integer.parseInt(sc.nextLine());
                if (!manager.isValidShipmentId(shipmentId)) System.out.println("Scelta non valida. Riprova.");
            } while (!manager.isValidShipmentId(shipmentId));
        }

        manager.purchase(user, idP, color, size, shipmentId);
    }
}