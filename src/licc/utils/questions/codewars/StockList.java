package licc.utils.questions.codewars;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengc_000 on 2015/7/23.
 */
public class StockList {

    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        // your code here
        if (lstOfArt == null || lstOf1stLetter == null) return "";
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) return "";
        Map<String, BigInteger> map = new HashMap<>();
        for (String str : lstOfArt) {
            String[] arr = str.split(" ");
            BigInteger bi = new BigInteger(arr[1]);
            String key = arr[0].substring(0, 1);
            BigInteger value = map.get(key);
            if (value != null)
                bi = bi.add(value);
            map.put(key, bi);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; ++i) {
            BigInteger v = map.get(lstOf1stLetter[i]);
            if (i != 0)
                sb.append(" - ");

            if (v != null) {
                sb.append("(" + lstOf1stLetter[i] + " : " + v.toString() + ")");
            } else {
                sb.append("(" + lstOf1stLetter[i] + " : 0)");
            }
        }

        return sb.toString();
    }
}
