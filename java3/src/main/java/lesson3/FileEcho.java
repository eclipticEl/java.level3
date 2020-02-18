package lesson3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class FileEcho {
    public static void main(String[] args)  throws IOException {

        if (args[1] == null){
            System.out.println("Не задан файл");
            return;
        }
        try( FileReader fr = new FileReader(args[1]);
             BufferedReader br = new BufferedReader(fr);) {

            char[] page = new char[1800];
            int size;
            Scanner scan = new Scanner(System.in);
            while ((size = br.read(page))>0) {
                System.out.print(new String(page,0,size));
                System.out.println();
                System.out.println("Вывести следующую страницу (да/нет)?");
                String answer = scan.nextLine();
                if (!answer.equals("да"))
                    return;
            }
        }
    }
}
