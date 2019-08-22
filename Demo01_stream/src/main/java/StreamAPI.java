/**
 * @Author ke
 * @create 2019/8/22 13:14
 * @version 1.0.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/22 13:14
 */
public class StreamAPI {

    /**
     * Stream的中间操作
     * <p>
     * 多个中间操作可以连接起来形成一个流水线,除非流水线上
     * 触发终止操作,否则中间操作不会执行任何的处理,而在终止操作时一次性全部处理,称为" 惰性求值 "
     * <p>
     * 筛选与切片
     * filter(Predicate p) — 接收 Lambda ， 从流中排除某些元素
     * distinct() — 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     * limit(long maxSize) —— 截断流，使其元素不超过给定数量
     * skip(long n) — 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，
     * 则返回一个空流。与 limit(n) 互补
     *
     * 映射
     * map(Function f)——接收 Lambda ， 将元素转换成其他形式或提取信息;接收一个函数作为参数，
     * 该函数会被应用到每个元素上，并将其映射成一个新的元素
     * mapToDouble(ToDoubleFunction f)
     * mapToLong(ToLongFunction f)
     * flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     *
     * 排序
     * sorted() 产生一个新流,其中按自然顺序排序
     * sorted(Comparator comp) 产生一个新流,其中按比较器顺序排序
     */
    List<Employee> employees = Arrays.asList(
            new Employee("张三",25,3333d, Employee.Status.BUSY),
            new Employee("李四",30,9999d, Employee.Status.FREE),
            new Employee("王五",35,6666d, Employee.Status.FREE),
            new Employee("王五",35,6666d, Employee.Status.VOCATION),
            new Employee("赵六",40,5555d, Employee.Status.VOCATION),
            new Employee("田七",35,7777d, Employee.Status.FREE)
    );

    @Test
    public void test1() {
        System.out.println("测试流的中间操作方法map()");
        employees.stream().map(Employee::getAge).forEach(System.out::println);
        //得到工资大于5000的前两位员工
        employees.stream()
                .filter((e)->{
                    System.out.println("短路...");
                    return e.getSalary() >= 5000;
                }).limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        System.out.println("测试流的中间操作filter()");
        //得到除了前两位外工资大于5000员工
        employees.stream()
                .filter((e)->e.getSalary()>5000)
                .skip(2).map(Employee::getSalary)
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        System.out.println("测试流的中间操作distinct()");
        //出去重复的员工
        employees.stream()
                .distinct()
                .forEach(System.out::println);
    }
    @Test
    public void test4() {
        System.out.println("测试流的中间操作mapToInt()");
        employees.stream()
                .mapToInt(Employee::getAge)
                .forEach(System.out::println);
    }

    @Test
    public void test5() {
        //将拼音按照字母排序
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "AAA", "BBB", "CCC");
        list.stream()
                .map(StreamAPI::filterCharacter)
                .forEach((e)->{
                    e.forEach(System.out::print);
                });
        System.out.println("-----------------");
        list.stream()
                .flatMap(StreamAPI::filterCharacter)
                .forEach(System.out::print);
        System.out.println("------------------");
        list.stream()
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::print);
    }

    @Test
    public void test6() {
        System.out.println("测试流的中间操作sorted()");
        employees.stream()
                .sorted((x,y)->{
                    if (x.getAge() == y.getAge()) {
                        return x.getName().compareTo(y.getName());
                    } else {
                        return -Integer.compare(x.getAge(), y.getAge());
                    }
                }).forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
