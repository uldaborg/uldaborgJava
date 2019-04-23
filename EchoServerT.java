package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServerT {

    public static void main(String[] args) {


        try ( ServerSocket serverSocket = new ServerSocket(666) )
        {
            System.out.println("Сервер ожидает подключения!");
            Socket socket = serverSocket.accept();
            System.out.println("Кто-то подключился: " + socket.getInetAddress());

            new ServerReader(socket);

            new ServerWriter(socket);

        } catch (IOException ex) { ex.printStackTrace(); }
    }

    static class ServerReader implements Runnable {
        private static Socket socket;
        private static Thread readThread;
        private static Boolean running = true;

        ServerReader ( Socket socket ){
            this.socket = socket;
            this.readThread = new Thread(this);
            readThread.start();
        }

        public void stop(){
            running = false;
        }

        public void run(){
            try{
                DataInputStream in  = new DataInputStream(socket.getInputStream());
                while ( running ) {
                    String inMess = in.readUTF();
                    System.out.println( "Новое сообщение > " + inMess );
                }
            } catch ( IOException ex) {
                ex.printStackTrace(); }
        }
    }

    static class ServerWriter implements Runnable {
        private static Socket   socket;
        private static Thread   writeThread;
        private static Boolean  running = true;
        private static Scanner  scanner;

        ServerWriter ( Socket socket ){
            this.socket = socket;
            this.scanner = new Scanner(System.in);
            this.writeThread = new Thread(this);
            writeThread.start();
        }

        public void stop(){
            running = false;
        }

        public void run(){
            try{
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                while ( running ) {
                    System.out.print( "Введите сообщение > " );
                    String outMess = scanner.nextLine();
                    out.writeUTF( outMess );
                }
            } catch ( IOException ex) {
                ex.printStackTrace(); }
        }
    }
}

