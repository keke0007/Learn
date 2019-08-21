import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/20 9:56
 */
public class Demo04 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        /*List<Something> collect = Stream.of(list1, list2).flatMap(Collection::stream)
                .collect(Collectors.groupingBy(t -> t.getId(),
                        Collectors.summingInt(x -> x.getCount())))
                .entrySet().stream().map(entry -> new Something(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());*/
        list1.addAll(list2);
        System.out.println(list1);
    }
}
