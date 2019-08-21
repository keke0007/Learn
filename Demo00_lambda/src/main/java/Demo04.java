/**
 * @Author ke
 * @create 2019/8/21 13:28
 * @version 1.0.0
 */

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/21 13:28
 */
public class Demo04 {
    public static void main(String[] args) {

        //讲一个字符串转化成大写
        System.out.println(getFun("abc", (str) -> str.toUpperCase()));
        //将一个字符串的第二个和第四个索引位置进行截取子串
        System.out.println(getFun("我现在在使用Lambda表达式", string -> string.substring(1, 3)));
    }

    //处理字符串
    public static String getFun(String str, Fun fun) {
        return fun.getValue(str);
    }
}
