/**
 * @author jk
 * @version 1.0.0
 * @create 2019/11/11 17:54
 */
public class Demo07 {
    public static void main(String[] args) {

        //取字符串中包含的字符串
        String[] types = {"SmogValueAlarm"};
        for (int i = 0; i < types.length; i++) {
            System.out.println(types[i].substring((types[i].length() - 5), types[i].length()));
        }
    }
}
