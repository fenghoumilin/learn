package newcorder;

import java.util.*;

public class ColoredBricks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>(n);
            for (int i=0; i<n ; i++) {
                list.add(in.nextInt());
            }
            Collections.sort(list);
            if ((list.get(0) - list.get(1)) == (list.get(1) - list.get(2))) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
