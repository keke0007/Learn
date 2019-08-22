import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ Author：ke
 * @ Date： 2019/8/22 20:52
 * @ Version 1.0
 */

public class JDK8DateAPI {
    /*
    * JDK8之前的时间API是线程不安全的
    * java.util.data
    *
    * JDK8中提供了新的时间API且是线程安全的
    * java.time
    * java.time.chromo
    * java.time.format
    * java.time.temporal
    * java.time.zone
    * */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");


        Callable<Date> task = () -> DateUtils.convert("20161218");
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }
        for (Future<Date> result : results) {
            System.out.println(result.get());
        }
        pool.shutdown();
    }
}
