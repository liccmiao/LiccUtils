package licc.utils.questions.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mengchenli on 2015/7/4.
 */
public class ArrayListQues {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> xArr = new ArrayList<>();
        while (n-- > 0) {
            int d = in.nextInt();
            ArrayList<Integer> yArr = new ArrayList<>();
            while (d-- > 0) {
                yArr.add(in.nextInt());
            }
            xArr.add(yArr);
        }
        int q = in.nextInt();
        while (q-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (x > 0 && x <= xArr.size()) {
                ArrayList<Integer> yArr = xArr.get(x - 1);
                if (y > 0 && y <= yArr.size())
                    System.out.println(yArr.get(y - 1));
                else
                    System.out.println("ERROR!");
            } else
                System.out.println("ERROR!");
        }

    }
}
