/**
 * @author aswl.com
 * @version 1.0.0
 * @create 2019/9/24 14:22
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abc").append(true).append(123);
        StringBuilder sb1 = sb.append(1);
        System.out.println("sb==sb1" + (sb == sb1));
        System.out.println(sb.toString());
        System.out.println(sb1.toString());
        sb.insert(1,"我");
        System.out.println(sb.toString());
        System.out.println(sb1.toString());
        System.out.println(sb1.charAt(1));
        System.out.println("参考链接: https://blog.csdn.net/chaoyu168/article/details/49300605");
    }
}
