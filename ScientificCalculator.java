import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

class ExpressionCal {
    static Stack<Character> stk = new Stack<>();

    public static boolean isoperator(char x) {
        if (x == '+' || x == '-' || x == 'X' || x == '%' || x == '÷' || x == '^' || x == '√' || x == '!' || x == 'l'
                || x == 'e' || x == 's' || x == 'S' || x == 'c' || x == 'C' || x == 't' || x == 'T') {
            return true;
        }
        return false;
    }

    public static int precedence(char x) {
        if (x == '!') {
            return 4;
        } else if (x == '^' || x == '√' || x == 'x' || x == 'l' || x == 'e') {
            return 3;
        } else if (x == 'X' || x == '÷' || x == 's' || x == 'S' || x == 'c' || x == 'C' || x == 't' || x == 'T') {
            return 2;
        } else if (x == '+' || x == '-') {
            return 1;
        }
        return 0;
    }

    public static String infixtopostfix(String x) {
        String s1 = "";
        int i = 0;
        int prev_op = -1;
        while (i < x.length()) {
            char c = x.charAt(i);
            if (c == '(') {
                stk.push('(');
                i++;
            } else if (c == 'l') {
                String sub = x.substring(i, i + 2);
                if (sub.equals("ln")) {
                    stk.push('e');
                    i += 2;
                } else if (sub.equals("lo")) {
                    stk.push('l');
                    i += 3;
                }
            } else if (c == 's' || c == 'c' || c == 't') {
                String sub = x.substring(i, i + 4);
                if (sub.equals("sin-")) {
                    stk.push('S');
                    i += 6;
                } else if (sub.equals("sin ")) {
                    stk.push('s');
                    i += 4;
                } else if (sub.equals("cos-")) {
                    stk.push('C');
                    i += 6;
                } else if (sub.equals("cos ")) {
                    stk.push('c');
                    i += 4;
                } else if (sub.equals("tan-")) {
                    stk.push('T');
                    i += 6;
                } else {
                    stk.push('t');
                    i += 4;
                }
            } else if (c == 'e') {
                if (x.charAt(i + 1) == '^')
                    stk.push('x');
                i += 2;
            } else if (isoperator(c)) {
                if (c == '-' && (i - 1 == -1 || isoperator(x.charAt(i - 1)) || (x.charAt(i - 1) == ' '))) {
                    s1 += "#-";
                    i++;
                    c = x.charAt(i);
                    while ((c >= '0' && c <= '9') || c == '.') {
                        s1 += c;
                        i += 1;
                        if (i == x.length())
                            break;
                        c = x.charAt(i);
                    }
                    s1 += "#";
                } else if (stk.isEmpty()) {
                    stk.push(c);
                    i++;
                } else {
                    while (precedence(c) <= precedence(stk.peek())) {
                        s1 = s1 + stk.pop();
                        if (stk.isEmpty())
                            break;
                    }
                    stk.push(c);
                    i++;
                }

            } else if (c >= '0' && c <= '9') {
                s1 += '#';
                while ((c >= '0' && c <= '9') || c == '.') {
                    s1 += c;
                    i += 1;
                    if (i == x.length())
                        break;
                    c = x.charAt(i);
                }
                s1 += "#";
                System.out.println(s1 + "--");
            } else if (c == ')') {
                while (stk.peek() != '(') {
                    s1 += stk.pop();
                }
                stk.pop();
                i++;
            } else {
                i++;
            }
        }
        while (!stk.isEmpty())
            s1 += stk.pop();
        System.out.println(s1);
        return s1;
    }

