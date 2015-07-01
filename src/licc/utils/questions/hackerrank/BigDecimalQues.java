package licc.utils.questions.hackerrank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by mengchenli on 2015/6/30.
 */
public class BigDecimalQues {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<BigDecimal> arr = new ArrayList<>();
        while (n-- > 0) {
            arr.add(in.nextBigDecimal());
        }
        Collections.sort(arr, new Comparator<BigDecimal>() {
            @Override
            public int compare(BigDecimal o1, BigDecimal o2) {
                //descending
                return o2.compareTo(o1);
            }
        });
        for (BigDecimal d : arr) {
            String out = d.toPlainString();
            if(out.startsWith("0."))
                out = out.substring(1);
            System.out.println(out);
        }
    }
}
