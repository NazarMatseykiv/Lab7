import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog4 extends JFrame {
    JTextField fld = new JTextField(20);
    JButton btn = new JButton("Натиснути");
    JLabel inputLbl = new JLabel("Введіть текст:");
    JLabel outputLbl = new JLabel(" ");

    Dialog4() {
        super("Слухачі (listeners) полів та кнопок");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
        }
        setSize(400, 150);
        Container c = getContentPane();

        // створення панелі для вводу тексту
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(inputLbl);
        inputPanel.add(fld);

        // створення панелі для виводу результату
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new FlowLayout());
        outputPanel.add(outputLbl);

        // додавання панелей до контейнеру
        c.add(inputPanel, BorderLayout.CENTER);
        c.add(btn, BorderLayout.SOUTH);
        c.add(outputPanel, BorderLayout.NORTH);

        fld.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputLbl.setText("Введений текст: " + fld.getText());
            }
        });

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputLbl.setText("Натиснута кнопка");
            }
        });

        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        addWindowListener(wndCloser);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dialog4();
    }
}
