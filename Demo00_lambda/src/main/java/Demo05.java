/**
 * @Author ke
 * @create 2019/8/21 13:41
 * @version 1.0.0
 */

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/21 13:41
 */
public class Demo05 {
    public static void main(String[] args) {
        // System.out.println(getFun(10, 100, (a, b) -> a + b));
        System.out.println(getFun(10, (a) -> a * 100));

    }

    //定义函数中的方法
    public static Integer getFun(Integer a, Fun1<Integer,Integer> fun1) {
        return fun1.getValue(a);
    }
}
