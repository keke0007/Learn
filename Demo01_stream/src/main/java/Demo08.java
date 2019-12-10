import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jk
 * @version 1.0.0
 * @create 2019/11/20 9:29
 */
public class Demo08 {
    public static void main(String[] args) {
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
    }
}
