import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author jk
 * @version 1.0.0
 * @create 2019/11/20 9:36
 */
public class CmdExecuter {

    public static void exec(List<String> cmd, CmdOutputGetter getter) {

        if (/*log.isInfoEnabled()*/true) {
            // log.info("exec command: ");
            StringBuilder sb = new StringBuilder();//StringBuilder是字符串生成器，上面这部分和cmd操作没关系
            for (String c : cmd) {
                sb.append(c).append(" ");
            }
            // log.info(sb.toString());
        }

        //cmd操作部分
        try {
            ProcessBuilder builder = new ProcessBuilder();//创建新线程
            builder.command(cmd);//执行FFmpeg命令
            builder.redirectErrorStream(true);
            Process proc = builder.start();
            BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = stdout.readLine()) != null) {
                if (getter != null)
                    getter.dealLine(line);
            }
            proc.waitFor();
            stdout.close();
        } catch (Exception e) {
            // log.error(e.getMessage(), e);
        }
    }
}
