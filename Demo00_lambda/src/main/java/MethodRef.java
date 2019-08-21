/**
 * @Author ke
 * @create 2019/8/21 15:39
 * @version 1.0.0
 */

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/21 15:39
 */
public class MethodRef {
    /*
    * 一:方法引用 : 若 Lambda 体中的功能,已经有方法提供了实现,可以使用方法引用
    * (可以将方法引用理解为 Lambda表达式的另外一种表现形式)
    *
    * 方法引用: 使用操作符 "::" 将方法名和对象或类的名字分隔开来
    *
    * 方法引用的三种主要情况
    * 1. 对象::实例方法
    * 2. 类名::静态方法
    * 3. 类名::实例方法
    * 注意事项:
    *   1.方法引用所引用的方法的参数列表与返回值类型,
    *   需要与函数式接口中抽象方法的参数列表和返回值类型保持一致
    *   2.若Lambda的参数列表的第一个参数,是实例方法的调用者,
    *   第二个参数(或无参)是实例方法的参数时,格式 : ClassName::MethodName
    *
    * 二:构造器引用 : 构造器的参数列表,需要与函数式接口中参数列表一致
    *   类名::new
    *
    * 三: 数组引用
    *   类型[]::new
    *
    * */
    @Test
    public void test1() {
        PrintStream ps = System.out;
        Consumer<String> con1=(str)->ps.println(str);
        con1.accept("未使用方法引用");
        System.out.println("-------------------");
        Consumer<String> con2 = ps::println;
        con2.accept("使用方法引用");
        System.out.println("-------------------");
        Consumer<String> con3 = System.out::println;
        con3.accept("测试方法引用");
    }

    @Test
    public void test2() {
        Employee employee =new Employee("张三",20,999d);
        Supplier<String> sup1 = () -> employee.getName();
        System.out.println(sup1.get());
        System.out.println("测试 对象::方法名 的方法引用");
        System.out.println("----------------");
        Supplier<String> sup2 = employee::getName;
        System.out.println(sup2.get());
    }

    @Test
    public void test3() {
        BiFunction<Integer, Integer, Integer> fun1 = (x, y) -> Math.max(x, y);
        System.out.println(fun1.apply(1, 10));
        System.out.println("------------------");
        System.out.println("测试 类名::静态方法 的方法引用");
        BiFunction<Integer, Integer, Integer> fun2 = Math::max;
        System.out.println(fun2.apply(10, 100));
    }

    @Test
    public void test4() {
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> com2 = (x, y) -> x.compareTo(y);
        System.out.println("测试 类名::静态方法 的方法引用");
        Comparator<Integer> com3 = Integer::compareTo;
    }

}
