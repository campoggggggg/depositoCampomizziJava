package decorator;

//array che i decorator usano per aggiungere colore e taglia.
public class ProductVariants {
    public static final String[] COLORS = {"BIANCO", "NERO", "ROSSO"};
    public static final String[] SIZES  = {"S", "M", "L", "XL"};

    public static boolean isValidColor(String color) {
        for (String c : COLORS) if (c.equalsIgnoreCase(color)) return true;
        return false;
    }

    public static boolean isValidSize(String size) {
        for (String s : SIZES) if (s.equalsIgnoreCase(size)) return true;
        return false;
    }
}