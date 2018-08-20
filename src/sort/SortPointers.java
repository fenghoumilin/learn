package sort;

public class SortPointers {

    public static void main(String[] args) {
        int[] arr = {15, 9, 8, 1, 4, 11, 7, 12, 13};
        SortPointers sp = new SortPointers();
        sp.sortPointers(arr, arr.length);
        for(int i : arr){
            System.out.println(i);
        }
    }

    private void sortPointers(int[] arr, int n){
        for(int i=1; i<n; i++){
            int j = i-1;
            int value = arr[i];
            while(j>=0 && arr[j]>value){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }

    }

}
