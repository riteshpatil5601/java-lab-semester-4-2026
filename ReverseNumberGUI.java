import javax.swing.*;
import java.awt.event.*;

public class ReverseNumberGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Reverse Number");
        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Enter Number:");
        label.setBounds(20, 20, 120, 30);

        JTextField input = new JTextField();
        input.setBounds(140, 20, 120, 30);

        JButton button = new JButton("Reverse");
        button.setBounds(90, 70, 100, 30);

        JLabel result = new JLabel("Result:");
        result.setBounds(20, 120, 200, 30);

        // Button Action
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num = input.getText();
                String rev = new StringBuilder(num).reverse().toString();
                result.setText("Result: " + rev);
            }
        });

        frame.add(label);
        frame.add(input);
        frame.add(button);
        frame.add(result);

        frame.setVisible(true);
    }
}
