package lesson1;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> objs;
    private int objCount;
    private int maxObjCout;

    public Box(int maxObjCout) {
        this.maxObjCout = maxObjCout;
        objCount = 0;
        objs = new ArrayList<T>();
    }

    public void add(T obj){
        if (isFull()){
            throw new ArrayIndexOutOfBoundsException("Коробка заполнена");
        }
        objs.add(obj);
        objCount++;

    }
    public boolean remove(T obj){
        if (objs.remove(obj)) {
            objCount--;
            return true;
        }
        return false;
    }

    public T remove(int index){
        T obj;
        obj =  objs.remove(index);
        if (obj != null){
            objCount--;
        }
        return obj;
    }



    public boolean isEmpty(){
        return objCount==0;
    }

    public boolean isFull(){
        return  objCount==maxObjCout;
    }

    public double getWeight(){
        double totalWeight = 0;

        for (T obj: objs ) {
            totalWeight += obj.getWeight();
        }

        return totalWeight;
    }
    public boolean compare(Box<?> box){
        return Math.abs(getWeight()- box.getWeight())<0.01;
    }

    public void moveTo(Box<T> box){
        if (isEmpty())
            return;

        int index = 0;
        while (!isEmpty() && !box.isFull()){
            box.add(remove(index));
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(" Коробка(" );
        for (T obj: objs ) {
            sb.append( obj.toString()+";");
        }
        sb.append(")");
        return sb.toString();
    }
}
