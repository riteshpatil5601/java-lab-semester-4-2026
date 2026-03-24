import javax.swing.*;
import java.awt.event.*;

public class RadioButtonDemo {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Gender Selection");
        frame.setSize(300, 200);
        frame.setLayout(null);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(50, 30, 100, 30);

        JRadioButton female = new JRadioButton("Female");
        female.setBounds(50, 60, 100, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        JButton submit = new JButton("Submit");
        submit.setBounds(80, 100, 100, 30);

        JLabel result = new JLabel();
        result.setBounds(50, 140, 200, 30);

        submit.addActionListener(e -> {
            if (male.isSelected()) {
                result.setText("Selected: Male");
            } else if (female.isSelected()) {
                result.setText("Selected: Female");
            } else {
                result.setText("Select an option");
            }
        });

        frame.add(male);
        frame.add(female);
        frame.add(submit);
        frame.add(result);

        frame.setVisible(true);
    }
}
