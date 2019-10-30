import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Demo00 {
    /**
     * stream流用于统计聚合运算
     * @param args
     */
    public static void main(String[] args) throws ParseException {
        // List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // IntSummaryStatistics stats = numbers.stream().mapToInt((a) -> a).summaryStatistics();
        // System.out.println("列表中的最大的数:  " + stats.getMax());

        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startTime = "2019-10-29";
        System.out.println(LocalDate.parse(startTime, dtf));
        Date parse = sdf.parse(startTime);
        Calendar c = Calendar.getInstance();
        c.setTime(parse);
        System.out.println(c.get(Calendar.MONTH));*/

        String startTime = "2019-04-01";
        String endTime = "2019-10-01";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //LocalDate转Date
        Date startDate = DateUtils.asDate(LocalDate.parse(startTime, dtf));
        Date endDate = DateUtils.asDate(LocalDate.parse(endTime, dtf));
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        int start = c.get(Calendar.MONTH);
        System.out.println(start);
        c.setTime(endDate);
        int end = c.get(Calendar.MONTH);
        System.out.println(end);

        String format="";
            format="_yyyyMM";
        int t=Calendar.MONTH;


        // if(format.length()==0)
        List<String> dateStr=new ArrayList<>();
        Calendar calendar = Calendar.getInstance();//获取日历
        calendar.setTime(startDate);//当date的值是当前时间，则可以不用写这段代码。
        dateStr.add(new SimpleDateFormat(format).format(startDate));
        for(int i=1;i<=4;i++){//正序
            calendar.add(t,-1);
            Date d = calendar.getTime();//把日历转换为Date
            dateStr.add(new SimpleDateFormat(format).format(d));
        }
        System.out.println(dateStr);
    }
}
