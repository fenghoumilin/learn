import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

    public static final int HASHCODE = 3;

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 13, 2, 14, 2, 7};
        sortPointer(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sortPointer(int[] arr){
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(10);
        for (int i = 0; i <10 ; i++) {
            bucket.add(new ArrayList<Integer>());
        }
        int min = 0;

        //装桶
        for (int i=0; i<arr.length; i++){
            bucket.get(hash(arr[i])).add(arr[i]);
        }

        int store = 0;
        for (int i=0; i<bucket.size(); i++){
            store = insertSort(bucket.get(i), arr, store);
        }


    }

    public static int hash(int n){
        return n/HASHCODE;
    }

    public static int insertSort(ArrayList<Integer> al, int[] arr, int store){
        if (al.size() == 0 || al==null) {
            return store;
        }

        int[] b = new int[HASHCODE];
        int bx = al.get(0) / HASHCODE;
        for(int i=0; i<al.size(); i++){
            b[al.get(i)%HASHCODE]++;
        }

        for(int i=0; i<HASHCODE; i++){
            while (b[i] > 0){
                arr[store++] = HASHCODE*bx+i;
                b[i]--;
            }
        }
        return store;
    }

}
