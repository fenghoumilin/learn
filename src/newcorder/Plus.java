package newcorder;

public class Plus {
    public static void main(String[] args) {
        ListNode a = new ListNode(8);

        ListNode b = new ListNode(9);
        Plus p = new Plus();
        ListNode ans = p.plusAB(a, b);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode ans = new ListNode(0);
        if (a == null && b != null) {
            return b;
        } else if (a!=null && b==null) {
            return a;
        } else if (a==null && b==null) {
            return null;
        }
        ListNode root = ans;
        while (a!=null || b!=null) {
            if (a == null) {
                ans.val += b.val;
                b = b.next;
            } else if (b == null) {
                ans.val += a.val;
                a = a.next;
            } else {
                ans.val += (a.val + b.val);
                b = b.next;
                a = a.next;
            }
            int tenBits = 0;
            if (ans.val > 9) {
                tenBits = ans.val / 10;
                ans.val %= 10;

            }
            if (tenBits > 0 || a != null || b != null) {
                ListNode anst = new ListNode(tenBits);
                ans.next = anst;
                ans = anst;
            }

        }


        return root;
    }

    private String getVal(ListNode a) {
        StringBuilder ans = new StringBuilder();
        while (a.next != null) {
            ans.append(a.val);
        }
        return ans.toString();
    }
}