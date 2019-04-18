package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
        static DataInputStream     in;
        static DataOutputStream    out;
        static Socket              socket;

    public static void main(String[] args) {
        String              inMess;
        String              outMess;
        DataInputStream     in;
        DataOutputStream    out;
        Socket              socket;

        try (ServerSocket serverSocket = new ServerSocket(7777);
             Scanner scanner = new Scanner(System.in);)
        {
            System.out.println("Сервер ожидает подключения!");
            socket = serverSocket.accept();
            System.out.println("Кто-то подключился: " + socket.getInetAddress());
            in  = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                while (true) {
                    inMess = in.readUTF();
                    System.out.println( "Новое сообщение > " + inMess );
                    if( inMess.equals("WBR") || inMess.equals("?")  ) {
                        break; }
                }
                while (true) {
                    System.out.print( "Введите сообщение > " );
                    outMess = scanner.nextLine();
                    out.writeUTF( outMess );
                    if( outMess.equals("WBR") || outMess.equals("?")  ) {
                        break; }
                }
                if (  outMess.equals("WBR") && inMess.equals("WBR") ) {
                    break;}
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
