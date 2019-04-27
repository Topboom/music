import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MyKeyHandle extends JFrame implements KeyListener {
    private JTextArea text = new JTextArea();

    public MyKeyHandle() {
        super.setTitle("Crystal");
        JScrollPane pane = new JScrollPane(text);// 加入滚动条
        pane.setBounds(5, 5, 300, 200);
        super.add(pane);// 像窗体加入组件
        text.addKeyListener(this);// 加入key监听
        super.setSize(310, 210);// 设置窗体
        super.setVisible(true);// 显示窗体
        super.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                System.exit(1);// 系统退出
            }
        });

    }

    public void keyPressed(KeyEvent e) {
        text.append("键盘" + KeyEvent.getKeyText(e.getKeyCode()) + "键向下\n");
        try {
            Threa1();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void keyReleased(KeyEvent e) {
        text.append("键盘" + KeyEvent.getKeyText(e.getKeyCode()) + "键松开\n");
    }

    public void keyTyped(KeyEvent e) {
        text.append("输入的内容是" + e.getKeyChar() + "\n");
    }
    public void Threa1() throws Exception{
        InputStream in = new FileInputStream("src/a1.wav");
        // 创建音频流对象
        final AudioStream audioStream = new AudioStream(in);

// 使用音频播放器播放声音
                AudioPlayer.player.start(audioStream);


        Thread.sleep(2000);
// 停止声音播放
        AudioPlayer.player.stop(audioStream);
    }
}

public class music {
    public static void main(String[] args)  {
        new MyKeyHandle();


    }

}





