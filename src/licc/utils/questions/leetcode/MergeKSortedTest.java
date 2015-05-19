package licc.utils.questions.leetcode;

import org.junit.Test;

public class MergeKSortedTest {

    @Test
    public void testMergeKLists() throws Exception {
        MergeKSorted test = new MergeKSorted();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(7);
        lists[1] = new ListNode(2);
        lists[1].next = new ListNode(5);
        lists[1].next.next = new ListNode(8);
        lists[2] = new ListNode(3);
        lists[2].next = new ListNode(6);
        lists[2].next.next = new ListNode(9);
        ListNode l = test.mergeKLists(lists);
        test.print(l);

        ListNode[] lists2 = new ListNode[0];
        ListNode l2 = test.mergeKLists(lists2);
        test.print(l2);
    }
}