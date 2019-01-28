package newcorder;

import java.util.*;

public class SortString {

    public static void main(String[] args) {
        SortString sortString = new SortString();
        String[] str = {"ab","ba","abc","cba"};
        int n = 4;
        ArrayList<String> ans = sortString.sortStrings(str, n);
        for (String stri : ans) {
            System.out.println(stri);
        }
    }
    public ArrayList<String> sortStrings(String[] str, int n) {

        List<StrTemp> strTemps = new ArrayList<>();
        for (int i=0; i<n; i++) {
            strTemps.add(new StrTemp(str[i]));
        }
        Collections.sort(strTemps);
        ArrayList<String> ans = new ArrayList<>();

        String rep = strTemps.get(0).getNewStr();
        ans.add(strTemps.get(0).getOldStr());
        for (int i = 1; i < strTemps.size(); i++) {
            if (!rep.equals(strTemps.get(i).getNewStr())) {
                rep = strTemps.get(i).getNewStr();
                ans.add(strTemps.get(i).getOldStr());
            }
        }
        Collections.sort(ans);

        // write code here
        return ans;
    }
}
class StrTemp implements Comparable<StrTemp>{
    String oldStr;
    String newStr;

    public StrTemp(String a) {
        oldStr = a;
        transFormOldStr();
    }

    private void transFormOldStr() {
        char[] newChar = oldStr.toCharArray();
        Arrays.sort(newChar);
        newStr = new String(newChar);
    }

    public String getNewStr() {
        return newStr;
    }

    public String getOldStr() {
        return oldStr;
    }

    @Override
    public int compareTo(StrTemp o1) {
        int ans = this.newStr.compareTo(o1.newStr);
        if (ans == 0) {
            return this.oldStr.compareTo(o1.oldStr);
        }
        return ans;
    }
}
