package licc.utils.questions.codewars;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by mengc_000 on 2015/7/5.
 */
public class DigPow {
    public static long digPow(int n, int p) {
        // your code
        short[] digits = new short[11];    //max len integer.max is 10
        int idx = 0;
        int num = n;
        while (num > 0) {
            digits[idx++] = (short) (num % 10);
            num /= 10;
        }
        long pows = 0;
        for (int i = 0; i < idx; ++i) {
            pows += (long) Math.pow(digits[i], p + idx - 1 - i);
        }
        long k = pows / n;
        if (k * n != pows)
            return -1;
        else
            return k;
    }

    @Test
    public void testDigPow() {
        assert 1 == DigPow.digPow(89, 1);
        assert -1 == DigPow.digPow(92, 1);
        assert 2 == DigPow.digPow(695, 2);
        assert 51 == DigPow.digPow(46288, 3);
    }
}
