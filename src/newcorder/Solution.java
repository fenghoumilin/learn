package newcorder;


import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {2, 1};
        ListNode head = ListNode.create(arr);
        head = solution.sortList(head);
        ListNode.print(head);

    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = getMidNode(head);
        ListNode right = sortList(midNode.next);
        midNode.next = null;
        ListNode left = sortList(head);
        return mergeList(left, right);
    }

    ListNode mergeList(ListNode left, ListNode right) {

        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left != null) {
            temp.next = left;
        }
        if (right != null) {
            temp.next = right;
        }

        return head.next;
    }


    ListNode getMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = head;
        ListNode quickNode = head.next;
        while (quickNode != null && quickNode.next != null) {
            midNode = midNode.next;
            quickNode = quickNode.next.next;
        }
        return midNode;
    }

}