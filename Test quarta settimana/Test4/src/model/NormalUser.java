package model;

import strategy.NoDiscount;

public class NormalUser extends User {
    public NormalUser(int id, String username, String password) {
        super(id, username, password, "NORMAL", new NoDiscount());
    }

    @Override
    public void showMenu() {
        System.out.println("=== MENU UTENTE NORMALE ===");
        System.out.println("1. Visualizza prodotti");
        System.out.println("2. Acquista prodotto");
        System.out.println("0. Logout");
    }
}