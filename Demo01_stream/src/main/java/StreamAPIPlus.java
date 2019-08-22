/**
 * @Author ke
 * @create 2019/8/22 14:02
 * @version 1.0.0
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/22 14:02
 */
public class StreamAPIPlus {

    /**
     * Stream流的终止操作
     * 终端操作会从流的流水线生成结果,其结果可以是任何不是流的值
     * 例如: List,Integer,甚至是 void
     * 查找与匹配
     * allMatch(Predicate p)——检查是否匹配所有元素
     * anyMatch(Predicate p)——检查是否至少匹配一个元素
     * noneMatch(Predicate p)——检查是否没有匹配的元素
     * findFirst()——返回第一个元素
     * findAny()——返回当前流中的任意元素
     *
     * count()——返回流中元素的总个数
     * max(Comparator c)——返回流中最大值
     * min(Comparator c)min——返回流中最小值
     * forEach(Consumer c)
     *
     * 归约
     * reduce(T iden,BinaryOperator b) 可以将流中元素反复结合起来,得到一个值,返回T
     * reduce(BinaryOperator b) 可以将流中元素反复结合起来,得到一个值,返回Optional<T>
     * 注意事项:
     * map和reduce的连接常称为map-reduce模式,因Google用它来进行网络搜索而出名
     *
     * 收集
     * collect(Collector c) 将流转换为其他形式,接收一个Collector接口的实现,用于
     * 给Stream中的元素做汇总的方法
     *
     * Collector 接口中方法的实现决定了如何对流执行收集操作(如收集到List, Set ,Map)
     * 但是Collectors实用类提供了很多静态方法,可以方便地创建常见收集器实例
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

        System.out.println("测试终止流操作的方法allMatch()");
        boolean b = employees.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
        System.out.println("------------------");
        System.out.println("测试终止流操作的方法anyMatch()");
        boolean b1 = employees.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);
    }

    @Test
    public void test2() {
        System.out.println("测试终止流操作的方法findFirst()");
        Optional<Employee> first = employees.stream()
                .sorted((x, y) -> Double.compare(x.getSalary(), y.getSalary()))
                .findFirst();
        System.out.println(first.get());
        System.out.println("测试终止流操作的方法findAny()");
        Optional<Employee> any = employees.parallelStream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(any.get());
    }

    @Test
    public void test3() {
        System.out.println("-------------测试终止流操作的方法count---------");
        long count = employees.stream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .count();
        System.out.println(count);
        System.out.println("----------测试终止流操作的方法max()------------");
        Optional<Integer> max = employees.stream()
                .map(Employee::getAge)
                .max(Integer::compareTo);
        System.out.println(max.get());
        System.out.println("----------测试终止流操作的方法min()-----------");
        Optional<Employee> min = employees.stream()
                .min((x, y) -> Double.compare(x.getSalary(), x.getSalary()));
        System.out.println(min.get());
    }

    @Test
    public void test4() {
        /*流进行终止操作之后不能再次使用*/
        Stream<Employee> stream = employees.stream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE));
        long count = stream.count();
        /*stream流已经进行了终止操作,后面进行的操作不能运行,编译会报错
        * java.lang.IllegalStateException: stream has already been operated upon or closed*/
        Optional<String> max = stream.map(Employee::getName)
                .max(String::compareTo);
    }
}
