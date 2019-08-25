public class NoneDiscount extends Discount {
    public NoneDiscount() {
        super("不参与优惠活动");
    }

    @Override
    double discount(double price) {
        finalPrice = price;
        return finalPrice;
    }
}