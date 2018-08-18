public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {15, 9, 8, 1, 4, 11, 7, 12, 13};
        sortPointer(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void sortPointer(int[] arr){

        int n = arr.length;
        buildHeap(arr, n);
        for(int i=n-1; i>=1; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }


    }

    private static void buildHeap(int[] arr, int n){

        for (int i=n/2-1; i>=0; i--) {
            heapify(arr, i, n);
        }

    }

    private static void heapify(int[] arr, int i, int n){

        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int maxindex = i;
        if (leftChild<n && arr[leftChild] > arr[i] ){
            maxindex = leftChild;
        }
        if (rightChild<n && arr[rightChild] > arr[maxindex]){
            maxindex = rightChild;
        }
        if (i != maxindex){

            swap(arr, i, maxindex);
            heapify(arr, maxindex, n);

        }

    }

    private static void swap(int[] arr, int i, int maxindex) {
        int temp = arr[maxindex];
        arr[maxindex] = arr[i];
        arr[i] = temp;
    }

}
