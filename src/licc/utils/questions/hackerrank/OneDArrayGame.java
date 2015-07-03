package licc.utils.questions.hackerrank;

import java.util.Scanner;

/**
 * Created by user on 2015/7/2.
 * from https://www.hackerrank.com/challenges/java-1d-array
 */
public class OneDArrayGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        boolean[] b, B;
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            b = new boolean[n];
            B = new boolean[n];

            for (int i = 0; i < n; ++i) {
                b[i] = in.nextInt() == 0;
                B[i] = false;
            }

            if (m >= n) {
                System.out.println("YES");
                continue;
            }

            B[0] = true;
            boolean changed;
            do {
                changed = false;
                for (int i = 0; i < n; ++i) {
                    if (B[i]) {
                        if (i - 1 >= 0 && b[i - 1] && !B[i - 1]) {
                            B[i - 1] = true;
                            changed = true;
                        }

                        if (i + 1 < n && b[i + 1] && !B[i + 1]) {
                            B[i + 1] = true;
                            changed = true;
                        }

                        if (i + m < n && b[i + m] && !B[i + m]) {
                            B[i + m] = true;
                            changed = true;
                        }
                    }
                }
            } while (changed);

            boolean flag = false;
            for (int i = n - m; i < n; ++i) {
                if (B[i]) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
