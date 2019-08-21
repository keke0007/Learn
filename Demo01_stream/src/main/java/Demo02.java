import java.util.Arrays;
import java.util.List;

public class Demo02 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //传统方式
        int sum = 0;
        for (Integer n : list) {
            int x = n * n;
            sum += x;
        }
        System.out.print(sum + " ");
        System.out.println("---------分割线-------------------");
        //stream流方式
        System.out.println(list.stream().map((x) -> x * x).reduce((x, y) -> x + y).get());
    }
}
