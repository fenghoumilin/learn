package newcorder;

import java.util.Scanner;

//动态规划

public class Choir {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int arr[] = new int[n+1];
            for(int i=1; i<=n; i++) {
                arr[i] = sc.nextInt();
            }
            int kk = sc.nextInt();
            int dd = sc.nextInt();

            long[][] fp = new long[n+1][kk+1];
            long[][] gp = new long[n+1][kk+1];

            for (int i=1; i<=n; i++) {
                fp[i][1] = arr[i];
                gp[i][1] = arr[i];
            }
            /*
            *注意边界 max{k-1,one-d}<=left<=one-1
            *递推
            * 注意正数负数问题
            *
            * */
            for(int k=2; k<=kk; k++) {
                for(int one=k; one<=n; one++) {
                    long maxLong = Long.MIN_VALUE;
                    long minLong = Long.MAX_VALUE;

                    for(int left=Math.max(one-dd, k-1); left<=one-1; left++) {
                        if(maxLong < Math.max(fp[left][k-1]*arr[one], gp[left][k-1]*arr[one])) {
                            maxLong = Math.max(fp[left][k-1]*arr[one], gp[left][k-1]*arr[one]);
                        }
                        if(minLong > Math.min(fp[left][k-1]*arr[one], gp[left][k-1]*arr[one])) {
                            minLong = Math.min(fp[left][k-1]*arr[one], gp[left][k-1]*arr[one]);
                        }
                    }
                    fp[one][k] = maxLong;
                    gp[one][k] = minLong;
                }
            }
            long ans = Long.MIN_VALUE;
            for(int i=kk; i<=n; i++) {
                if(ans < fp[i][kk]) {
                    ans = fp[i][kk];
                }
            }
            System.out.println(ans);
        }

    }
//变动


}
