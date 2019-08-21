import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Demo00 {
    /**
     * stream流用于统计聚合运算
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((a) -> a).summaryStatistics();
        System.out.println("列表中的最大的数:  " + stats.getMax());
    }
}
