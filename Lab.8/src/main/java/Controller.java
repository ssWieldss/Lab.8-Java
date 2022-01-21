import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

public class Controller implements ActionListener {

    MyFrame frame;
    public static HashMap<String, String> message = new HashMap<>();
    Model model;


    public Controller(MyFrame frameValue){
        frame = frameValue;
        frame.getSendButton().addActionListener(this);
        model = new Model(frame);
    }

    public void Start() {
        Properties prop = new Properties();
        Properties admin = new Properties();
         String PROPERTIES_PATH = "C:\\Users\\egor1\\IdeaProjects\\Lab.8\\src\\main\\resources\\properties.ini";
         String ADMIN_PATH = "C:\\Users\\egor1\\IdeaProjects\\Lab.8\\src\\main\\resources\\adminData.ini";
        try{
            prop.load(new FileInputStream(new File(PROPERTIES_PATH)));
            admin.load(new FileInputStream(new File(ADMIN_PATH)));
            Model.adminProps = admin;
            Model.properties = prop;
        }
        catch (IOException ex){
            View.out("Ошибка чтения свойств!");
            System.exit(0);
        }
        View.out("Свойства успешно загружены!");
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==frame.getSendButton()){
            Model model = new Model(frame);
            message.put("email", frame.getTextField1().getText());
            message.put("subject",  frame.getTextField2().getText());
            message.put("body",  frame.getTextField3().getText());
            frame.setProgressBar(20);
            model.start();
        }
    }

}
