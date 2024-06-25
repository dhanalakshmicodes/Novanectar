import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PercentageCalculatorGUI extends JFrame implements ActionListener {
    private JTextField valueField1, valueField2, resultField;
    private JComboBox<String> calculationType;

    public PercentageCalculatorGUI() {
        setTitle("Percentage Calculator");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel label1 = new JLabel("Value 1:");
        JLabel label2 = new JLabel("Value 2:");
        JLabel label3 = new JLabel("Result:");
        valueField1 = new JTextField(10);
        valueField2 = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        calculationType = new JComboBox<>(new String[] {"Calculate Percentage", "Percentage Increase/Decrease", "Find Whole Given Part and Percentage"});
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        mainPanel.add(label1);
        mainPanel.add(valueField1);
        mainPanel.add(label2);
        mainPanel.add(valueField2);
        mainPanel.add(label3);
        mainPanel.add(resultField);
        mainPanel.add(calculationType);
        mainPanel.add(calculateButton);

        add(mainPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calculate")) {
            calculate();
        }
    }

    private void calculate() {
        try {
            double val1 = Double.parseDouble(valueField1.getText());
            double val2 = Double.parseDouble(valueField2.getText());
            String type = (String) calculationType.getSelectedItem();
            double result = 0;

            if (type.equals("Calculate Percentage")) {
                result = (val1 / 100) * val2;
            } else if (type.equals("Percentage Increase/Decrease")) {
                result = ((val2 - val1) / val1) * 100;
            } else if (type.equals("Find Whole Given Part and Percentage")) {
                result = (val1 * 100) / val2;
            }

            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PercentageCalculatorGUI();
            }
        });
    }
}
