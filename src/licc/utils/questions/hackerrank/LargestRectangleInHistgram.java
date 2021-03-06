package licc.utils.questions.hackerrank;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by user on 2015/7/13.
 */
public class LargestRectangleInHistgram {
    /*
     * original solution
     */
    public static void main1(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] hisgram = new int[N + 1];
        int[] leftAdjMinIdx = new int[N + 1];
        int[] rightAdjMinIdx = new int[N + 1];
        Deque<Integer> lIdxStack = new ArrayDeque<>();
        Deque<Integer> rIdxStack = new ArrayDeque<>();

        for (int i = 1; i <= N; ++i) {
            //default
            leftAdjMinIdx[i] = 0;
            rightAdjMinIdx[i] = N + 1;
            //input
            hisgram[i] = in.nextInt();
            //left
            while (!lIdxStack.isEmpty() && hisgram[i] <= hisgram[lIdxStack.peek()])
                lIdxStack.pop();

            if (lIdxStack.isEmpty()) {
                leftAdjMinIdx[i] = 0;
                lIdxStack.push(i);
            } else {
                leftAdjMinIdx[i] = lIdxStack.peek();
                lIdxStack.push(i);
            }
            //right
            if (rIdxStack.isEmpty() || hisgram[i] >= hisgram[rIdxStack.peek()])
                rIdxStack.push(i);
            else {
                while (!rIdxStack.isEmpty() && hisgram[i] < hisgram[rIdxStack.peek()]) {
                    rightAdjMinIdx[rIdxStack.pop()] = i;
                }
                rIdxStack.push(i);
            }
        }
        int largest = 0;
        int area;
        for (int i = 1; i <= N; ++i) {
            area = hisgram[i] * (rightAdjMinIdx[i] - leftAdjMinIdx[i] - 1);
            if (area > largest)
                largest = area;
        }
        System.out.println(largest);
    }

    /*
     * some optimization
     */
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N + 1];
        Deque<Integer> sIndex = new ArrayDeque<>();


        for (int i = 0; i < N; ++i) {
            arr[i] = in.nextInt();
        }
        int largest = 0;
        arr = Arrays.copyOf(arr, arr.length + 1);
        for (int i = 0; i < N; ++i) {
            while (!sIndex.isEmpty() && arr[i] <= arr[sIndex.peek()]) {
                int left = sIndex.pop();
                largest = Math.max(largest, arr[left] * (i - (sIndex.isEmpty() ? 0 : (sIndex.peek() + 1))));
            }
            sIndex.push(i);
        }

        System.out.println(largest);
    }
}
