import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
}
