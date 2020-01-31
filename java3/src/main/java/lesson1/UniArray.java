package lesson1;

import java.util.ArrayList;

public class UniArray<T> {
    private T[] arr;

    public UniArray(T[] arr) {
        this.arr = arr;
    }

    public void swapped(int index1, int index2){
        T element;

        element = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = element;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");

        for (T element : arr) {
            sb.append(element).append(" ");
        }
        sb.append("]");

        return  sb.toString();
    }

    public ArrayList<T> toArrayList(){
        ArrayList<T> arrayList = new ArrayList<>();
        for (T element: arr) arrayList.add(element);
        return arrayList;
    }
}
