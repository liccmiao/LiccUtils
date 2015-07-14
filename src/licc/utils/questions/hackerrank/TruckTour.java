package licc.utils.questions.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 2015/7/14.
 */
public class TruckTour {
    /*
     * original solution
     */
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];
        int[] d = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = in.nextInt();
            d[(i + 1) % N] = in.nextInt();
        }
        int totalAmount;
        int i, j = 0;
        for (i = 0; i < N; ++i) {
            j = i;
            totalAmount = a[j];
            do {
                j = (j + 1) % N;
                totalAmount -= d[j];
                if (totalAmount < 0)
                    break;
                totalAmount += a[j];
            } while (j != i);

            if (j == i && totalAmount >= 0)
                break;
        }
        if (i < N)
            System.out.println(j);

    }

    /*
     * some optimization
     */
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] a = new int[N];
        int[] d = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = in.nextInt();
            d[(i + 1) % N] = in.nextInt();
        }
        int i = 0, j = (i + 1) % N, total = a[i] - d[j];
        while (j != i) {
            if (total < 0) {
                if (j > i) {
                    i = j;
                    j = (i + 1) % N;
                    total = a[i] - d[j];
                } else
                    break;
            } else {
                total += a[j];
                j = (j + 1) % N;
                total -= d[j];
            }

        }
        if (i == j && total >= 0)
            System.out.println(i);
    }

}
