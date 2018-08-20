package sort;

public class MedianSort {

    public static final String XXX = "xxx";
    private static final String YYY = XXX;
    public static void main(String[] args) {

        int[] arr = {15, 9, 8, 1, 4, 11, 7, 12, 13};
        String a = "1";
        int b = 1;
        System.out.println(YYY);
        /*MedianSort ms = new MedianSort();
        ms.medianSort(arr, 0, arr.length-1);
        for(int i : arr){
            System.out.println(i);
        }*/
    }

    private void medianSort(int[] arr, int left, int right){

        if (left >= right){
            return ;
        }

        int mid = (left + right) >> 1;
        int part = partition(arr, left, right, mid);
        medianSort(arr, left, part);
        medianSort(arr, part+1, right);
    }

    private int partition(int[] arr, int left, int right, int pivotIndex){

        int pivot = arr[pivotIndex];
        arr[pivotIndex] = arr[right];
        arr[right] = pivot;

        int store = left;
        int temp = 0;
        for(int i=left; i<right; i++){
            if(arr[i] < pivot){
                temp = arr[store];
                arr[store] = arr[i];
                arr[i] = temp;
                store++;
            }
        }
        temp = arr[store];
        arr[store] = pivot;
        arr[right] = temp;

        return store;
    }

}
