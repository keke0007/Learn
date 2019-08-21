public class Dis8Discount extends Discount{
    public Dis8Discount() {
        super("打八折");
    }

    @Override
    double discount(double price) {
        finalPrice = price * 0.8;
        return finalPrice;
    }
}
