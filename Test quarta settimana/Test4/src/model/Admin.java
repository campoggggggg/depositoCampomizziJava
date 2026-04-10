package model;

import strategy.NoDiscount;

public class Admin extends User {
    public Admin(int id, String username, String password) {
        super(id, username, password, "ADMIN", new NoDiscount());
    }

    @Override
    public void showMenu() {
        System.out.println("=== MENU ADMIN ===");
        System.out.println("1. Visualizza prodotti");
        System.out.println("2. Modifica prezzo prodotto");
        System.out.println("3. Modifica quantità prodotto");
        System.out.println("4. Modifica descrizione prodotto");
        System.out.println("5. Aggiungi nuovo utente");
        System.out.println("6. Visualizza tutte le vendite");
        System.out.println("0. Logout");
    }
}