    public static double postfixeval(String x) {
        double val = (double) 0;
        Stack<Double> st1 = new Stack<>();
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (c == '#') {
                String temp = "";
                i += 1;
                c = x.charAt(i);
                while (c != '#') {
                    temp += c;
                    i += 1;
                    c = x.charAt(i);
                }
                st1.push(Double.parseDouble(temp));
                System.out.println(st1);
            } else if (c == '%') {
                double a = st1.pop();
                val = a / 100;
                st1.push(val);
            } else if (c == 'l') {
                double a = st1.pop();
                val = Math.log10(a);
                st1.push(val);
            } else if (c == 'e') {
                double a = st1.pop();
                val = Math.log(a);
                st1.push(val);
            } else if (c == '√') {
                double a = st1.pop();
                val = Math.sqrt(a);
                st1.push(val);
            } else if (c == 'x') {
                double a = st1.pop();
                val = Math.exp(a);
                st1.push(val);
            } else if (c == 't' || c == 's' || c == 'c') {
                double a = st1.pop();
                double r = Math.toRadians(a);
                if (c == 's')
                    val = Math.sin(r);
                else if (c == 'c')
                    val = Math.cos(r);
                else
                    val = Math.tan(r);
                st1.push(val);
            } else if (c == 'T' || c == 'S' || c == 'C') {
                double a = st1.pop();
                if (c == 'S')
                    val = Math.asin(a);
                else if (c == 'C')
                    val = Math.acos(a);
                else
                    val = Math.atan(a);
                val = Math.toDegrees(val);
                st1.push(val);
            } else if (c == '!') {
                double a = st1.pop();
                long a1 = (long) a;
                long j = 1;
                long sum = 1;
                long k = 1;
                if (a1 == a) {
                    if (a1 < 0) {
                        a1 = (-1) * a1;
                        k = -1;
                    }
                    for (j = a1; j >= 1; j--) {
                        sum *= j;
                    }
                } else
                    throw new EmptyStackException();
                st1.push((double) k * sum);
            } else {
                double b = st1.pop();
                double a = st1.pop();
                if (c == '^')
                    val = (double) Math.pow(a, b);
                else if (c == 'X')
                    val = a * b;
                else if (c == '÷')
                    val = a / b;
                else if (c == '-')
                    val = (a - b);
                else if (c == '+')
                    val = (a + b);
                st1.push(val);
                System.out.println(val);
            }
        }
        System.out.println(st1);
        return st1.pop();
    }

    public static double answer(String x) {
        x = infixtopostfix(x);
        return postfixeval(x);
    }
}

public class ScientificCalculator extends JFrame implements ActionListener {

    JButton[] b, b1;
    String[] nums = { "sin ", "cos ", "tan ", "!", "sin-1 ", "cos-1 ", "tan-1 ", "log ", "ln ", "e^", "(", ")", "^",
            "√", "^2", "7", "8", "9", "Del", "AC", "4", "5", "6", "X", "÷", "1", "2", "3", "+", "-", "0", ".", "%",
            "Ans", "=" };
    JTextArea tx;
    String ex = "";
    String ans = "0";
    JPanel top, bottom;
    GridBagConstraints gbc;
    GridBagLayout g;

    ScientificCalculator() {

        g = new GridBagLayout();
        setLayout(g);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gbc = new GridBagConstraints();
        tx = new JTextArea(1, 2);
        tx.setEditable(false);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        g.setConstraints(tx, gbc);
        add(tx);

        int j = 0, k = 1;
        b = new JButton[35];
        gbc.gridwidth = 1;

        int x = 0;
        int y = 1;
        for (int i = 0; i < 35; i++) {
            gbc.gridx = x;
            gbc.gridy = y;
            b[i] = new JButton(nums[i]);
            g.setConstraints(b[i], gbc);
            b[i].addActionListener(this);
            add(b[i]);
            x++;
            if (x == 5) {
                x = 0;
                y++;
            }
        }

    }

    public static void main(String[] args) {
        ScientificCalculator s = new ScientificCalculator();
        s.setVisible(true);
        s.setSize(500, 600);
        s.setTitle("Scientific Calculator");
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e) {
        String op = e.getActionCommand();
        String ex1 = "";
        if (op.equals("=")) {
            ex1 = ex;
            ex = ExpressionCal.answer(ex) + "";
            ans = ex;
            tx.setText(ex1 + "\n" + ex);
        } else if (op.equals("Ans")) {
            ex += ans;
            tx.setText(ex);
        } else if (op.equals("Del")) {
            if (!ex.equals("")) {
                ex = ex.substring(0, ex.length() - 1);
                tx.setText(ex);
            }
        } else if (op.equals("AC")) {
            tx.setText("0");
            ex = "";
        } else {
            ex = ex + op;
            tx.setText(ex);
        }
    }
}