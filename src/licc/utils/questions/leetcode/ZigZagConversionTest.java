package licc.utils.questions.leetcode;

import org.junit.Test;

public class ZigZagConversionTest {

    @Test
    public void testConvert() throws Exception {
        ZigZagConversion test = new ZigZagConversion();
        assert test.convert(null, 1) == null;
        assert test.convert("", 1).equals("");
        assert test.convert("a", 0).equals("a");
        assert test.convert("a", 1).equals("a");
        assert test.convert("ab", 3).equals("ab");
        assert test.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR");
        assert test.convert("PAYPALISHIRING", 2).equals("PYAIHRNAPLSIIG");
        assert test.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI");
    }
}