package timer.main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Местное время");
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(450, 450);
        window.setResizable(false);
    }
}
