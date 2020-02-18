package lesson6;

import java.util.Arrays;

public class ArrayCalc {

    public int[] afterLastVal(int[] arr, int val){
        int valInd = -1;

        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]== val){
                valInd = i;
            }
        }

        if (valInd==-1){
            throw new RuntimeException("В массиве не содержится указанного значения ("+val+ ")");
        }

        if (valInd == (arr.length - 1))
            return  null;

        int[] res = Arrays.copyOfRange(arr, valInd+1, arr.length);
        return res;
    }

    public boolean isFound(int[] arr, int ... val){
        for (int i = 0; i < val.length ; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j]==val[i]){
                    return true;
                }
            }
            
        }
        return false;
    }

}
