import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 *
 * @author aswl.com
 * @date 2019/4/28 16:03
 */
public class DateUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter FORMATTER_MILLIS = DateTimeFormatter.ofPattern("yyyyMMddhhmmssSSS");

    /**
     * 日期转string
     *
     * @param date date
     * @return String
     */
    public static String localDateToString(LocalDateTime date) {
        return date != null ? date.format(FORMATTER) : "";
    }

    /**
     * 日期转string
     *
     * @param date date
     * @return String
     */
    public static String localDateMillisToString(LocalDateTime date) {
        return date != null ? date.format(FORMATTER_MILLIS) : "";
    }

    /**
     * LocalDate转Date
     *
     * @param localDate localDate
     * @return Date
     */
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDateTime转Date
     *
     * @param localDateTime localDateTime
     * @return Date
     */
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date转LocalDate
     *
     * @param date date
     * @return LocalDate
     */
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Date转LocalDateTime
     *
     * @param date date
     * @return LocalDateTime
     */
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


    /**
     * 获取指定日期、月份之前或者之后的 日期字符串集合(包括当前日、月、周)
     * @param date 当前日期
     * @param num 天数
     * @param type 类型
     * @return
     */
    public  static  List<String> getBeforeOrAfterDate(Date date, int num , String type) {
        String format="";
        int t= Calendar.DATE;
        if( "day".equals(type)) {
            format = "yyyy-MM-dd";
        }
        if("month".equals(type)){
            format="yyyy-MM";
            t=Calendar.MONTH;
        }
        if("week".equals(type)){
            format="yyyy-ww";
            t=Calendar.WEEK_OF_YEAR;
        }
        if(format.length()==0){return null;}
        List<String> dateStr=new ArrayList<>();
        Calendar calendar = Calendar.getInstance();//获取日历
        calendar.setTime(date);//当date的值是当前时间，则可以不用写这段代码。
        dateStr.add(new SimpleDateFormat(format).format(date));
        for(int i=1;i<=num-1;i++){//正序
            calendar.add(t,-1);
            Date d = calendar.getTime();//把日历转换为Date
            dateStr.add(new SimpleDateFormat(format).format(d));
        }
        return dateStr;
    }
}
