package licc.utils.questions.leetcode;

/**
 * Created by mengchenli on 2015/5/29.
 * From https://leetcode.com/problems/add-two-numbers/
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        ListNode l = new ListNode(0);
        ListNode p = l;
        int c = 0, v;
        while (l1 != null && l2 != null) {
            v = l1.val + l2.val + c;
            c = v >= 10 ? 1 : 0;
            v = v % 10;
            p.next = new ListNode(v);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            v = l1.val + c;
            c = v >= 10 ? 1 : 0;
            v = v % 10;
            p.next = new ListNode(v);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            v = l2.val + c;
            c = v >= 10 ? 1 : 0;
            v = v % 10;
            p.next = new ListNode(v);
            p = p.next;
            l2 = l2.next;
        }
        if (c > 0) {
            p.next = new ListNode(c);
        }
        return l.next;
    }

    public static void print(ListNode l) {
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }
}
