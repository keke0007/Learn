public class Test {
    public static void main(String[] args) {
        Shopping shopping1 = new Shopping("书籍-深入理解Java虚拟机", 54.00, new Dis9Discount());
        shopping1.calculate();

        Shopping shopping2 = new Shopping("Apple 妙控鼠标", 588.00, new Dis8Discount());
        shopping2.calculate();

        Shopping shopping3 = new Shopping("戴尔U2417H显示器", 1479.00, new Cash10Discount());
        shopping3.calculate();

        Shopping shopping4 = new Shopping("索尼ILCE-6000L相机", 3599.00, new NoneDiscount());
        shopping4.calculate();
    }
}
