package facade;

import db.DatabaseManager;
import decorator.*;
import factory.UserFactory;
import model.*;

import java.sql.*;
import java.util.ArrayList;

public class SalesManager {
    private Connection conn;

    public SalesManager() {
        this.conn = DatabaseManager.getInstance().getConnection();
    }

    // login
    public User login(String username, String password) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM users WHERE username=? AND password=?"
            );
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return UserFactory.create(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("type")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    //registra nuovo utente e lo inserisce nella tabella users
    public void registerUser(String username, String password, String type) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(username, password, type) VALUES(?,?,?)"
            );
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, type.toUpperCase());
            ps.executeUpdate();
            System.out.println("Utente registrato.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // lista di tutti i prodotti
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");
            while (rs.next()) {
                list.add(new Product(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    rs.getInt("category_id")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    //prende prodotto con ID
    public Product getProductById(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM products WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    rs.getInt("category_id")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    //cambia prezzo a prod nel db
    public void updatePrice(int productId, double newPrice) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE products SET price=? WHERE id=?"
            );
            ps.setDouble(1, newPrice);
            ps.setInt(2, productId);
            ps.executeUpdate();
            System.out.println("Prezzo aggiornato.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    //aggiorna qnt prod nel db
    public void updateQuantity(int productId, int newQuantity) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE products SET quantity=? WHERE id=?"
            );
            ps.setInt(1, newQuantity);
            ps.setInt(2, productId);
            ps.executeUpdate();
            System.out.println("Quantità aggiornata.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void updateDescription(int productId, String newDescription) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE products SET description=? WHERE id=?"
            );
            ps.setString(1, newDescription);
            ps.setInt(2, productId);
            ps.executeUpdate();
            System.out.println("Descrizione aggiornata.");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void purchase(User user, int productId, String color, String size, int shipmentId) {
        try {
            Product base = getProductById(productId); //check base su esistenza
            if (base == null) { System.out.println("Prodotto non trovato."); return; }
            if (base.getQuantity() < 1) { System.out.println("Prodotto esaurito."); return; }

            Product decorated = new ColorDecorator(new SizeDecorator(base, size), color);
            System.out.println("Prodotto selezionato: " + decorated.getDescription());

            double price = user.applyDiscount(base.getPrice()); //applica sconto in base all'utente
            double shipmentCost = 0;

            if (price > 100) { //sped gratis e settata a express se spende piu di 100
                shipmentId = getExpressShipmentId();
                System.out.println("Totale superiore a EUR 100 garantisce una spedizione Express gratuita!");
            } else {
                PreparedStatement ps2 = conn.prepareStatement("SELECT cost FROM shipments WHERE id=?");
                ps2.setInt(1, shipmentId);
                ResultSet rs2 = ps2.executeQuery();
                if (rs2.next()) shipmentCost = rs2.getDouble("cost");
            }

            double total = price + shipmentCost;
            System.out.printf("Totale finale: EUR %.2f%n", total);

            PreparedStatement ps = conn.prepareStatement( //qui aggiorna la tabella sales
                "INSERT INTO sales(user_id, product_id, shipment_id, quantity_bought, total_price) VALUES(?,?,?,1,?)"
            );
            ps.setInt(1, user.getId());
            ps.setInt(2, productId);
            ps.setInt(3, shipmentId);
            ps.setDouble(4, total);
            ps.executeUpdate();

            updateQuantity(productId, base.getQuantity() - 1); //qui aggiorna le quantità disponibili (-1 perche il prodotto è stato venduto)
            System.out.println("Acquisto completato.");

        } catch (SQLException e) { e.printStackTrace(); }
    }

    //serve a forzare una Express gratis quando un User PRO supera 100 euro
    private int getExpressShipmentId() {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT id FROM shipments WHERE type='EXPRESS'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("id");
        } catch (SQLException e) { e.printStackTrace(); }
        return 1;
    }

    //restituisce le opzioni di spedizione disponibili
    public ArrayList<int[]> getShipments() {
        ArrayList<int[]> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM shipments");
            while (rs.next()) {
                System.out.println("[" + rs.getInt("id") + "] " + rs.getString("type") + " EUR " + rs.getDouble("cost"));
                list.add(new int[]{rs.getInt("id")});
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    // mostra le vendite effettuate, registrate nella tabella sales.
    public void showAllSales() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT s.id, u.username, p.name, sh.type, s.total_price, s.sale_date " +
                "FROM sales s " +
                "JOIN users u ON s.user_id=u.id " +
                "JOIN products p ON s.product_id=p.id " +
                "JOIN shipments sh ON s.shipment_id=sh.id"
            );

            if (!rs.next()) {
            System.out.println("Non è successo niente...");
            return;
        }
            while (rs.next()) {
                System.out.println("Vendita #" + rs.getInt("s.id") +
                    " | " + rs.getString("u.username") +
                    " | " + rs.getString("p.name") +
                    " | " + rs.getString("sh.type") +
                    " | EUR " + String.format("%.2f", rs.getDouble("total_price")) +
                    " | " + rs.getString("s.sale_date"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    //mostra vendite da tabella sales quando id_user = 1 a quello del login attuale
    public void showUserSales(int userId) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT s.id, p.name, sh.type, s.total_price, s.sale_date " +
                "FROM sales s " +
                "JOIN products p ON s.product_id=p.id " +
                "JOIN shipments sh ON s.shipment_id=sh.id " +
                "WHERE s.user_id=?"
            );
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
            System.out.println("Non è successo niente...");
            return;
            }

            while (rs.next()) {
                System.out.println("Vendita#" + rs.getInt("s.id") +
                    " | " + rs.getString("p.name") +
                    " | " + rs.getString("sh.type") +
                    " | EUR " + String.format("%.2f", rs.getDouble("total_price")) +
                    " | " + rs.getString("s.sale_date"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }


    //array per aggiungere colore e taglia. usati in App.java

    public static final String[] COLORS = {"BIANCO", "NERO", "ROSSO"};
    public static final String[] SIZES  = {"S", "M", "L", "XL"};

    //funzioni per check colore/taglia nel menu in App.java
    public boolean isValidColor(String color) {
        for (String c : COLORS) if (c.equalsIgnoreCase(color)) return true;
        return false;
    }

    public boolean isValidSize(String size) {
        for (String s : SIZES) if (s.equalsIgnoreCase(size)) return true;
        return false;
    }

}