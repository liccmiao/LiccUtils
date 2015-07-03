package licc.utils.questions.hackerrank;

import java.util.Scanner;

/**
 * Created by user on 2015/7/2.
 */
public class TwoDArrayGame {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int[][] a = new int[6][6];

        for (int i = 0; i < 6; ++i) {
            a[i] = new int[6];
            for (int j = 0; j < 6; ++j) {
                a[i][j] = in.nextInt();
            }
        }
        int max = -63;  //min is -9 * 7 since "Each integer will be between -9 and 9 inclusive."
        for (int i = 0; i <= 3; ++i) {
            for (int j = 0; j <= 3; ++j) {
                int sum = a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 1] + a[i + 2][j] + a[i + 2][j + 1] + a[i + 2][j + 2];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
