package licc.utils.questions.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by mengc_000 on 2015/7/9.
 */
public class PreInPostOrderTrvs {
    void preorder(Node root) {
        if (root == null)
            return;
        Deque<Node> s = new ArrayDeque<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node v = s.pop();
            System.out.print(v.data + " ");
            if (v.right != null)
                s.push(v.right);
            if (v.left != null)
                s.push(v.left);
        }
    }

    void preorder2(Node root) {
        if (root == null)
            return;
        Deque<Node> s = new ArrayDeque<>();
        Node curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                //visit node
                System.out.print(curr.data + " ");
                curr = curr.left;
            }

            Node temp = s.pop();
            curr = temp.right;
        }
    }

    void inorder(Node root) {
        if (root == null)
            return;
        Deque<Node> s = new ArrayDeque<>();
        Node curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);

                curr = curr.left;
            }

            Node temp = s.pop();
            //visit node
            System.out.print(temp.data + " ");
            curr = temp.right;
        }
    }

    void postorder(Node root) {
        if (root == null)
            return;
        Deque<Node> s1 = new ArrayDeque<>();
        Deque<Node> s2 = new ArrayDeque<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            Node v = s1.pop();
            s2.push(v);
            if (v.left != null)
                s1.push(v.left);
            if (v.right != null)
                s1.push(v.right);
        }
        while (!s2.isEmpty()) {
            Node v = s2.pop();
            System.out.print(v.data + " ");
        }
    }

    void postorder2(Node root) {
        if (root == null)
            return;
        Deque<Node> s = new ArrayDeque<>();
        Node curr = root;
        Node previsit = null;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            Node temp = s.peek();
            if (temp.right == null || temp.right == previsit) {
                System.out.print(temp.data + " ");
                previsit = temp;
                s.pop();
            } else {
                curr = temp.right;
            }
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
        }
    }
}


