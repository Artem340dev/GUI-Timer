package timer.main;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class Window extends JFrame {
    public JLabel label;

    public Window(String name) {
        super(name);
        setLayout(new FlowLayout());
        LocalTime time = LocalTime.now();
        String hour = time.getHour() < 10 ? "0" + time.getHour() : String.valueOf(time.getHour());
        String minute = time.getMinute() < 10 ? "0" + time.getMinute() : String.valueOf(time.getMinute());
        String second = time.getSecond() < 10 ? "0" + time.getSecond() : String.valueOf(time.getSecond());
        label = new JLabel("Время: " + hour + ":" + minute + ":" + second);
        add(label);
        Thread thread = new Thread(new Scheduler());
        thread.start();
    }

    class Scheduler implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LocalTime time = LocalTime.now();
                String hour = time.getHour() < 10 ? "0" + time.getHour() : String.valueOf(time.getHour());
                String minute = time.getMinute() < 10 ? "0" + time.getMinute() : String.valueOf(time.getMinute());
                String second = time.getSecond() < 10 ? "0" + time.getSecond() : String.valueOf(time.getSecond());
                label.setText("Время: " + hour + ":" + minute + ":" + second);
            }
        }
    }
}