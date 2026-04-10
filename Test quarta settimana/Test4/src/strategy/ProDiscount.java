package strategy;

public class ProDiscount implements DiscountStrategy{
    private static final double DISCOUNT = 0.95;

    @Override
    public double applyDiscount(double price) {
        return price * DISCOUNT;
    }
}
