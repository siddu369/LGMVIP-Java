import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe {

    private JFrame fromTictactoe;
    private JTextField countofx;
    private JTextField countofo;
    private int CountOfX = 0;
    private int CountOfO = 0;
    private String StartGame = "X";
    private int b1 = 20;
    private int b2 = 20;
    private int b3 = 20;
    private int b4 = 20;
    private int b5 = 20;
    private int b6 = 20;
    private int b7 = 20;
    private int b8 = 20;
    private int b9 = 20;
    private int i = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TicTacToe window = new TicTacToe();
                    window.fromTictactoe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TicTacToe() {
        initialize();
    }

    private void winner() {
        if (b1 == 1 && b2 == 1 && b3 == 1) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is X", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfX++;
            countofx.setText(String.valueOf(CountOfX));
        } else if (b4 == 1 && b5 == 1 && b6 == 1) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is X", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfX++;
            countofx.setText(String.valueOf(CountOfX));
        } else if (b7 == 1 && b8 == 1 && b9 == 1) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is X", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfX++;
            countofx.setText(String.valueOf(CountOfX));
        } else if (b1 == 1 && b4 == 1 && b7 == 1) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is X", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfX++;
            countofx.setText(String.valueOf(CountOfX));
        } else if (b2 == 1 && b5 == 1 && b8 == 1) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is X", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfX++;
            countofx.setText(String.valueOf(CountOfX));
        } else if (b3 == 1 && b6 == 1 && b9 == 1) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is X", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfX++;
            countofx.setText(String.valueOf(CountOfX));
        } else if (b1 == 1 && b5 == 1 && b9 == 1) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is X", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfX++;
            countofx.setText(String.valueOf(CountOfX));
        } else if (b3 == 1 && b5 == 1 && b7 == 1) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is X", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfX++;
            countofx.setText(String.valueOf(CountOfX));
        }

        else if (b1 == 0 && b2 == 0 && b3 == 0) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is O", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfO++;
            countofo.setText(String.valueOf(CountOfO));
        } else if (b4 == 0 && b5 == 0 && b6 == 0) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is O", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfO++;
            countofo.setText(String.valueOf(CountOfO));
        } else if (b7 == 0 && b8 == 0 && b9 == 0) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is O", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfO++;
            countofo.setText(String.valueOf(CountOfO));
        } else if (b1 == 0 && b4 == 0 && b7 == 0) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is O", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfO++;
            countofo.setText(String.valueOf(CountOfO));
        } else if (b2 == 0 && b5 == 0 && b8 == 0) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is O", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfO++;
            countofo.setText(String.valueOf(CountOfO));
        } else if (b3 == 0 && b6 == 0 && b9 == 0) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is O", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfO++;
            countofo.setText(String.valueOf(CountOfO));
        } else if (b1 == 0 && b5 == 0 && b9 == 0) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is O", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfO++;
            countofo.setText(String.valueOf(CountOfO));
        } else if (b3 == 0 && b5 == 0 && b7 == 0) {
            JOptionPane.showMessageDialog(fromTictactoe, "Congratulations..  The winner is O", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);
            CountOfO++;
            countofo.setText(String.valueOf(CountOfO));
        }

        else if (i == 9) {
            JOptionPane.showMessageDialog(fromTictactoe, "No one wins!! ):", "Tic Tac Toe",
                    JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private void Player() {
        if (StartGame.equalsIgnoreCase("X")) {
            StartGame = "O";
        } else {
            StartGame = "X";
        }
    }

    private void initialize() {
        fromTictactoe = new JFrame();
        fromTictactoe.setFont(new Font("Arial", Font.BOLD, 18));
        fromTictactoe.setTitle("TicTacToe");
        fromTictactoe.setBounds(100, 100, 753, 473);
        fromTictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fromTictactoe.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        fromTictactoe.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 5, 2, 2));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        JButton bt1 = new JButton("");
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bt1.setText(StartGame);
                if (StartGame.equalsIgnoreCase("X")) {
                    bt1.setBackground(Color.RED);
                    bt1.setForeground(Color.WHITE);
                    b1 = 1;
                    i++;
                } else {
                    bt1.setBackground(Color.BLUE);
                    bt1.setForeground(Color.WHITE);
                    b1 = 0;
                    i++;
                }
                Player();
                winner();
            }
        });
        bt1.setForeground(new Color(0, 128, 192));
        bt1.setFont(new Font("Arial Black", Font.BOLD, 60));
        panel_1.add(bt1, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        JButton bt2 = new JButton("");
        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bt2.setText(StartGame);
                if (StartGame.equalsIgnoreCase("X")) {
                    bt2.setBackground(Color.RED);
                    bt2.setForeground(Color.WHITE);
                    b2 = 1;
                    i++;
                } else {
                    bt2.setBackground(Color.BLUE);
                    bt2.setForeground(Color.WHITE);
                    b2 = 0;
                    i++;
                }
                Player();
                winner();
            }
        });
        bt2.setForeground(new Color(0, 128, 192));
        bt2.setFont(new Font("Arial Black", Font.BOLD, 60));
        panel_2.add(bt2, BorderLayout.CENTER);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));

        JButton bt3 = new JButton("");
        bt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bt3.setText(StartGame);
                if (StartGame.equalsIgnoreCase("X")) {
                    bt3.setBackground(Color.RED);
                    bt3.setForeground(Color.WHITE);
                    b3 = 1;
                    i++;
                } else {
                    bt3.setBackground(Color.BLUE);
                    bt3.setForeground(Color.WHITE);
                    b3 = 0;
                    i++;
                }
                Player();
                winner();
            }
        });
        bt3.setForeground(new Color(0, 128, 192));
        bt3.setFont(new Font("Arial Black", Font.BOLD, 60));
        panel_3.add(bt3, BorderLayout.CENTER);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_4);
        panel_4.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("       X");
        lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
        panel_4.add(lblNewLabel, BorderLayout.CENTER);

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_5);
        panel_5.setLayout(new BorderLayout(0, 0));

        countofx = new JTextField();
        countofx.setHorizontalAlignment(SwingConstants.CENTER);
        countofx.setFont(new Font("Arial Black", Font.BOLD, 30));
        countofx.setText("0");
        panel_5.add(countofx, BorderLayout.CENTER);
        countofx.setColumns(10);

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_6);
        panel_6.setLayout(new BorderLayout(0, 0));

        JButton bt4 = new JButton("");
        bt4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bt4.setText(StartGame);
                if (StartGame.equalsIgnoreCase("X")) {
                    bt4.setBackground(Color.RED);
                    bt4.setForeground(Color.WHITE);
                    b4 = 1;
                    i++;
                } else {
                    bt4.setBackground(Color.BLUE);
                    bt4.setForeground(Color.WHITE);
                    b4 = 0;
                    i++;
                }
                Player();
                winner();
            }
        });
        bt4.setFont(new Font("Arial Black", Font.BOLD, 60));
        panel_6.add(bt4, BorderLayout.CENTER);

        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_7);
        panel_7.setLayout(new BorderLayout(0, 0));

        JButton bt5 = new JButton("");
        bt5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bt5.setText(StartGame);
                if (StartGame.equalsIgnoreCase("X")) {
                    bt5.setBackground(Color.RED);
                    bt5.setForeground(Color.WHITE);
                    b5 = 1;
                    i++;
                } else {
                    bt5.setBackground(Color.BLUE);
                    bt5.setForeground(Color.WHITE);
                    b5 = 0;
                    i++;
                }
                Player();
                winner();
            }
        });
        bt5.setFont(new Font("Arial Black", Font.BOLD, 60));
        panel_7.add(bt5, BorderLayout.CENTER);

        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_8);
        panel_8.setLayout(new BorderLayout(0, 0));

        JButton bt6 = new JButton("");
        bt6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bt6.setText(StartGame);
                if (StartGame.equalsIgnoreCase("X")) {
                    bt6.setBackground(Color.RED);
                    bt6.setForeground(Color.WHITE);
                    b6 = 1;
                    i++;
                } else {
                    bt6.setBackground(Color.BLUE);
                    bt6.setForeground(Color.WHITE);
                    b6 = 0;
                    i++;
                }
                Player();
                winner();
            }
        });
        bt6.setForeground(new Color(0, 128, 192));
        bt6.setFont(new Font("Arial Black", Font.BOLD, 60));
        panel_8.add(bt6, BorderLayout.CENTER);

        JPanel panel_9 = new JPanel();
        panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_9);
        panel_9.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_1 = new JLabel("       O");
        lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 25));
        panel_9.add(lblNewLabel_1, BorderLayout.CENTER);

        JPanel panel_10 = new JPanel();
        panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_10);
        panel_10.setLayout(new BorderLayout(0, 0));

        countofo = new JTextField();
        countofo.setHorizontalAlignment(SwingConstants.CENTER);
        countofo.setFont(new Font("Arial Black", Font.BOLD, 30));
        countofo.setText("0");
        panel_10.add(countofo, BorderLayout.CENTER);
        countofo.setColumns(10);

        JPanel panel_11 = new JPanel();
        panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_11);
        panel_11.setLayout(new BorderLayout(0, 0));

        JButton bt7 = new JButton("");
        bt7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bt7.setText(StartGame);
                if (StartGame.equalsIgnoreCase("X")) {
                    bt7.setBackground(Color.RED);
                    bt7.setForeground(Color.WHITE);
                    b7 = 1;
                    i++;
                } else {
                    bt7.setBackground(Color.BLUE);
                    bt7.setForeground(Color.WHITE);
                    b7 = 0;
                    i++;
                }
                Player();
                winner();
            }
        });
        bt7.setFont(new Font("Arial Black", Font.BOLD, 60));
        panel_11.add(bt7, BorderLayout.CENTER);

        JPanel panel_12 = new JPanel();
        panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_12);
        panel_12.setLayout(new BorderLayout(0, 0));

        JButton bt8 = new JButton("");
        bt8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bt8.setText(StartGame);
                if (StartGame.equalsIgnoreCase("X")) {
                    bt8.setBackground(Color.RED);
                    bt8.setForeground(Color.WHITE);
                    b8 = 1;
                    i++;
                } else {
                    bt8.setBackground(Color.BLUE);
                    bt8.setForeground(Color.WHITE);
                    b8 = 0;
                    i++;
                }
                Player();
                winner();
            }
        });
        bt8.setFont(new Font("Arial Black", Font.BOLD, 60));
        panel_12.add(bt8, BorderLayout.CENTER);

        JPanel panel_13 = new JPanel();
        panel_13.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_13);
        panel_13.setLayout(new BorderLayout(0, 0));

        JButton bt9 = new JButton("");
        bt9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bt9.setText(StartGame);
                if (StartGame.equalsIgnoreCase("X")) {
                    bt9.setBackground(Color.RED);
                    bt9.setForeground(Color.WHITE);
                    b9 = 1;
                    i++;
                } else {
                    bt9.setBackground(Color.BLUE);
                    bt9.setForeground(Color.WHITE);
                    b9 = 0;
                    i++;
                }
                Player();
                winner();
            }
        });
        bt9.setFont(new Font("Arial Black", Font.BOLD, 60));
        panel_13.add(bt9, BorderLayout.CENTER);

        JPanel panel_14 = new JPanel();
        panel_14.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_14);
        panel_14.setLayout(new BorderLayout(0, 0));

        JButton resetbtn = new JButton("RESET");
        resetbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bt1.setBackground(null);
                bt2.setBackground(null);
                bt3.setBackground(null);
                bt4.setBackground(null);
                bt5.setBackground(null);
                bt6.setBackground(null);
                bt7.setBackground(null);
                bt8.setBackground(null);
                bt9.setBackground(null);

                bt1.setText(null);
                bt2.setText(null);
                bt3.setText(null);
                bt4.setText(null);
                bt5.setText(null);
                bt6.setText(null);
                bt7.setText(null);
                bt8.setText(null);
                bt9.setText(null);

                b1 = 20;
                b2 = 20;
                b3 = 20;
                b4 = 20;
                b5 = 20;
                b6 = 20;
                b7 = 20;
                b8 = 20;
                b9 = 20;
                i = 0;

            }
        });
        resetbtn.setFont(new Font("Arial", Font.BOLD, 23));
        panel_14.add(resetbtn, BorderLayout.CENTER);

        JPanel panel_15 = new JPanel();
        panel_15.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_15);
        panel_15.setLayout(new BorderLayout(0, 0));

        JButton exitbt = new JButton("EXIT");
        exitbt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fromTictactoe = new JFrame("Exit");
                if (JOptionPane.showConfirmDialog(fromTictactoe, "Do you want to exit?", "Tic Tac Toe",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }
            }
        });
        exitbt.setFont(new Font("Arial", Font.BOLD, 23));
        panel_15.add(exitbt, BorderLayout.CENTER);
    }

}