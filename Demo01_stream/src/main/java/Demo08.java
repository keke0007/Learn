import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author jk
 * @version 1.0.0
 * @create 2019/11/20 9:29
 */
public class Demo08 {
    public static void main(String[] args) throws IOException {
       /* //调用cmd操作类
        List<String> commend = new ArrayList<>();
        commend.add("ffmpeg -i \"rtsp://admin:12345@192.168.200.22:554/h264/ch1/main/av_stream\" -f flv -r 25 -s 640x480 -ar 44100 \"rtmp://192.168.200.238/oflaDemo/hello10\"");
        CmdExecuter.exec(commend, new CmdOutputGetter() {
            @Override
            public void dealLine(String line) {
                System.out.println(line);//把cmd输出的信息每行syso，这个是实时输出的，可以换其他的处理方式
            }
        });

        System.out.println("AMD,YES!");//可以换成其他提示转换完成的方法*/

        // String a = "A01A01";
        // String b = "A01A02";
        // System.out.println(b.indexOf(a));

        // Runtime cmd = Runtime.getRuntime();
        // Process dir = cmd.exec("cmd /c start dir");

        // List<String> cmd = new ArrayList<>();
        // cmd.add("cmd /c start dir");
        // Process start = new ProcessBuilder(Arrays.asList("cmd","/k","start","dir")).start();
        // String cmd = "cmd /c start dir";
        String cmd = "cmd /c dir";
        System.out.println(execCommand(cmd));
    }

    //将cmd执行内容打印到控制台上
    public static String execCommand(String command) {
        String line = "";
        StringBuilder sb = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        Runtime.getRuntime().exec(command).getInputStream()));) {
            while ((line = bufferedReader.readLine()) != null)
                sb.append(line + "\r\n");
        } catch (IOException e) {
            return "Invalid command.";
        }

        return sb.toString();
    }

//    https://blog.csdn.net/as6757uyy65uy75/article/details/80786593
//     https://www.jianshu.com/p/43ce90abb5cd
//     https://www.cnblogs.com/jeryM/p/8459709.html
}
