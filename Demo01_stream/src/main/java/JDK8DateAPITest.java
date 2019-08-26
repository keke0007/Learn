import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

/**
 * @ Author：ke
 * @ Date： 2019/8/22 21:39
 * @ Version 1.0
 */

public class JDK8DateAPITest {
    /*
    * JDK8新增的时间日期类有
    * LocalDate, LocalTime, LocalDateTime
    * LocalDate,LocalTime,LocalDateTime类的实例
    * 是不可变的对象,分别表示使用ISO-8601日历系统的日期,
    * 时间,日期和时间,他们提供了简单的日期或时间,
    * 并不包含当前的时间信息,也不包含与时区相关的信息
    *
    * */
    @Test
    public void test1() {
        System.out.println("测试日期类LocalDate");
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        System.out.println("----------------");
        LocalDateTime localDateTime = LocalDateTime.of(2019, 8, 22, 22, 00, 00);
        System.out.println(localDateTime);

        LocalDate localDate = now.plusYears(2);
        System.out.println(localDate);
    }

    /*Instant: 时间戳 (使用Unix元年 1970年1月1日 00:00:00 所经历的毫秒数*/
    @Test
    public void test2() {

        Instant ins = Instant.now();
        System.out.println(ins);    //默认使用UTC时区

        /*修补时间偏差*/
        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);
        int nano = ins.getNano();   //获得纳秒值
        System.out.println(nano);
        long ins1 = ins.getEpochSecond();   //获得时间戳精确到秒
        System.out.println(ins.toEpochMilli()); //精确到毫秒
        System.out.println(ins1);
    }

    /**
     * Duration : 用于计算两个 "时间" 间隔
     * Period : 用于计算两个 "日期" 间隔
     */
    @Test
    public void test3() {
        /*比较两个时间之间的间隔*/
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant ins2 = Instant.now();
        Duration between = Duration.between(ins1, ins2);
        System.out.println(between.getSeconds());
        System.out.println("--------------------");
        /*比较两个日期之间的间隔*/
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.of(1992, 5, 13);
        int days = Period.between(ld2, ld1).getYears();
        System.out.println(days);
    }

    /*TemporalAdjuster : 时间校正器*/
    @Test
    public void test4() {
        LocalDateTime ldt = LocalDateTime.now();
        // System.out.println(ldt);
        LocalDateTime ldt2 = ldt.withDayOfMonth(10);    //将月的天数调整为10号
        // System.out.println(ldt2);
        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        // System.out.println(ldt3);
        //自定义 : 根据现在日期时间自定义下一个工作日
        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek();
            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }

    /*DateTimeFormatter : 解析和格式化日期或时间*/
    @Test
    public void test5() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf1);
        System.out.println(strDate);
        LocalDateTime newLdt = ldt.parse(strDate, dtf1);
        // System.out.println(newLdt);
        //测试日期的转换
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
    }

    /*ZoneId : 时区*/
    @Test
    public void test6() {
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }

    /*ZoneDate,ZoneTime,ZoneDateTime : 带时区的时间或日期*/
    @Test
    public void test7() {
        System.out.println("测试日期时间与带时区日期时间的区别");
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);
        System.out.println("-----------------");
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Pacific"));
        System.out.println(zdt);
    }
}
