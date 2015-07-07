package licc.utils.questions.hackerrank;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by user on 2015/7/3.
 */
public class UniqPair {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            String line = in.nextLine();
            set.add(line);
            System.out.println(set.size());
        }

    }
}
