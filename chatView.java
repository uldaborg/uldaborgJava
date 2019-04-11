package lesson4Main;

import javax.swing.*;
import java.awt.*;

public class chatView {

    public static JFrame        chatFrame;
    public static JPanel        messagePanel;
    public static JTextArea     chatArea;
    public static JButton       send;
    public static JTextField    messageField;
    SendAction    sendIt = new SendAction();


    chatView(){
//создаем фрейм
        chatFrame = new  JFrame("Сетевой чат");
        chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatFrame.setLocationByPlatform(true);
        chatFrame.setSize(400, 400);

//создаем панель
        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.PAGE_AXIS));
        messagePanel.setPreferredSize(new Dimension(350,300));
        messagePanel.setOpaque(true);
        messagePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));

//создаем 2 надписи
        JLabel thisIsChat       = new JLabel("Чат:");
        JLabel thisIsMessage    = new JLabel("Сообщение:");


//создаем поле для переписки
       chatArea = new JTextArea(10, 30);
       chatArea.setLineWrap(true);
       chatArea.setEditable(false);
       JScrollPane scrollPane = new JScrollPane( chatArea );
       messagePanel.add(Box.createRigidArea(new Dimension(10,10)));
       messagePanel.add(thisIsChat);
       messagePanel.add(Box.createRigidArea(new Dimension(10,10)));
       messagePanel.add(scrollPane);

//создаем поле для набивки сообщений
        messagePanel.add(Box.createRigidArea(new Dimension(10,10)));
        messagePanel.add(thisIsMessage);
        messageField = new JTextField(5);
//        messageField.setAlignmentX( Component.CENTER_ALIGNMENT );
        messagePanel.add(Box.createRigidArea(new Dimension(10,10)));
        messageField.addKeyListener(sendIt);
        messagePanel.add(messageField);

//создаем кнопку отправки сообщений
        send = new JButton("ОТПРАВИТЬ");
//        send.setAlignmentX( Component.CENTER_ALIGNMENT );
        messagePanel.add(Box.createRigidArea(new Dimension(10,10)));
        send.addActionListener(sendIt);
        messagePanel.add(send);


// запускаем фрейм
        chatFrame.getContentPane().add(messagePanel);
        chatFrame.setResizable(false);
        chatFrame.pack();
        chatFrame.setVisible(true);

    }



}
