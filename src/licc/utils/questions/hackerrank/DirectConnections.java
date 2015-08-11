package licc.utils.questions.hackerrank;

import java.util.*;

/**
 * Created by user on 2015/7/28.
 */

class BinaryIndexedTree {
    long[] tree;    //when use int[] , there would be overflow

    BinaryIndexedTree(int MaxValue) {
        tree = new long[MaxValue + 1];
    }

    long readCumulative(int idx) {
        long sum = 0L;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }

    void update(int idx, int value) {
        while (idx < tree.length) {
            tree[idx] += value;
            idx += (idx & -idx);
        }
    }
}

public class DirectConnections {

    static class City {
        int i; // 1- N
        int c;  //border to border length <= 1,000,000,000
        int p;  //pi <= 10,000
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        final int mod = 1000000007;
        while (T-- > 0) {
            int N = in.nextInt();   // N <= 200,000
            City[] arr = new City[N];
            for (int i = 0; i < N; ++i) {
                arr[i] = new City();
                arr[i].c = in.nextInt();
            }
            for (int i = 0; i < N; ++i)
                arr[i].p = in.nextInt();

            //sort by arr[i].c and keep arr[i].i with same order of arr[i].c
            //then use arr[i].i as BIT's idx
            //once use arr[i].c as BIT's idx, which waste lots of memory in BIT with non-used boxes
            Arrays.sort(arr, new Comparator<City>() {
                @Override
                public int compare(City o1, City o2) {
                    return o1.c - o2.c;
                }
            });

            for (int i = 0; i < N; ++i)
                arr[i].i = i + 1;

            Arrays.sort(arr, new Comparator<City>() {
                @Override
                public int compare(City o1, City o2) {
                    return o1.p - o2.p;
                }
            });
            BinaryIndexedTree bitNum = new BinaryIndexedTree(N);
            BinaryIndexedTree bitSum = new BinaryIndexedTree(N);
            long cableLength = 0L;
            long numLeft, sumLeft, numRight, sumRight;
            for (int i = 0; i < N; ++i) {
                bitNum.update(arr[i].i, 1);
                bitSum.update(arr[i].i, arr[i].c);
                numLeft = bitNum.readCumulative(arr[i].i) - 1;
                numRight = bitNum.readCumulative(N) - bitNum.readCumulative(arr[i].i);
                sumLeft = (bitSum.readCumulative(arr[i].i) - arr[i].c);
                sumRight = bitSum.readCumulative(N) - bitSum.readCumulative(arr[i].i);
                cableLength = (cableLength + arr[i].p * (numLeft * arr[i].c - sumLeft + sumRight - numRight * arr[i].c)) % mod;
            }
            System.out.println(cableLength);
        }
    }
}
