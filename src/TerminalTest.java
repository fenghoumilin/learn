import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class TerminalTest {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);

        }


    }
}
