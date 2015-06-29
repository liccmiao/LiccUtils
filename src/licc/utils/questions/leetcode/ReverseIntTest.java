package licc.utils.questions.leetcode;

import org.junit.Test;

public class ReverseIntTest {

    @Test
    public void testReverse() throws Exception {
        ReverseInt test = new ReverseInt();
        assert test.reverse(0) == 0;
        assert test.reverse(100) == 1;
        assert test.reverse(1) == 1;
        assert test.reverse(123) == 321;
        assert test.reverse(-1) == -1;
        assert test.reverse(-123) == -321;
        assert test.reverse(Integer.MAX_VALUE) == 0;
        assert test.reverse(1563847412) == 0;
        assert test.reverse(Integer.MIN_VALUE) == 0;
        assert test.reverse(-1463847412) == -2147483641;
    }
}