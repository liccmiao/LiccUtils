package licc.utils.questions.hackerrank;

/**
 * Created by user on 2015/7/9.
 */
public class InsertSortedDoubleLinkedList {
    DNode SortedInsert(DNode head, int data) {
        if (head == null) {
            head = new DNode();
            head.data = data;
            head.next = head.prev = null;
            return null;
        }

        DNode p = head;
        while (p.next != null && p.data <= data) {
            p = p.next;
        }

        DNode n = new DNode();
        n.data = data;
        if (p.data > data) {
            if (p.prev == null) {
                p.prev = n;
                n.next = p;
            } else {
                n.prev = p.prev;
                p.prev.next = n;
                p.prev = n;
                n.next = p;
            }
        } else {  //p.next == null
            p.next = n;
            n.prev = p;
        }

        return head;
    }
}

class DNode {
    int data;
    DNode next;
    DNode prev;
}
