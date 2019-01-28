package newcorder;

import java.util.Comparator;
import java.util.TreeSet;

public class Stack {

    public int getHeight(int[][] actors, int n) {
        // write code here
        Comparator<Person> ascComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.height - o2.height;
            }
        };
        TreeSet<Person> treeSet = new TreeSet(ascComparator);
        for (int i=0; i<actors.length; i++) {
            Person p = new Person(actors[i][0], actors[i][1]);
            treeSet.add(p);
        }
        int k = 1;
        int dp[] = new int[1000];
        init(dp);
        for (Person p : treeSet) {
            int index = binarySearch(dp, p.getWeight(), 0, k);
            dp[index] = p.getWeight();
            if (index == k-1) {
                k++;
            }
        }


        return k-1;
    }


    class Person{
        int height;
        int weight;

        public Person(int h, int w) {
            height = h;
            weight = w;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
    private void init(int[] dp) {
        for (int i=0; i<dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
    }

    //二分查找最小的 查2位置为1
    private int binarySearch(int[] dp, int x, int left, int right) {

        int low = left;
        int high = right - 1;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (x <= dp[mid]){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
