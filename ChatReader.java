package Lesson7;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatReader implements Runnable {
    private static Socket socket;
    private static Boolean running = true;
    private static DataInputStream   in;

    ChatReader ( Socket socket ){
        this.socket = socket;
        try{
            this.in = new DataInputStream(socket.getInputStream());
        } catch ( IOException ex) {
            ex.printStackTrace(); }
    }

    public void run(){
        try{
            while ( running ) {
                String inMess = in.readUTF();
                System.out.println( "Новое сообщение > " + inMess);
            }
        } catch ( IOException ex) {
            ex.printStackTrace(); }
    }
}