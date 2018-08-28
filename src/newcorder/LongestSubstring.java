package newcorder;

public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        int ans = ls.findLongest("abcgabce", 8, "abcdabce", 8);
        System.out.println(ans);
    }
    public int findLongest(String A, int n, String B, int m) {
        // write code here
        int[][] dp = new int[n][m];
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    if (i==0 || j==0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                max = max > dp[i][j] ? max : dp[i][j];
            }
        }

        return max;
    }


}
