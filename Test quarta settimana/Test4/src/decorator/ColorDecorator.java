package decorator;

import model.Product;

public class ColorDecorator extends ProductDecorator {
    private String color;

    public ColorDecorator(Product product, String color) {
        super(product);
        this.color = color;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " | Colore: " + color;
    }
}