import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author jk
 * @version 1.0.0
 * @create 2019/10/30 15:18
 */
public class Demo06 {
    public static void main(String[] args) throws ParseException {
        Date startTime = new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-26");
        Date endTime = new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-02");
        Calendar c = Calendar.getInstance();
        c.setTime(startTime);
        // c.setTime(endTime);
        List<String> list = new ArrayList();
        String tableName="as_device_event_his_alarm_";
        String aa = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        while (Integer.parseInt(sdf.format(c.getTime())) <= Integer.parseInt(sdf.format(endTime))) {//判断是否到结束日期
                String str = sdf.format(c.getTime());
            System.out.println("===>"+str);
            if (str.equals(sdf.format(new Date()))) {
                     aa = "as_device_event_alarm";
                } else {
                    aa=tableName+""+str;
                }
            list.add(aa);
            System.out.println(aa);
            c.add(Calendar.MONTH, 1);//进行当前日期月份加1
            }
        System.out.println(list);//输出日期结果
    }

}
