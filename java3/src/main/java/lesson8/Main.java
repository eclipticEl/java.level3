package lesson8;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Assistant assistant = new Assistant();
        ArrayList<Integer> treeNode = assistant.deepSearchIDs("parentId","id", "worknet","testDB.db",0);

        for (Integer e: treeNode){
            System.out.print(e + " ");
        }
    }
}
