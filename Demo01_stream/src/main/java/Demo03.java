import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/12 13:30
 */
public class Demo03 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//
//        获取最大的数
//        list.stream().forEach(System.out::println);
        int max = list.stream().mapToInt(x -> x).summaryStatistics().getMax();
        System.out.println(max);

    }
}
