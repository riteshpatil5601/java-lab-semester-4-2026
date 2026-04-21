import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StandardCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[9];
    private JButton addBtn, subBtn, mulBtn, divBtn;
    private JButton decBtn, equBtn, clrBtn, sqrBtn, sqrtBtn;
    private JPanel panel;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public StandardCalculator() {
        this.setTitle("Standard Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 550);
        this.setLayout(null);

        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setEditable(false);

        // Define Function Buttons
        addBtn = new JButton("+"); subBtn = new JButton("-");
        mulBtn = new JButton("*"); divBtn = new JButton("/");
        decBtn = new JButton("."); equBtn = new JButton("=");
        clrBtn = new JButton("C"); sqrBtn = new JButton("x²");
        sqrtBtn = new JButton("√");

        functionButtons[0] = addBtn; functionButtons[1] = subBtn;
        functionButtons[2] = mulBtn; functionButtons[3] = divBtn;
        functionButtons[4] = decBtn; functionButtons[5] = equBtn;
        functionButtons[6] = clrBtn; functionButtons[7] = sqrBtn;
        functionButtons[8] = sqrtBtn;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        // Layout Panel
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        panel.add(numberButtons[1]); panel.add(numberButtons[2]); panel.add(numberButtons[3]); panel.add(addBtn);
        panel.add(numberButtons[4]); panel.add(numberButtons[5]); panel.add(numberButtons[6]); panel.add(subBtn);
        panel.add(numberButtons[7]); panel.add(numberButtons[8]); panel.add(numberButtons[9]); panel.add(mulBtn);
        panel.add(decBtn); panel.add(numberButtons[0]); panel.add(equBtn); panel.add(divBtn);
        panel.add(sqrBtn); panel.add(sqrtBtn); panel.add(clrBtn);

        this.add(panel);
        this.add(display);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decBtn) display.setText(display.getText().concat("."));
        if (e.getSource() == clrBtn) display.setText("");
        
        if (e.getSource() == addBtn || e.getSource() == subBtn || 
            e.getSource() == mulBtn || e.getSource() == divBtn) {
            num1 = Double.parseDouble(display.getText());
            operator = e.getActionCommand().charAt(0);
            display.setText("");
        }

        if (e.getSource() == sqrBtn) {
            num1 = Double.parseDouble(display.getText());
            display.setText(String.valueOf(num1 * num1));
        }

        if (e.getSource() == sqrtBtn) {
            num1 = Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.sqrt(num1)));
        }

        if (e.getSource() == equBtn) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        }
    }

    public static void main(String[] args) {
        new StandardCalculator();
    }
}
