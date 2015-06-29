package licc.utils.questions.leetcode;

import org.junit.Test;

import java.util.Iterator;

public class MyAtoITest {

    @Test
    public void testMyAtoi() throws Exception {
        MyAtoI test = new MyAtoI();
        assert test.myAtoi(null) == 0;
        assert test.myAtoi("") == 0;
        assert test.myAtoi("0") == 0;
        assert test.myAtoi("0a") == 0;
        assert test.myAtoi("123aa1") == 123;
        assert test.myAtoi("2147483647") == Integer.MAX_VALUE;
        assert test.myAtoi("2147483648") == Integer.MAX_VALUE;
        assert test.myAtoi("2222222222") == Integer.MAX_VALUE;
        assert test.myAtoi("9223372036854775809") == Integer.MAX_VALUE;
        assert test.myAtoi("+0") == 0;
        assert test.myAtoi("+1234") == 1234;
        assert test.myAtoi("+a") == 0;
        assert test.myAtoi("-1") == -1;
        assert test.myAtoi("-1ab") == -1;
        assert test.myAtoi("-321") == -321;
        assert test.myAtoi("a1") == 0;
        assert test.myAtoi("-0a") == 0;
        assert test.myAtoi("-2147483648") == Integer.MIN_VALUE;
        assert test.myAtoi("-2147483647") == Integer.MIN_VALUE + 1;
        assert test.myAtoi("-2147483649") == Integer.MIN_VALUE;
        assert test.myAtoi("-2222222222") == Integer.MIN_VALUE;
    }
}