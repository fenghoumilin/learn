package newcorder;

public class Queens {

    private static int ans = 0;

    public static void main(String[] args) {
        Queens q = new Queens();
        q.nQueens(9);
        System.out.println(ans);
    }


    public int nQueens(int n) {

        int[] rows = new int[n];
        init(rows);
        ans = 0;
        for(int i=0; i<n; i++){
            rows[0] = i;
            getCount(rows, 1);
        }


        return ans;
    }

    private void getCount(int[] rows, int k) {
        if (k == rows.length) {
            ++ans;
            return ;
        }

        for (int col=0; col<rows.length; col++) {
            if (check(rows, k, col)) {
                rows[k] = col;
                getCount(rows, k+1);
            }
        }
    }

    private boolean check(int[] rows, int k, int j) {

        for (int i=0; i<k; i++) {
            if (((k-i) == Math.abs(j-rows[i])) || (rows[i]==j)) {
                return false;
            }
        }

        return true;
    }

    private static void init(int[] arr) {
        for (int j=0; j<arr.length; j++) {
            arr[j] = 0;
        }
    }
}
