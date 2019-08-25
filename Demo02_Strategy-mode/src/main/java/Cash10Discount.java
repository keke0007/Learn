public class Cash10Discount extends Discount {
    public Cash10Discount() {
        super("返现10元");
    }

    @Override
    public double discount(double price) {
        this.finalPrice = price >= 10 ? price - 10 : 0;
        return finalPrice;
    }
}
