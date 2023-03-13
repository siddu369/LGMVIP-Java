import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class CurrencyConverter {

    private JFrame frame;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CurrencyConverter window = new CurrencyConverter();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CurrencyConverter() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(135, 206, 235));
        frame.setBounds(100, 100, 1001, 476);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("CURRENCY CONVERTOR");
        lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 28));
        lblNewLabel.setBounds(322, 51, 373, 47);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("FROM");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(86, 159, 84, 34);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("TO");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(86, 273, 84, 34);
        frame.getContentPane().add(lblNewLabel_2);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "SELECT", "INR", "USD", "EURO" }));
        comboBox.setBounds(166, 161, 225, 30);
        frame.getContentPane().add(comboBox);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "SELECT", "INR", "USD", "EURO" }));
        comboBox_1.setBounds(166, 275, 225, 30);
        frame.getContentPane().add(comboBox_1);

        JLabel lblNewLabel_3 = new JLabel("AMOUNT");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(587, 159, 132, 34);
        frame.getContentPane().add(lblNewLabel_3);

        textField = new JTextField();
        textField.setBounds(729, 163, 206, 34);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("CONVERT");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Double convert;
                Double amount = Double.parseDouble(textField.getText());

                if (comboBox.getSelectedItem().toString() == "INR"
                        && comboBox_1.getSelectedItem().toString() == "USD") {
                    convert = amount * 0.012;
                    JOptionPane.showMessageDialog(null, "The amount is: " + convert.toString() + " USD");
                } else if (comboBox.getSelectedItem().toString() == "INR"
                        && comboBox_1.getSelectedItem().toString() == "EURO") {
                    convert = amount * 0.012;
                    JOptionPane.showMessageDialog(null, "The amount is: " + convert.toString() + " EURO");
                } else if (comboBox.getSelectedItem().toString() == "USD"
                        && comboBox_1.getSelectedItem().toString() == "INR") {
                    convert = amount * 82.02;
                    JOptionPane.showMessageDialog(null, "The amount is: " + convert.toString() + " INR");
                } else if (comboBox.getSelectedItem().toString() == "USD"
                        && comboBox_1.getSelectedItem().toString() == "EURO") {
                    convert = amount * 0.93;
                    JOptionPane.showMessageDialog(null, "The amount is: " + convert.toString() + " EURO");
                } else if (comboBox.getSelectedItem().toString() == "EURO"
                        && comboBox_1.getSelectedItem().toString() == "INR") {
                    convert = amount * 88.79;
                    JOptionPane.showMessageDialog(null, "The amount is: " + convert.toString() + " INR");
                } else if (comboBox.getSelectedItem().toString() == "EURO"
                        && comboBox_1.getSelectedItem().toString() == "USD") {
                    convert = amount * 1.07;
                    JOptionPane.showMessageDialog(null, "The amount is: " + convert.toString() + " USD");
                }

            }
        });
        btnNewButton.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD | Font.ITALIC, 18));
        btnNewButton.setBounds(652, 261, 154, 34);
        frame.getContentPane().add(btnNewButton);
    }
}