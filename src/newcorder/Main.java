package newcorder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<String>();
        while(sc.hasNext()) {

            long h = sc.nextLong();
            long ans = (long)((Math.sqrt((double)h*4+1)-1)/2);



            System.out.println(ans);
        }
    }


}
