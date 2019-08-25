public class Dis9Discount extends Discount {
    public Dis9Discount() {
        super("打九折");
    }

    @Override
    double discount(double price) {
        finalPrice = price * 0.9;
        return finalPrice;
    }
}