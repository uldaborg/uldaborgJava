package Lesson7;

import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) {

        try ( Socket clientSocket = new Socket( "localhost", 666 ) )
        {
            ChatReader reader = new ChatReader(clientSocket);
            Thread read = new Thread(reader);
            read.start();

            ChatWriter writer = new ChatWriter(clientSocket);
            Thread write = new Thread(writer);
            write.start();

            read.join();
            write.join();

        } catch (Exception ex) { ex.printStackTrace(); }
    }}