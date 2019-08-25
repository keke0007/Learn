import java.text.MessageFormat;

public class Shopping {
    private String goods;
    private double price;
    private Discount discount;

    public Shopping(String goods, double price, Discount discount) {
        this.goods = goods;
        this.price = price;
        this.discount = discount;
    }

    public double calculate() {
        double finalPrice = discount.discount(this.price);
        String desc = discount.getDesc();
        System.out.println(MessageFormat.format("购买的物品：{0}，原始价格：{1}，{2}，最终价格为：{3}", goods, price, desc, finalPrice));
        return finalPrice;
    }
}