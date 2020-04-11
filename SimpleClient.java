package ru.geekbrains.java3_lesson3_client_server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) {

        try (Socket s = new Socket("127.0.0.1", 8189)) {
            System.out.println("Socket connected");

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            Book book = new Book("HP");
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(book);
            System.out.println(book);

            System.out.println("Socket ready");
            Scanner sc = new Scanner(System.in);
            while (true) {
                out.writeUTF(sc.nextLine());
                System.out.println("byte written");
                String b = in.readUTF();
                System.out.println("byte received: " + b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
