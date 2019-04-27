import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;

public class yingping {

    public static void main(String[] args) throws Exception {
// 创建音乐文件输入流对象
        InputStream in = new FileInputStream("src/a1.wav");
// 创建音频流对象
        final AudioStream audioStream = new AudioStream(in);
        new Thread(new Runnable() {
            @Override
            public void run() {
// 使用音频播放器播放声音
                AudioPlayer.player.start(audioStream);
            }
        }).start();

        Thread.sleep(10000);
// 停止声音播放
        AudioPlayer.player.stop(audioStream);
    }
}