package licc.utils.questions.hackerrank;

import java.util.Scanner;

/**
 * Created by user on 2015/6/30.
 */
public class Loops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int a, b, n;
        while (t-- > 0) {
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();
            long pow = 1, sum = a;
            for (int i = 0; i < n; ++i) {
                sum += pow * b;
                pow *= 2;
                System.out.print(sum);
                if (i != n - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
