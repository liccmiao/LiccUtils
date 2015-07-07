package licc.utils.questions.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListCycleTest {

    @Test
    public void testHasCycle() throws Exception {
        ListNode p = null;
        LinkedListCycle test = new LinkedListCycle();
        assert !test.hasCycle(p);
        p = new ListNode(1);
        assert !test.hasCycle(p);
        p.next = new ListNode(2);
        assert !test.hasCycle(p);
        p.next.next = new ListNode(3);
        //1 -> 2 -> 3 -> 2;
        p.next.next.next = p.next;
        assert test.hasCycle(p);

    }

    @Test
    public void testDetectCycle() throws Exception {
        ListNode p = null;
        LinkedListCycle test = new LinkedListCycle();
        assert test.detectCycle(p) == null;
        p = new ListNode(1);
        assert test.detectCycle(p) == null;
        p.next = new ListNode(2);
        assert test.detectCycle(p) == null;
        p.next.next = new ListNode(3);
        assert test.detectCycle(p) == null;
        //1 -> 2 -> 3 -> 2;
        p.next.next.next = p.next;
        assert test.detectCycle(p).val == 2;
        p.next.next.next = new ListNode(4);
        p.next.next.next.next = p.next.next;
        assert test.detectCycle(p).val == 3;
    }

    @Test
    public void testCycleLength() throws Exception {
        ListNode p = null;
        LinkedListCycle test = new LinkedListCycle();
        p = new ListNode(1);
        assert test.cycleLength(p) == 0;
        p.next = new ListNode(2);
        assert test.cycleLength(p) == 0;
        p.next.next = new ListNode(3);
        assert test.cycleLength(p) == 0;
        //1 -> 2 -> 3 -> 2;
        p.next.next.next = p.next;
        assert test.cycleLength(p) == 2;
        p.next.next.next = new ListNode(4);
        p.next.next.next.next = p.next.next;
        assert test.cycleLength(p) == 2;
        p.next.next.next.next = p.next;
        assert test.cycleLength(p) == 3;
    }
}