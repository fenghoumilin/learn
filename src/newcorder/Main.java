package newcorder;

import java.util.*;

public class Main{
    private static char[] mod = {'A', 'G', 'C', 'T'};
    private static LinkedList<String> queue = new LinkedList<>();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();

            Set<String> set = new HashSet<>();
            int length = str.length();
            for (int i=0; i<length; i++) {
                for (int j=1; j<=6 && (i+j)<=length; j++) {
                    set.add(str.substring(i, i+j));
                }
            }
            int min = 6;

            for (int i=0; i<4; i++) {
                String s = mod[i] + "";
                if (!set.contains(s)) {
                    min = 1;
                }
                queue.add(s);
            }
            min = bfs(set, 2, min);
            System.out.println(min);
            if (queue.size() > 0) {
                queue.pop();
            }
        }
    }

    private static int bfs(Set<String> set, int index, int min) {

        if (min <= index) {
            return min;
        }
        int n = queue.size();
        if (n > 0) {
            for (int k=0; k<n; k++) {
                String pop = queue.pop();
                for (int i=0; i<4; i++) {
                    String tag = pop + mod[i];
                    if (!set.contains(tag)) {
                        return index;
                    } else {
                        queue.addLast(tag);
                    }
                }
            }
            if (index == 6) {
                return 6;
            }
            min = bfs(set, index+1, min);
        }

        return min;
    }

}
