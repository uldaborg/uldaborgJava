package Lesson7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class ChatServer {
    public static Logins      myLogins        = new Logins();
    public static Sockets     mySockets       = new Sockets();
    public static Readers     myReaders       = new Readers();
    public static Threads     myThreads       = new Threads();
    public static Writers     myWriters       = new Writers();

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket( 666 )) {
            System.out.println( "Сервер ожидает подключения!" );
            int i = 0;
            while(true) {
               i++;
               System.out.println("Wait");
               Socket socket = serverSocket.accept();
               System.out.println( "Подключился: " + socket.getInetAddress() );
//задаем логин - пароль
               myLogins.put ( "User" + i , i + "resU");
               mySockets.put( "User" + i , socket);

                ChatRouter router = new ChatRouter( socket );
                myWriters.put( "User" + i , new DataOutputStream( socket.getOutputStream() ));

                myReaders.put( "User" + i , router);
                myThreads.put( "User" + i  , new Thread( router, "RUser" + i ));
               ((Thread) myThreads.get("User" + i)).start();
            }

        } catch (Exception ex) {
            ex.printStackTrace();}
    }

    static class Logins extends HashMap{
        Logins(){
            new HashMap< String, String  > ();
        }}

    static class Sockets extends HashMap{
        Sockets(){
            new HashMap< String, Socket  > ();
        }}

    static class Readers extends HashMap{
        Readers(){
            new HashMap< String, DataInputStream  > ();
        }}

    static class Threads extends HashMap{
        Threads(){
            new HashMap< String, Thread  > ();
        }}

    static class Writers extends HashMap{
        Writers(){
            new HashMap< String, DataOutputStream  > ();
        }}


}


