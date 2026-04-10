package factory;

import model.*;

public class UserFactory {
    public static User create(int id, String username, String password, String type) { //crea user a seconda del ruolo che gli si da.
        switch (type.toUpperCase()) {
            case "PRO":   return new ProUser(id, username, password);
            case "ADMIN": return new Admin(id, username, password);
            default:      return new NormalUser(id, username, password);
        }
    }
}