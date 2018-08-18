public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {3, 3, 2, 3, 5, 4, 3, 1};
        countingSort(arr, 5);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    private static void countingSort(int[] arr, int k){

        int[] arrOther = new int[k+1];

        for (int i=0; i<arr.length; i++) {
            arrOther[arr[i]]++;
        }

        int store = 0;
        for (int i=0; i<=k; i++){
            while(arrOther[i] > 0){
                arr[store++] = i;
                arrOther[i]--;
            }
        }


    }

}
