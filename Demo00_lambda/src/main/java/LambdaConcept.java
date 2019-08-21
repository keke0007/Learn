/**
 * @Author ke
 * @create 2019/8/21 13:59
 * @version 1.0.0
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/21 13:59
 */
public class LambdaConcept {
    /*
     * Lambda 表达式在java语言中引入一个新的语法元素和操作符,
     * 这个操作符为 "->" ,该操作符被称为Lambda 操作符或箭头操作符,
     * 它将 Lambda分成两个部分
     * 左侧 :指定了 Lambda 表达式需要的所有参数
     * 右侧 :指定了 Lambda 体,即 Lambda 表达式要执行的功能 即Lambda体
     *
     * Lambda表达式语法
     *
     * 语法格式一: 无参,无返回值, Lambda体只需一条语句
     *   () -> System.out.println("Hello Lambda!");
     * 语法格式二: Lambda需要一个参数
     *
     * 语法格式三: Lambda只需要一个参数时,参数的小括号可以省略
     *
     * 语法格式四: 有两个以上的参数,有返回值,并且Lambda体中有多条语句
     *
     * 语法格式五: 若 Lambda 体中只有一条语句,return 和 大括号都可以省略不写
     *
     * 语法格式六: Lambda表达式的参数列表的数据类型可以省略不写,因为JVM编译器通过上下文推断出数据类型,
     * 即 "类型推断"
     * */
    @Test
    public void test1() {
        int a = 100;  //注意jdk1.8以前局部变量需要用final修饰
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我使用的是匿名类部类" + a);
            }
        };
        r1.run();
        System.out.println("--------分割线-----------------------------");
        Runnable r = () -> System.out.println("我在测试Lambda表达式的语法格式,无参Lambda表达式");
        r.run();
    }

    @Test
    public void test2(){
        Consumer<String> con = (a) -> System.out.println(a);
        con.accept("我在测试只有一个参数的Lambda表达式");
    }

    @Test
    public void test3() {
        Consumer<String> con = a -> System.out.println(a);
        con.accept("我在测试Lambda语法格式只有一个参数小括号可以省略不写");
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (x,y) -> {
            System.out.println("我在测试Lambda语法格式四有两个以上参数,有返回值," +
                    "并且Lambda体中有多条语句");
            return Integer.compare(x, y);
        };
        System.out.println("我在测试Lambda语法格式四有两个以上参数,有返回值," +
                "并且Lambda体中有多条语句");
    }

    @Test
    public void test5() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        System.out.println("   测试Lambda语法格式五,如果Lambda体中只有一条语句,return和大括号都可以省略不写");
        Comparator<Integer> com1 = Integer::compare;
    }

    @Test
    public void test6() {
        List<String> list = new ArrayList<>();
        show(new HashMap<>());
        System.out.println("测试Lambda表达式语法格式六: 类型推断");
    }
    public void show(HashMap<String,String> map) {

    }
}
