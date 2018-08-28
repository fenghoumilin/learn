package newcorder;

import java.util.LinkedList;

public class Joseph {

    public static void main(String[] args) {

        Joseph joseph = new Joseph();
        System.out.println(joseph.getResult(5));

    }


    public int getResult(int n) {
        // write code here
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i=1; i<=n; i++) {
            list.add(i);
        }
        if(list == null || list.size() == 0){
            return 0;
        }
        int num = 2;
        while (list.size() != 1) {
            int k = 1;
            while (k < list.size()) {
                for (int i=2; i<=num; i++) {
                    if(k < list.size()) {
                        list.remove(k);
                    }
                }
                k++;
            }
            num++;
            int last = list.removeLast();
            list.addFirst(last);
        }


        return list.get(0);
    }

}
