package licc.utils.questions.leetcode;

/**
 * Created by user on 2015/6/29.
 */
public class MyAtoI {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty() || str.trim().isEmpty())
            return 0;
        str = str.trim();
        int idx = 0;
        boolean neg = false;
        char ch = str.charAt(idx);
        long ret = 0;
        if (ch == '+')
            idx++;
        if (ch == '-') {
            idx++;
            neg = true;
        }
        while (idx < str.length()) {
            ch = str.charAt(idx);
            if (ch < '0' || ch > '9')
                break;
            ret *= 10;
            ret += (ch - '0');
            idx++;
            if(ret > Integer.MAX_VALUE)
                break;
        }
        if (neg)
            ret = -ret;
        if (ret > Integer.MAX_VALUE)
            ret = Integer.MAX_VALUE;
        if (neg && ret < Integer.MIN_VALUE)
            ret = Integer.MIN_VALUE;

        return (int) ret;
    }
}
