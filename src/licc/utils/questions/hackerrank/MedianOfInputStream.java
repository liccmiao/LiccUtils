package licc.utils.questions.hackerrank;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
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

    /**
     * use two heaps
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Comparator<Integer> reverseCpt = Collections.reverseOrder();
        PriorityQueue<Integer> h1Max = new PriorityQueue<>((N + 1) / 2, reverseCpt);
        PriorityQueue<Integer> h2Min = new PriorityQueue<>(N - (N + 1) / 2);

        for (int i = 0; i < N; ++i) {
            int k = in.nextInt();
            if ((i & 0x01) == 0) {
                if (h2Min.isEmpty() || k <= h2Min.peek())
                    h1Max.offer(k);
                else {
                    h1Max.offer(h2Min.poll());
                    h2Min.offer(k);
                }
                // get h1.peek as the i/2+1 th element
                System.out.println(String.format("%.1f", h1Max.peek() * 1.0f));
            } else {
                if (h1Max.isEmpty() || k >= h1Max.peek())
                    h2Min.offer(k);
                else {
                    h2Min.offer(h1Max.poll());
                    h1Max.offer(k);
                }
                //get h1.peek as the i/2+1 th element
                //get h2.peek as the i/2+2 th element
                System.out.println(String.format("%.1f", (h1Max.peek() + h2Min.peek()) * 1.0f / 2));
            }
        }

    }

}
