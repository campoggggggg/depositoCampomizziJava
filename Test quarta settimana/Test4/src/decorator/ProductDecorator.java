package decorator;

import model.Product;
/*
classe astratta per i decoratori
*/
public abstract class ProductDecorator extends Product {
    protected Product wrapped;

    public ProductDecorator(Product product) {
        super(product.getId(), product.getName(), product.getDescription(),
              product.getPrice(), product.getQuantity(), product.getCategoryId());
        this.wrapped = product;
    }

    @Override
    public abstract String getDescription();
}