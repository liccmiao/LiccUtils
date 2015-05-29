package licc.utils.questions.leetcode;

import org.junit.Test;

public class AddTwoNumbersTest {

    @Test
    public void testAddTwoNumbers() throws Exception {
        ListNode l1 = null;
        ListNode l2 = null;
        assert AddTwoNumbers.addTwoNumbers(l1, l2) == null;
        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode res = AddTwoNumbers.addTwoNumbers(l1, l2);
        AddTwoNumbers.print(res);
        System.out.println();
        l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);
        res = AddTwoNumbers.addTwoNumbers(l1, l2);
        AddTwoNumbers.print(res);
        System.out.println();
        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        res = AddTwoNumbers.addTwoNumbers(l1, l2);
        AddTwoNumbers.print(res);
        System.out.println();
        l1 = new ListNode(0);
        l2 = new ListNode(7);
        l2.next = new ListNode(3);
        res = AddTwoNumbers.addTwoNumbers(l1, l2);
        AddTwoNumbers.print(res);
        System.out.println();
        l1 = new ListNode(5);
        l2 = new ListNode(5);
        res = AddTwoNumbers.addTwoNumbers(l1, l2);
        AddTwoNumbers.print(res);
        System.out.println();
        l1 = new ListNode(1);
        l2 = new ListNode(9);
        l2.next = new ListNode(9);
        res = AddTwoNumbers.addTwoNumbers(l1, l2);
        AddTwoNumbers.print(res);
        System.out.println();
    }
}