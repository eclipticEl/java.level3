package lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static  void task1(String fileName){
        long t = System.currentTimeMillis();
        try(FileInputStream in = new FileInputStream(fileName)) {
            byte[] arr = new byte[256];
            int size = in.read(arr);
            for (int i = 0; i < size; i++) {
                System.out.print((char) arr[i]);
            }
// или так
//          System.out.print(new String(arr, 0, size, "UTF-8"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(System.currentTimeMillis() - t);

    }

    public static void task2(String dirName) throws IOException{
        File dirF = new File(dirName);
        String[] srcFiles = dirF.list((dir, name) -> name.endsWith(".txt"));

        if (srcFiles == null){
            return;
        }

        ArrayList<InputStream> ali = new ArrayList<>();
        for (String f: srcFiles) {
            ali.add(new FileInputStream(dirName+'/'+f));
        }

        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));

        try (FileOutputStream destFile = new FileOutputStream("ConcatFile.txt")) {
            byte[] arr = new byte[512];
            int x;
            while ((x = in.read(arr)) > 0) {
                destFile.write(arr);
            }
            in.close();
        }
    }

    public static void main(String[] args) {
        task1("01.sql");
        try {
            task2("concat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
