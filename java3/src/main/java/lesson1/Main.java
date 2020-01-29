package lesson1;

public class Main {

    public static void main(String[] args) {
        String[] strarr = {"ivanov", "petrov","sidirov", "pupkin"};
        Integer[] intarr = {1,2,3,4,5,6,7};
        UniArray<Integer> myarr = new UniArray<Integer>(intarr);
        myarr.swapped(1,3);
        System.out.println(myarr.toString());

    }
}
