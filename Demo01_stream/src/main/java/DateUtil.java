import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author：ke
 * @ Date： 2019/8/22 21:19
 * @ Version 1.0
 */

public class DateUtil {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static Date convert(String source) {
        try {
            return df.get().parse(source);
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return null;
    }

}
