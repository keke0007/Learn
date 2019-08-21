/**
 * @Author ke
 * @create 2019/8/21 14:48
 * @version 1.0.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/21 14:48
 */
public class FunctionalInterface {
    /*
    * 函数式接口指: 只包含一个抽象方法的接口,称为函数式接口
    * 你可以通过Lambda表达式来创建该接口的对象.(
    * 若 Lambda 表达式抛出一个受检异常,那么该异常需要在目标接口的抽象方法上进行声明)
    *
    * 我们可以在任意函数式接口上使用FunctionalInterface注解,这样做可以检查它是否是一个函数式接口,
    * 同时javadoc也会包含一条说明,说明这个接口时一个函数式接口
    *
    * Java8 内置的四大核心函数式接口
    *
    * Consumer<T> : 消费型接口
    *   void accept( T t);
    * Supplier<T> : 供给型接口
    *   T get();
    * Function<T,R> : 函数型接口
    *   R apply(T t);
    * Predication<T> : 断言型接口
    *   boolean test(T t);
    * */

    @Test
    public void test1() {
        System.out.println("测试供给型接口");
        happy(100d, (a) -> System.out.println("消费: " + a + "元"));
    }

    public void happy(Double d, Consumer<Double> con) {
        con.accept(d);
    }

    @Test
    public void test2() {
        System.out.println("测试供给型接口");
        List numList = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(numList);
    }

    //产生指定个数的整数方法集合中
    public List getNumList(Integer num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (Integer i = 0; i < num; i++) {
            Integer s = supplier.get();
            list.add(s);
        }
        return list;
    }

    @Test
    public void test3() {
        System.out.println("测试函数式接口");

        System.out.println(handlerStr("abcde", (str) -> str.toUpperCase()));
    }

    //处理字符串
    public String handlerStr(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("abd", "a", "abcd", "abd");
        System.out.println("测试断言型接口");
        System.out.println(filterStr(list, (str) -> str.length() > 3));

    }

    //将满足要求的字符串放入集合中
    public List filterStr(List<String> list, Predicate<String> pre) {
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                list1.add(s);
            }
        }
        return list1;
    }
}
