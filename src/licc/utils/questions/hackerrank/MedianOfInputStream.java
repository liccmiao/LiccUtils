package licc.utils.questions.hackerrank;

import java.util.Scanner;

/**
 * Created by user on 2015/7/14.
 */
public class MedianOfInputStream {
    /*
     * got timeout with this O(n^2) solution
     */
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            int k = in.nextInt();
            int j = i - 1;
            while (j >= 0 && k < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = k;
            //arr is in order
            if ((i & 0x1) == 0) {
                System.out.println(String.format("%.1f", arr[i / 2] * 1.0));
            } else {
                System.out.println(String.format("%.1f", (arr[i / 2] + arr[i / 2 + 1]) * 1.0 / 2));
            }
        }
    }


}
