import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Demo02 {
    public static void main(String[] args) {
        //Lambda的逻辑判断
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.println("输出所有数字: ");
        evaluate(list,(n) -> true);

        System.out.println("不输出所有数字: ");
        evaluate(list, (n) -> false);

        System.out.println("输出偶数: ");
        evaluate(list, (n) -> n % 2 == 0);

        System.out.println("输出大于5的数");
        evaluate(list, (n) -> n > 5);
    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }
}
