import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StationarySystem extends JFrame {
    private JCheckBox chkNotebook, chkPen, chkPencil;
    private JButton btnOrder;

    public StationarySystem() {
        // Frame Setup
        setTitle("Stationary Purchase System");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Components
        chkNotebook = new JCheckBox("Notebook @ 50");
        chkPen = new JCheckBox("Pen @ 30");
        chkPencil = new JCheckBox("Pencil @ 10");
        btnOrder = new JButton("Order");

        // Add to Frame
        add(chkNotebook);
        add(chkPen);
        add(chkPencil);
        add(btnOrder);

        // Event Handling
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processOrder();
            }
        });

        setVisible(true);
    }

    private void processOrder() {
        double total = 0;
        String message = "";

        if (chkNotebook.isSelected()) {
            String qtyStr = JOptionPane.showInputDialog(this, "Enter Quantity for Notebook", "Input", JOptionPane.QUESTION_MESSAGE);
            if (qtyStr != null && !qtyStr.isEmpty()) {
                int qty = Integer.parseInt(qtyStr);
                double subtotal = qty * 50;
                total += subtotal;
                message += "Notebook Quantity: " + qty + " Total: " + subtotal + "\n";
            }
        }
        
        // Note: Similar logic can be repeated for Pen and Pencil as needed based on manual UI

        if (total > 0) {
            message += "Total: " + total;
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(this, "Successfully Ordered.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new StationarySystem();
    }
}
