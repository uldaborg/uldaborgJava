package Lesson7;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatWriter implements Runnable {
    private static Socket               socket;
    private static Boolean              running = true;
    private static DataOutputStream     out;
    private static Scanner              scanner;

    public ChatWriter ( Socket soc ){
        this.socket = soc;
        this.scanner = new Scanner(System.in);
        try{
            this.out = new DataOutputStream( socket.getOutputStream() );
        } catch ( IOException ex) {
            ex.printStackTrace(); }
    }

    public void run(){
        try{
            while ( running ) {
                System.out.println( "Введите сообщение > " );
                String outMess = scanner.nextLine();
                out.writeUTF( outMess );
            }
        } catch ( IOException ex) {
            ex.printStackTrace(); }
    }
}
