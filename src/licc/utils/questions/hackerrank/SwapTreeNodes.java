package licc.utils.questions.hackerrank;

import java.util.Scanner;

/**
 * Created by user on 2015/7/13.
 */
public class SwapTreeNodes {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] left = new int[N + 1];
        int[] right = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            left[i] = in.nextInt();
            right[i] = in.nextInt();
        }
        int T = in.nextInt();
        for (int i = 0; i < T; ++i) {
            int k = in.nextInt();
            swap(left, right, 1, 1, k);
            printInOrder(left, right, 1);
            System.out.println();
        }
    }

    private static void swap(int[] lTree, int[] rTree, int root, int depth, int k) {
        if (depth % k == 0) {
            int tmp = lTree[root];
            lTree[root] = rTree[root];
            rTree[root] = tmp;
        }
        //search left
        if (lTree[root] != -1)
            swap(lTree, rTree, lTree[root], depth + 1, k);
        //search right
        if (rTree[root] != -1)
            swap(lTree, rTree, rTree[root], depth + 1, k);

    }

    private static void printInOrder(int[] lTree, int[] rTree, int root) {
        if (lTree[root] != -1)
            printInOrder(lTree, rTree, lTree[root]);
        System.out.print(root + " ");
        if (rTree[root] != -1)
            printInOrder(lTree, rTree, rTree[root]);
    }
}
