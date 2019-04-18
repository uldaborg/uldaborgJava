package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    static DataInputStream     in;
    static DataOutputStream    out;

    public static void main(String[] args) {
        String inMess;
        String outMess;

        try (
             Scanner scanner = new Scanner(System.in);
             Socket clientSocket = new Socket("localhost", 7777) )
        {
            out = new DataOutputStream(clientSocket.getOutputStream());
            in  = new DataInputStream(clientSocket.getInputStream());

        while (true) {
            while (true) {
                System.out.print( "Введите сообщение > " );
                outMess = scanner.nextLine();
                out.writeUTF( outMess );
            if( outMess.equals("WBR") || outMess.equals("?") ) {
               break; }
            }
            while (true) {
                inMess = in.readUTF();
                System.out.println( "Новое сообщение > " + inMess );
            if( inMess.equals("WBR") || inMess.equals("?") ) {
               break; }
            }
        if (  outMess.equals("WBR") && inMess.equals("WBR") ) {
            break;}
        }
        } catch (IOException ex) {
            ex.printStackTrace(); }

        closeConnection();
    }
    public static void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}