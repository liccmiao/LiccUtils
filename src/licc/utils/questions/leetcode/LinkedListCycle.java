package licc.utils.questions.leetcode;

/**
 * Created by user on 2015/7/7.
 */
public class LinkedListCycle {

    /*
     * determine if it has a cycle in it
     */
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode p = head, q = head;
        while (p != null && q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q)
                return true;
        }
        return false;
    }

    /*
     * return the node where the cycle begins
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode p = head, q = head;
        while (p != null && q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q)
                break;
        }
        if (p == null || q == null || q.next == null)
            return null;
        // p is V step ahead, where x_u = x_u + V, x_u is cycle beginner
        q = head;
        while (q != p) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public int cycleLength(ListNode head) {
        ListNode cycleHead = detectCycle(head);
        if (cycleHead == null)
            return 0;
        else {
            //here can find cycle-length
            int cl = 0;
            ListNode tmp = cycleHead;
            do {
                cl++;
                tmp = tmp.next;
            } while (tmp != cycleHead);
            //cl is cycle-length;
            return cl;
        }
    }
}
