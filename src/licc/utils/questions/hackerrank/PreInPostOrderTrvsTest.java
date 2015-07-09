package licc.utils.questions.hackerrank;

import junit.framework.TestCase;

public class PreInPostOrderTrvsTest extends TestCase {
    PreInPostOrderTrvs.Node tree;

    public void setUp() throws Exception {
        tree = new PreInPostOrderTrvs.Node(1);
        tree.left = new PreInPostOrderTrvs.Node(2);
        tree.right = new PreInPostOrderTrvs.Node(3);
        tree.left.left = new PreInPostOrderTrvs.Node(4);
        tree.left.right = new PreInPostOrderTrvs.Node(5);
        tree.right.left = new PreInPostOrderTrvs.Node(6);
        tree.right.right = new PreInPostOrderTrvs.Node(7);
        tree.left.left.left = new PreInPostOrderTrvs.Node(8);
        tree.left.left.right = new PreInPostOrderTrvs.Node(9);
        tree.left.right.left = new PreInPostOrderTrvs.Node(10);
    }

    public void testPreorder() throws Exception {
        PreInPostOrderTrvs test = new PreInPostOrderTrvs();
        test.preorder(tree);
    }

    public void testPreorder2() throws Exception {
        PreInPostOrderTrvs test = new PreInPostOrderTrvs();
        test.preorder2(tree);
    }

    public void testInorder() throws Exception {
        PreInPostOrderTrvs test = new PreInPostOrderTrvs();
        test.inorder(tree);
    }

    public void testPostorder() throws Exception {
        PreInPostOrderTrvs test = new PreInPostOrderTrvs();
        test.postorder(tree);
    }

    public void testPostorder2() throws Exception {
        PreInPostOrderTrvs test = new PreInPostOrderTrvs();
        test.postorder2(tree);
    }
}