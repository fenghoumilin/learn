package newcorder;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    public static void print(ListNode listNode) {
        System.out.println(listNode.val);
        while (listNode.next != null) {
            listNode = listNode.next;
            System.out.println(listNode.val);
        }
    }

    public static ListNode create(int[] arr) {
        ListNode root = new ListNode(arr[0]);
        ListNode temp = root;
        for (int i=1; i<arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        return root;
    }
}