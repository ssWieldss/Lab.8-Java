import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame {
    private JTextField textField1 = new JTextField();
    private JTextField textField2 = new JTextField();
    private JTextField textField3 = new JTextField();
    private JButton sendButton = new JButton("Оправить");
    private JProgressBar progressBar = new JProgressBar();

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField) {
        this.textField1 = textField;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField) {
        this.textField2 = textField;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField) {
        this.textField3 = textField;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public void setSetButton(JButton setButton) {
        this.sendButton = setButton;
    }
    public void setProgressBar(int count) {this.progressBar.setValue(count);}
    public JProgressBar getProgressBar(){return progressBar;}

    public MyFrame() {
        this.setTitle("Email Sender");
        this.getContentPane().setBackground(Color.MAGENTA);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);

        textField1.setBounds(10, 20, 465, 75);
        textField1.setFont(new Font("Calibre", Font.BOLD, 20));
        textField1.setText(" Введите адрес получателя");
        textField1.setBackground(Color.WHITE);


        textField2.setBounds(10, 110, 465, 75);
        textField2.setFont(new Font("Calibre", Font.BOLD, 20));
        textField2.setText(" Введите тему сообщения");
        textField2.setBackground(Color.WHITE);


        textField3.setBounds(10, 200, 465, 75);
        textField3.setFont(new Font("Calibre", Font.BOLD, 20));
        textField3.setText(" Введите сообщение");
        textField3.setBackground(Color.WHITE);


        sendButton.setForeground(Color.BLACK);
        sendButton.setFont(new Font("Calibre", Font.BOLD, 40));
        sendButton.setBounds(40, 310, 405, 100);
        sendButton.setFocusable(false);

        progressBar.setStringPainted(true);
        progressBar.setBounds(40, 410, 405, 50);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setFocusable(false);

        this.add(textField1);
        this.add(textField2);
        this.add(textField3);
        this.add(sendButton);
        this.add(progressBar);
        this.setBackground(Color.BLACK);

        textField1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField1.setText("");
            }
        });
        textField2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField2.setText("");
            }
        });
        textField3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField3.setText("");
            }
        });
    }
}
