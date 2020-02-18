package lesson3;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try (Socket client = new Socket("127.0.0.1", 8190)) {

            ArrayList<Employee> staff = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                staff.add(new Employee(i, "Сотрудник"+i, "инженер"+i, 30+i));
            }

            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            oos.writeObject(staff);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
