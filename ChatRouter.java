package Lesson7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatRouter implements Runnable {
    private static Socket               socket;
    private static DataInputStream      in;
    private static DataOutputStream     out;
    private static DataOutputStream     ReceiverOut;
    private static String               name;
    private static String               outMess;

    ChatRouter ( Socket socket ){

        this.socket = socket;
        try{
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        } catch ( IOException ex) {
            ex.printStackTrace(); }
    }

    public void run(){
        try{
            while ( true ) {
                String  inMess = in.readUTF();

                boolean yes = inMess.contains("/w ");
                int     pos = inMess.indexOf("/w ") + 3;
                if (yes) {
                    inMess   = inMess.substring(pos) ;

                    yes      = inMess.contains(" ");
                    pos      = inMess.indexOf(" ");
                    if(yes) {
                        name    = inMess.substring(0, pos);
                        outMess = inMess.substring( pos);

                        Socket answer = (Socket) ChatServer.mySockets.get(name);
                        if( answer == null ) {
                            out.writeUTF( "Адресата с именем " + name + " нет");
                        }
                        else{
                        ReceiverOut = (DataOutputStream) ChatServer.myWriters.get(name);
                        ReceiverOut.writeUTF( outMess );
                        System.out.println( "Новое сообщение > " + outMess + " передано адресату " + name);}
                    }
                }
                else{
                    out.writeUTF( "Вы некорректно указали адресата");
                }
            }
        } catch ( IOException ex) {
            ex.printStackTrace(); }
    }



}