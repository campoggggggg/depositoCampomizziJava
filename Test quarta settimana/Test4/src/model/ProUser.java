package model;

import strategy.ProDiscount;

public class ProUser extends User {
    public ProUser(int id, String username, String password) {
        super(id, username, password, "PRO", new ProDiscount());
    }

    @Override
    public void showMenu() {
        System.out.println("=== MENU UTENTE PRO ===");
        System.out.println("1. Visualizza prodotti");
        System.out.println("2. Acquista prodotto (sconto 5%)");
        System.out.println("3. Storico acquisti");
        System.out.println("0. Logout");
    }
}