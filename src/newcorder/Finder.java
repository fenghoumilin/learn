package newcorder;

import java.util.*;

public class Finder {

    public static void main(String[] args) {
        /*Finder finder = new Finder();
        int[] A = {13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,1,2,3,4,5,6,7,8,9,10,11,12};
        int n = 69;
        int x = 18;
        int ans = finder.findElement(A, n, x);*/
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.add("ccc");
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");

        linkedList.addAll(list2);
        int[] ai = {1, 2, 3, 0};
        System.arraycopy(ai, 1, ai, 2, 2);
        /*for (int i = 0; i < ai.length; i++) {
            System.out.println(ai[i]);
        }*/
        TreeSet<String> treeSet = new TreeSet();
        treeSet.addAll(list2);
        for (String str : treeSet) {
            System.out.println(str);
        }

        //Iterator<String> it = linkedList.iterator();
        /*while (it.hasNext()) {
            System.out.println(it.next());
        }*/

        //it.remove();
        //it.remove();
    }


    public int findElement(int[] A, int n, int x) {

        int[] left  = new int[1000];
        int[] right = new int[1000];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i=0; i<n; i++) {
            right[rightIndex++] = A[i];
            if (A[i] > A[i+1]) {
                i++;
                while(i<n) {
                    left[leftIndex++] = A[i++];
                }
            }
        }
        int[] newA = new int[1000];
        int newAIndex = 0;
        for (int i=0; i<leftIndex; i++) {
            newA[newAIndex++] = left[i];
        }
        for (int i=0; i<rightIndex; i++) {
            newA[newAIndex++] = right[i];
        }
        // write code here
        int ans = Arrays.binarySearch(newA, 0, newAIndex, x);


        if (newA[ans] < A[0]) {
            ans += rightIndex;
        } else {
            ans -= leftIndex;
        }

        return ans;
    }


    public int findString(String[] str, int n, String x) {
        // write code here
        String[] newStr = new String[1000];
        int[] ref = new int[1000];
        int newStrIndex = 0;
        for (int i=0; i<n; i++) {
            if (!str[i].equals("")) {
                ref[newStrIndex] = i;
                newStr[newStrIndex++] = str[i];

            }
        }
        int ans = Arrays.binarySearch(newStr, 0, newStrIndex, x);
        ans = ref[ans];


        return ans;
    }
}
