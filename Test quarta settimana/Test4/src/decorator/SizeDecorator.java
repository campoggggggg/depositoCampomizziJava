package decorator;

import model.Product;

public class SizeDecorator extends ProductDecorator {
    private String size;

    public SizeDecorator(Product product, String size) {
        super(product);
        this.size = size;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " | Taglia: " + size;
    }
}