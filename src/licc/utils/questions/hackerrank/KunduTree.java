package licc.utils.questions.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 2015/7/16.
 */
public class KunduTree {
    /* https://www.hackerrank.com/challenges/kundu-and-tree
     * data structure -> disjoint set -> kundu tree
     * timeout
     * refer to http://math.stackexchange.com/questions/838792/counting-triplets-with-red-edges-in-each-pair
     * and http://www.cnblogs.com/lautsie/p/3798165.html
     * with the counting
     * can also infer the equals of
     * N(N-1)(N-2) - sums(t_i(t_i -1)(3N-2t_i-2)) === pow(p1,3) - 3p1p2 + 2p3
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        final int mod = 1000000007;
        String color;
        //from 1 to N
//        long t1 = System.nanoTime();
        UnionSet us = new UnionSet(N);
        for (int i = 1; i <= N; ++i)
            us.makeset(i);

        int cnt = N;
        int a, b;
        while (--cnt > 0) {
            a = in.nextInt();
            b = in.nextInt();
            color = in.next().trim();
            if (color.equals("b")) {
                us.union(a, b);
            }
        }
        int[] ranks = us.rootRanks();
//        long t2 = System.nanoTime();
//        System.out.println((t2 - t1) / (1000 * 1000 * 1000 * 1.0));
        if (ranks.length < 3)
            System.out.println(0);
        else {
            long total, others = 0L;
//            long p1 = 0, p2 = 0, p3 = 0;
            for (int rank : ranks) {
                others += ((long) rank * (rank - 1) * (3 * N - 2 * rank - 2));
//                p1 += rank;
//                p2 += rank * rank;
//                p3 += rank * rank * rank;
            }
            total = (((long) N * (N - 1) * (N - 2) - others) / 6) % mod;
//            System.out.println((p1 * p1 * p1 - 3 * p2 * p1 + 2 * p3) / 6 % mod);
            System.out.println(total);
        }
//        long t3 = System.nanoTime();
//        System.out.println((t3 - t2) / (1000 * 1000 * 1000 * 1.0));
    }

    static class UnionSet {
        int[] father;
        int[] rank;

        public UnionSet(int N) {
            father = new int[N + 1];
            rank = new int[N + 1];
        }

        public void makeset(int v) {
            father[v] = v;
            rank[v] = 1;
        }

        public int find(int v) {
            if (father[v] == v)
                return v;
            father[v] = find(father[v]);
            return father[v];
        }

        public void union(int x, int y) {
            int root_x = find(x);
            int root_y = find(y);
            if (root_x == root_y)
                return;
            if (rank[root_x] >= rank[root_y]) {
                father[root_y] = root_x;
                rank[root_x] += rank[root_y];
            } else {
                father[root_x] = root_y;
                rank[root_y] += rank[root_x];
            }
        }

        public int[] rootRanks() {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 1; i < father.length; ++i) {
                if (father[i] == i)
                    arr.add(i);
            }
            int[] ret = new int[arr.size()];
            for (int i = 0; i < ret.length; ++i)
                ret[i] = rank[arr.get(i)];
            return ret;
        }
    }
}
