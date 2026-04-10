package model;

import strategy.DiscountStrategy;

public abstract class User {
    protected int id;
    protected String username;
    protected String password;
    protected String type;
    protected DiscountStrategy discountStrategy;

    public User(int id, String username, String password, String type, DiscountStrategy discountStrategy) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.discountStrategy = discountStrategy;
    }

    public double applyDiscount(double price) {
        return discountStrategy.applyDiscount(price);
    }

    public abstract void showMenu();

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getType() { return type; }
}