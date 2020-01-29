package lesson1;

public class UniArray<T> {
    private T[] arr;

    public UniArray(T[] arr) {
        this.arr = arr;
    }

    public void swapped(int ind1, int ind2){
        T obj;

        obj = arr[ind2];
        arr[ind2] = arr[ind1];
        arr[ind1] = obj;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i <arr.length ; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("]");

        return  sb.toString();
    }
}
