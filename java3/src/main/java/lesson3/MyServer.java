package lesson3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8190)) {
            System.out.println("Server is running");
            Socket s = server.accept();
            System.out.println("Accepted");

            while (true){
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                try {
                    ArrayList<Employee> stuff = (ArrayList<Employee>) ois.readObject();

                    for (Employee e: stuff){
                        System.out.println(e.info());
                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                ois.close();
                return;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
