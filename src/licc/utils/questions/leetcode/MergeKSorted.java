package licc.utils.questions.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by mengchenli on 2015/5/19.
 */

public class MergeKSorted {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null)
                q.add(node);
        }

        ListNode ret = new ListNode(0);
        ret.next = null;
        ListNode p = ret;
        while (q.size() > 0) {

            ListNode t = q.poll();
            if (t.next != null) {
                q.add(t.next);
            }

            p.next = t;
            p = p.next;
        }

        return ret.next;

    }

    public void print(ListNode l) {
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }
}
