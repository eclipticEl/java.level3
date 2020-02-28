package lesson8;

import java.util.ArrayList;
import java.util.Stack;

public class Assistant {

    public ArrayList<Integer> deepSearchIDs(String  parentColumnName, String childColumnName, String tableName, String dbName, int rootID){
        DbEntity db = new DbEntity(dbName);
        ArrayList<Integer> arr = new ArrayList<>();
        try {
            db.connect();

            Stack<Integer> stack= new Stack<>();

            Integer childID = rootID;

            stack.push(rootID);
            while (!stack.isEmpty()){  //select id from worknet where parentId = 0 and id > 2 order by id
                childID = db.getRecIDs("select "+ childColumnName+ " from "+ tableName+ " where "+ parentColumnName + "="+stack.peek()+
                                        " and "+ childColumnName+ ">" + childID.toString()+ " order by "+ childColumnName);

                if (childID!= null){
                    stack.push(childID);
                    arr.add(childID);
                }
                else{
                    childID = stack.pop();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.disconnect();
        }
        return arr;
    }
}
