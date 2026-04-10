package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singleton che serve a connettersi al DB su mySQL per gestire le tabelle e il gestionale

public class DatabaseManager {

    private static DatabaseManager instance;
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:8889/gestionale";
    private static final String USER = "root";
    private static final String PASSWORD = "Gastly1!";

    private DatabaseManager() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connessione DB avvenuta.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}