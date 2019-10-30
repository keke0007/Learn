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
        Date startTime = new SimpleDateFormat("yyyy-MM-dd").parse("2019-06-01");
        Date endTime = new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-30");
        Calendar c = Calendar.getInstance();
        c.setTime(startTime);
        // c.setTime(endTime);
        List<String> list = new ArrayList();
        String tableName="as_device_event_his_alarm_";
        String aa = "";
        while (c.getTime().getTime() <= endTime.getTime()) {//判断是否到结束日期
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
                String str = sdf.format(c.getTime());
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
