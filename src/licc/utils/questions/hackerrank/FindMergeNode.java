package licc.utils.questions.hackerrank;

/**
 * Created by user on 2015/7/7.
 */
public class FindMergeNode {
    int FindMergeNode(Node headA, Node headB) {
        // Complete this function
        // Do not write the main method.
        if (headA == null || headB == null)
            return 0;
        int lenA = 0, lenB = 0;
        Node p = headA;
        while (p != null) {
            p = p.next;
            lenA++;
        }
        p = headB;
        while (p != null) {
            p = p.next;
            lenB++;
        }
        int cnt = 0;
        Node q;
        boolean equalFlag = false;
        if (lenA > lenB) {
            cnt = lenA - lenB;
            p = headA;
            q = headB;
        } else if (lenA == lenB) {
            p = headA;
            q = headB;
            equalFlag = true;
        } else {
            cnt = lenB - lenA;
            p = headB;
            q = headA;
        }
        if (!equalFlag) {
            while (cnt-- > 0)
                p = p.next;
        }

        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p.data;
    }
    class Node {
        int data;
        Node next;
    }
}





