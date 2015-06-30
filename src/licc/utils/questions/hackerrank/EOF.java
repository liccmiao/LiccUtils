package licc.utils.questions.hackerrank;

import java.util.Scanner;

/**
 * Created by user on 2015/6/30.
 */
public class EOF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0;
        while (in.hasNext()) {
            String line = in.nextLine();
            System.out.println(++num + " " + line);
        }
        in.close();
    }
}
