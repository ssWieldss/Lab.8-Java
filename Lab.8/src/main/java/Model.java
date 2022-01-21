
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.HashMap;
import java.util.Properties;

public class Model extends Thread {

    public static MyFrame frame;
    static Properties properties = new Properties();
    static Properties adminProps = new Properties();

    Model(MyFrame frame){
        this.frame = frame;
    }


    public void run() {
        synchronized (this) {
            Session mailSession = Session.getDefaultInstance(properties);
            Message message = new MimeMessage(mailSession);
            HashMap<String, String> data = Controller.message;

            frame.setProgressBar(30);
            try {
                message.setFrom(new InternetAddress(adminProps.getProperty("user")));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(data.get("email")));
                message.setText(data.get("body"));
                message.setSubject(data.get("subject"));
                frame.setProgressBar(65);
            } catch (MessagingException ex) {
                View.out("Ошибка доступа к почте!");
                System.exit(0);
            }


            try {
                Transport transport = mailSession.getTransport();
                transport.connect("smtp.gmail.com", 587, adminProps.getProperty("user"),
                        adminProps.getProperty("password"));
                frame.setProgressBar(80);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
                frame.setProgressBar(100);
            } catch (MessagingException e) {
                View.out("Ошибка при отправке сообщения");
                System.exit(0);
            }
            int answer = JOptionPane.showConfirmDialog(null, "Хотите отправить " +
                    "ещё одно письмо?", "Успешно отправлено", JOptionPane.YES_NO_OPTION);
            if (answer == 1)
                System.exit(0);
            if (answer == 0) {
                frame.setProgressBar(0);
                Thread.interrupted();
            }
        }
    }
}
