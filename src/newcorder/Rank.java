package newcorder;

import java.util.Iterator;
import java.util.LinkedList;

public class Rank {

    public static void main(String[] args) {
        Rank rank = new Rank();
        int[] A = {1, 1, 1, 0, 1, 1, 2, 1};
        int n = A.length;
        int[] ans = rank.getRankOfNumber(A, n);
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }
    public int[] getRankOfNumber(int[] A, int n) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            Iterator<Integer> it = list.iterator();
            int j = 0;
            while(it.hasNext()){
                if(it.next()>A[i]){
                    break;
                }
                j++;
            }
            res[i] = j;
            list.add(j,A[i]);
        }
        return res;
    }


}