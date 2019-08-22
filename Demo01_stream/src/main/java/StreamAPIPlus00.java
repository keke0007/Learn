/**
 * @Author ke
 * @create 2019/8/22 14:57
 * @version 1.0.0
 */

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/22 14:57
 */
public class StreamAPIPlus00 {
    /**
     *        归约
     *      * reduce(T iden,BinaryOperator b) 可以将流中元素反复结合起来,得到一个值,返回T
     *      * reduce(BinaryOperator b) 可以将流中元素反复结合起来,得到一个值,返回Optional<T>
     *      * 注意事项:
     *      * map和reduce的连接常称为map-reduce模式,因Google用它来进行网络搜索而出名
     *      *
     *      * 收集
     *      * collect(Collector c) 将流转换为其他形式,接收一个Collector接口的实现,用于
     *      * 给Stream中的元素做汇总的方法
     *      *
     *      * Collector 接口中方法的实现决定了如何对流执行收集操作(如收集到List, Set ,Map)
     *      * 但是Collectors实用类提供了很多静态方法,可以方便地创建常见收集器实例
     */
    List<Employee> employees = Arrays.asList(
            new Employee("张三",25,3333d, Employee.Status.BUSY),
            new Employee("李四",30,9999d, Employee.Status.FREE),
            new Employee("王五",35,6666d, Employee.Status.FREE),
            new Employee("王五",35,6666d, Employee.Status.VOCATION),
            new Employee("赵六",40,5555d, Employee.Status.VOCATION),
            new Employee("赵六",40,5555d, Employee.Status.VOCATION),
            new Employee("赵六",40,5555d, Employee.Status.VOCATION),
            new Employee("田七",35,7777d, Employee.Status.FREE)
    );

    @Test
    public void test1() {
        System.out.println("测试终止流的操作reduce()");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        /*Optional<Integer> reduce = list.stream()
                .reduce((x, y) -> x + y);*/
        Optional<Integer> reduce = list.stream()
                .reduce(Integer::sum);
        System.out.println(reduce.get());
        System.out.println("------------------------");
        Optional<Double> reduce1 = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(reduce1.get());
    }

    @Test
    public void test2() {
        System.out.println("reduce()方法的应用");
        /*搜索员工名字中出现"六"的个数*/
        Optional<Integer> optional = employees.stream()
                .map(Employee::getName)
                .flatMap(StreamAPI::filterCharacter)
                .map((ch) -> {
                    if (ch.equals('六'))
                        return 1;
                    else
                        return 0;
                }).reduce(Integer::sum);

        System.out.println(optional.get());
    }

    @Test
    public void test3() {
        System.out.println("collect()方法的测试");
        List<String> collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        collect.forEach(System.out::print);
        System.out.println("--------------");
        Set<String> collect1 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        collect1.forEach(System.out::println);
        System.out.println("------------转换成其他类型的集合--------");
        employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new))
                .forEach(System.out::println);
    }

    @Test
    public void test4() {
        System.out.println("collect()方法的应用");
        Optional<Integer> collect = employees.stream()
                .map(Employee::getAge)
                .collect(Collectors.maxBy(Integer::compareTo));
        System.out.println(collect.get());
        //找出工资最低的员工
       /* Optional<Employee> min = employees.stream()
                .min((x, y) -> Double.compare(x.getSalary(), y.getSalary()));
        System.out.println(min.get())*/;
        Optional<Employee> collect1 = employees.stream()
                .collect(Collectors.minBy((x, y) -> Double.compare(x.getSalary(), y.getSalary())));
        System.out.println(collect1.get());
        //求出员工工资的总和
        System.out.println("求出工资的总和");
        /*DoubleSummaryStatistics collect2 = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect2.getSum());*/
        Double collect2 = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect2);
        System.out.println("求出员工工资的平均值");
        Double collect3 = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect3);
        /*求出员工的总人数*/
        /*long count = employees.stream()
                .count();*/
        Long collect4 = employees.stream()
                .collect(Collectors.counting());
        System.out.println(collect4);
    }

    /*分组*/
    @Test
    public void test5() {
        /*关于collect()方法之后的分组*/
        /*需求: 根据员工状态分组*/
        Map<Employee.Status, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        // collect.entrySet().forEach(System.out::println);
        System.out.println(collect);
    }

    /*多级分组*/
    @Test
    public void test6() {
        Map<Employee.Status, Map<String, List<Employee>>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,
                        Collectors.groupingBy((e) -> {
                            if (e.getAge() >= 60)
                                return "老年";
                            else if (e.getAge() >= 35)
                                return "中年";
                            else if (e.getAge() >= 18) {
                                return "成年";
                            }
                            return "未成年";
                        })));
        System.out.println(collect);
    }

    /*分区*/
    @Test
    public void test7() {
        Map<Boolean, List<Employee>> collect = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));
        System.out.println(collect);
    }

    /*joining有方法的重载*/
    @Test
    public void test8() {
        String collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",","---","----"));
        System.out.println(collect);
    }

    /*reduce()求和*/
    @Test
    public void test9() {
        Optional<Double> collect = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.reducing(Double::sum));
        System.out.println(collect.get());
    }
}
