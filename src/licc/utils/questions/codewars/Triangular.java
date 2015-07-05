package licc.utils.questions.codewars;

import org.junit.Test;

import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * Created by mengc_000 on 2015/7/5.
 */
public class Triangular {
    public static int triangular(int n) {
        if (n <= 0)
            return 0;
        long res = 0;
        for (int i = 1; i <= n; ++i) {
            res += i;
            if (res > Integer.MAX_VALUE)
                return 0;
        }
        return (int) res;
    }

    @Test
    public void testTriangular() {
        assert triangular(2) == 3;
        assert triangular(3) == 6;
        assert triangular(0) == 0;
        assert triangular(100) == 5050;
        assert triangular(-1) == 0;
        assert triangular(Integer.MAX_VALUE) == 0;
    }
}
