package ru.geekbrains.java3_lesson3_client_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189);
             Socket socket = server.accept()) {
            System.out.println("Client connected");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Book bookIn = (Book) ois.readObject();
            System.out.println(bookIn);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                System.out.println("Ready to read");
                String b = in.readUTF();
                out.writeUTF("echo: " + b);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
