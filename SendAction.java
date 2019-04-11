package lesson4Main;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


public class SendAction implements  ActionListener, KeyListener {

    public void actionPerformed(ActionEvent e){

//        System.out.println("Button pressed!");
        addMessage();
        return;
    }

    public void keyPressed (KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
//            System.out.println("Enter pressed!");
            addMessage();
        }
        return;
    }

    public void addMessage(){

        String chatContent;
        String message;

        chatContent = chatView.chatArea.getText();
        message = chatView.messageField.getText();
        if(message.equals("")){
            return;
        }
        if(chatContent.equals("")){
            chatContent = message;
        }
        else{
            chatContent = String.format( "%s%n%s", chatContent, message);
        }

        chatView.chatArea.setText( chatContent );
        chatView.messageField.setText("");
    }

    public void keyTyped (KeyEvent e){
    }

    public void keyReleased (KeyEvent e){
    }
}
