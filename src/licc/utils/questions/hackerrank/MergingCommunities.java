package licc.utils.questions.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by user on 2015/7/15.
 */
public class MergingCommunities {
    //https://www.hackerrank.com/challenges/merging-communities
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] count = new int[N];
        Arrays.fill(count, 1);
        int[] parent = new int[N];
        Arrays.fill(parent, -1);
        int Q = in.nextInt();

        while (Q-- > 0) {
            String query = in.next().trim();
            int i, j;
            // i, j index from 1
            if (query.equals("Q")) {
                i = in.nextInt();
                System.out.println(count[findRootAndFold(parent, i - 1)]);
            } else if (query.equals("M")) {
                i = in.nextInt();
                j = in.nextInt();
                int root_i = findRootAndFold(parent, i - 1);
                int root_j = findRootAndFold(parent, j - 1);
                if (root_i != root_j) {
                    count[root_i] += count[root_j];
                    parent[root_j] = root_i;
                }
            }
        }
    }

    private static int findRootAndFold(int[] parent, int i) {
        int j = i;
        //find
        while (parent[j] != -1) {
            j = parent[j];
        }
        //fold
        if (j != i)
            parent[i] = j;
        return j;
    }
}
