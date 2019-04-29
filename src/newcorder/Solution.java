package newcorder;


import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = ListNode.create(arr);
        Solution solution = new Solution();
        solution.reorderList(head);
        ListNode.print(head);
    }



    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }
        ListNode midNode = getMidNode(head);
        ListNode.print(midNode);
        System.out.println("sssss");
        ListNode.print(head);
        System.out.println("sssss");
        midNode = reverseList(midNode);
        while (head != null) {
            ListNode next = head.next;
            head.next = midNode;
            midNode = midNode.next;
            head.next.next = next;
            head = next;
        }
        if (midNode != null) {

        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }


    public ListNode getMidNode(ListNode head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode slowNode = head;
        ListNode quickNode = head.next;
        while (quickNode.next != null && quickNode.next.next != null) {
            slowNode = slowNode.next;
            quickNode = quickNode.next.next;
        }


        ListNode res = slowNode.next;
        slowNode.next = null;

        return res;
    }
}