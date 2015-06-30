package licc.utils.questions.hackerrank;

import java.util.Scanner;

/**
 * Created by user on 2015/6/30.
 */
public class LexicoMinMaxStr {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int k = in.nextInt();
        if (k >= input.length()) {
            System.out.println(input);
            System.out.println(input);
        } else {
            String min = input.substring(0, k);
            String max = input.substring(0, k);
            for (int i = 1; i < input.length() - k + 1; ++i) {
                String sub = input.substring(i, i + k);
                if (sub.compareTo(min) < 0)
                    min = sub;
                if (sub.compareTo(max) > 0)
                    max = sub;
            }
            System.out.println(min);
            System.out.println(max);
        }

    }
}
