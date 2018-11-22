package cn.f_ms.study.think_in_java_4;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

class c22self1 {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("title");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.add(new JLabel("I'm a lable"));
                frame.setVisible(true);
            }
        });
    }
}
