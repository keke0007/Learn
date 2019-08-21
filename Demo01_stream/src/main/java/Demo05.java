import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/20 17:44
 */
public class Demo05 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");

        System.out.println(list);
        list = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(toList());
        System.out.println(list);
    }
}
