import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
    private JTextField textField;
    private JPanel mainPanel;
    private JButton cButton;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton button7;
    private JButton button8;
    private JButton a6Button;
    private JButton a5Button;
    private JButton a4Button;
    private JButton button12;
    private JButton a3Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton button16;
    private JButton a0Button;
    private JButton button19;

    private Calculator calculator;

    public GUI() {
        setTitle("Calculator");
        setContentPane(mainPanel);
        setSize(400, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel.setFocusable(true);
        mainPanel.addKeyListener(keyPressListener);

        cButton.addActionListener(buttonPressListener);
        button2.addActionListener(buttonPressListener);
        button3.addActionListener(buttonPressListener);
        button4.addActionListener(buttonPressListener);
        a7Button.addActionListener(buttonPressListener);
        a8Button.addActionListener(buttonPressListener);
        a9Button.addActionListener(buttonPressListener);
        button7.addActionListener(buttonPressListener);
        button8.addActionListener(buttonPressListener);
        a6Button.addActionListener(buttonPressListener);
        a5Button.addActionListener(buttonPressListener);
        a4Button.addActionListener(buttonPressListener);
        button12.addActionListener(buttonPressListener);
        a3Button.addActionListener(buttonPressListener);
        a1Button.addActionListener(buttonPressListener);
        a2Button.addActionListener(buttonPressListener);
        button16.addActionListener(buttonPressListener);
        a0Button.addActionListener(buttonPressListener);
        button19.addActionListener(buttonPressListener);

        calculator = new Calculator();
        textField.setText(calculator.getDisplayedNum());
    }

    private KeyAdapter keyPressListener = new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);

            char key = e.getKeyChar();
            switch(key) {
                case 27:
                case 'c': cButton.doClick(); break;
                case 8: button2.doClick(); break;
                case '/': button4.doClick(); break;
                case '*': button7.doClick(); break;
                case '-': button8.doClick(); break;
                case '+': button12.doClick(); break;
                case '.': button19.doClick(); break;
                case '=': button16.doClick(); break;
                case '1': a1Button.doClick(); break;
                case '2': a2Button.doClick(); break;
                case '3': a3Button.doClick(); break;
                case '4': a4Button.doClick(); break;
                case '5': a5Button.doClick(); break;
                case '6': a6Button.doClick(); break;
                case '7': a7Button.doClick(); break;
                case '8': a8Button.doClick(); break;
                case '9': a9Button.doClick(); break;
                case '0': a0Button.doClick(); break;
            }
        }
    };

    private ActionListener buttonPressListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            calculator.handleClickButton(button);
            textField.setText(calculator.getDisplayedNum());
        }
    };
}
