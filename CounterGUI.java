import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CounterGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Counter");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Counter:");
        JTextField textField = new JTextField("0", 10);

        JButton up = new JButton("Count Up");
        JButton down = new JButton("Count Down");
        JButton reset = new JButton("Reset");

        // Count Up
        up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(textField.getText());
                textField.setText(String.valueOf(value + 1));
            }
        });

        // Count Down
        down.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(textField.getText());
                textField.setText(String.valueOf(value - 1));
            }
        });

        // Reset
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("0");
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(up);
        frame.add(down);
        frame.add(reset);

        frame.setVisible(true);
    }
}
