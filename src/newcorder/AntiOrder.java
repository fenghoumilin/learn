package newcorder;

public class AntiOrder {

    int ans = 0;

    public static void main(String[] args) {
        AntiOrder antiOrder = new AntiOrder();
        int[] A = {1,0};
        antiOrder.count(A, A.length);

    }

    public int count(int[] A, int n) {
        int[] b = new int[n];
        ans = 0;
        merge(A, b, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.println(A[i]);
        }
        System.out.println(ans);
        return ans;
    }

    public void merge(int[] a, int[] b, int left, int right) {
        if (left >= right) {
            return;
        }
        int sl = left, mid=(left+right)>>>1, sr=mid+1, index=left, invert = 0;
        //System.out.println(mid);
        merge(a, b, left, mid);
        merge(a, b, sr, right);
        while (sl <= mid && sr <= right) {
            if (a[sl] <= a[sr]) {
                b[index++] = a[sl++];
                ans += invert;
            } else {
                b[index++] = a[sr++];
                invert++;
            }
        }
        while (sl <= mid) {
            b[index++] = a[sl++];
            ans += invert;
        }
        while (sr <= right) {
            b[index++] = a[sr++];
        }
        for (index=left; index<=right; index++) {
            a[index] = b[index];
        }
    }

}
