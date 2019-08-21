import lombok.Data;

@Data
public abstract class Discount {
    protected double finalPrice;
    protected String desc;

    public Discount(String desc) {
        this.desc = desc;
    }

    abstract double discount(double price);
}
