/**
 * @Author ke
 * @create 2019/8/22 9:30
 * @version 1.0.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/22 9:30
 */
public class Stream {
    /**
    * Java8 中有两个最为重要的改变,第一个是 Lambda 表达式,另外一个则是
    * Stream API (java.util.stream.*)
    * Stream 是 Java8 中处理集合的关键抽象概念,它可以指定你希望对集合进行的操作,
    * 可以执行非常复杂的查找,过滤和映射数据等操作
    * 使用Stream API 对集合数据进行操作,就类似于使用SQL执行的数据库查询,也可以使用
    * Stream API 来并行执行操作,简而言之, Stream API 提供了一种高效且易于使用的
    * 处理数据的方式.
    *
    * 关于流(Stream)的定义?
    * Stream 是数据渠道,用于操作数据源(集合,数组等)所生成的元素序列,
    * "集合将的是数据 , 流讲的是计算"
    * 注意事项:
    * 1. Stream 自己不会存储元素
    * 2. Stream 不会改变源对象,相反,他们会返回一个持有结果的新的Stream
    * 3. Stream 操作是延迟执行的,这意味着他们会等到需要结果的时候才执行
    *
    * Stream 操作的三个步骤
    * 1. 创建 Stream
    * 一个数据源(如: 集合,数组),获取一个流
    *
    * 2. 中间操作
    * 一个中间操作链,对数据源的数据进行处理
    *
    * 3. 终止操作
    * 一个终止操作,执行中间操作链,并产生结果
    *
    * 数据源 --> |filter -> map -> ...| -->终止操作
    *
    * 创建Stream的方式
    * 1.Java8中的 Collection 接口被扩展,提供了两个获取流的方法
    * default Stream<E> stream() : 返回一个顺序流
    * default Stream<E> parallelStream() : 返回一个并行流
    *
    * 2.Java8 中的Arrays 的静态方法 stream()可以获取数组流
    * static <T> Stream<T> stream(T[] array) :返回一个流
    * 重载形式,能够处理对应的基本类型的数组
    * public static IntStream stream(int[] array);
    * public static LongStream stream(Long[] array);
    * public static DoubleStream stream(Double[] array);
    *
    * 3.由值创建流
    * 可以使用静态方法 Stream.of(),通过显示值创建一个流,
    * 它可以接受任意数量的参数
    * public static<T> Stream<T> of(T... values) 返回一个流
    *
    * 4.由函数创建流,创建无线流
    * 可以使用静态方法 Stream.iterate() 和Stream.generate()创建无限流
    *
    * 1.迭代
    * public static<T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)
    * 2.生成
    * public static<T> Stream<T> generate(Supplier<T> s)
    * */

    @Test
    public void test1() {
        System.out.println("测试由Collection.stream创建流");
        // List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list = new ArrayList<>();
        java.util.stream.Stream<Integer> stream = list.stream();
        java.util.stream.Stream<Integer> integerStream = list.parallelStream();
        System.out.println("----------------------");

        System.out.println("测试由数组获取流");
        Integer[] array = new Integer[10];
        java.util.stream.Stream<Integer> stream1 = Arrays.stream(array);
        System.out.println("------------------");

        System.out.println("测试由常量获取流");
        java.util.stream.Stream<Integer> integerStream1 = java.util.stream.Stream.of(1, 2, 3, 4);
        integerStream1.forEach(System.out::println);
        System.out.println("--------------");
        System.out.println("由函数创建无线流");
        java.util.stream.Stream<Integer> iterate = java.util.stream.Stream.iterate(0, (x) -> x + 2).limit(2);
        iterate.forEach(System.out::println);
        System.out.println("----------------");
        java.util.stream.Stream<Double> generate = java.util.stream.Stream.generate(Math::random).limit(2);
        generate.forEach(System.out::println);
    }

    /**
     * Stream的中间操作
     * <p>
     * 多个中间操作可以连接起来形成一个流水线,除非流水线上
     * 触发终止操作,否则中间操作不会执行任何的处理,而在终止操作时一次性全部处理,称为" 惰性求值 "
     * <p>
     * 筛选与切片
     * filter(Predicate p)
     * distinct()
     * limit(long maxSize)
     * skip(long n)
     * 映射
     * map(Function f)
     * mapToDouble(ToDoubleFunction f)
     * mapToLong(ToLongFunction f)
     * flatMap(Function f)
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
    public void test2() {

        java.util.stream.Stream<Employee> stream = employees.stream().filter((e) -> {
            System.out.println("测试Stream流的中间操作");
            return e.getAge() > 30;
        });
        //只有当Stream流有终止操作时,Stream流的中间操作才会执行
        // stream.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void test3() {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    /**
     * Stream流的终止操作
     * 终端操作会从流的流水线生成结果,其结果可以是任何不是流的值
     * 例如: List,Integer,甚至是 void
     * 查找与匹配
     * allMatch(Predicate p)
     * anyMatch(Predicate p)
     * noneMatch(Predicate p)
     * findFirst()
     * findAny()
     *
     * count()
     * max(Comparator c)
     * min(Comparator c)
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

}
