package licc.utils.questions.leetcode;

/**
 * Created by mengchenli on 2015/6/29.
 */
public class ReverseInt {
    public int reverse(int x) {
        final int MAX_INTEGER_LEN = 10;
        long x_l = x;
        boolean neg = false;
        if (x_l < 0) {
            neg = true;
            x_l = -x_l;
        }
        short[] nums = new short[MAX_INTEGER_LEN + 1];  //MAX_INTGER_LEN = 10;
        int idx = 0;
        while (x_l > 0) {
            nums[idx++] = (short) (x_l % 10);
            x_l /= 10;
        }

        x_l = 0;
        int i = 0;
        while (i < idx) {
            x_l *= 10;
            x_l += nums[i++];
        }
        if (neg)
            x_l = -x_l;
        if (x_l > Integer.MAX_VALUE || x_l < Integer.MIN_VALUE)
            return 0;

        return (int) x_l;
    }
}
