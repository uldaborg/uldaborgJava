package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientT {

    public static void main(String[] args) {

        try ( Socket clientSocket = new Socket( "localhost", 666 ) )
        {
            new ClientReader(clientSocket);
            new ClientWriter(clientSocket);
        } catch (IOException ex) { ex.printStackTrace(); }
    }

    static class ClientReader implements Runnable {
        private static Socket socket;
        private static Thread readThread;
        private static Boolean running = true;
        private static DataInputStream   in;

        public ClientReader ( Socket socket ){
            this.socket = socket;

            try{
                 this.in = new DataInputStream( socket.getInputStream() );
            } catch ( IOException ex) {
                ex.printStackTrace(); }

            this.readThread = new Thread(this);
            readThread.start();
        }

        public void run(){
            try{
                while ( running )
                {
                    String inMess = in.readUTF();
                    System.out.println( "Новое сообщение > " + inMess );
                }
            } catch ( IOException ex) {
                ex.printStackTrace(); }
        }
    }

    static class ClientWriter implements Runnable {
        private static Socket               socket;
        private static Thread               writeThread;
        private static Boolean              running = true;
        private static DataOutputStream     out;
        private static Scanner              scanner;

        public ClientWriter ( Socket soc ){
            this.socket = soc;
            this.scanner = new Scanner(System.in);
            try{
                this.out = new DataOutputStream( socket.getOutputStream() );
            } catch ( IOException ex) {
                ex.printStackTrace(); }

            this.writeThread = new Thread(this);
            writeThread.start();
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
}

