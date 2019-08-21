import java.util.Arrays;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
//    遍历输出(方法引用)---->使用Lambda表达式
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //传统增强for遍历
        for (Integer n : list) {
            System.out.println(n);
        }
        System.out.println("---------------------------");

//      使用 ->的Lambda表达式
        list.forEach( n -> System.out.println(n));
        System.out.println("----------------------");
//      使用方法引用::的Lambda表达式
        list.forEach(System.out::println);
    }
}
