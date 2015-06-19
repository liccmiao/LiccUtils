package licc.utils.questions.leetcode;

import org.junit.Test;

public class MaxPalintromeSubstrLenTest {
    String tmp = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    int tmpLen = 400;

    @Test
    public void testGetMaxLenPlnsub1() throws Exception {
        MaxPalintromeSubstrLen test = new MaxPalintromeSubstrLen();
        long t1 = System.nanoTime();
        assert test.getMaxLenPlnsub1(null) == 0;
        assert test.getMaxLenPlnsub1("") == 0;
        assert test.getMaxLenPlnsub1("s") == 1;
        assert test.getMaxLenPlnsub1("ss") == 2;
        assert test.getMaxLenPlnsub1("saa") == 2;
        assert test.getMaxLenPlnsub1("sasas") == 5;
        assert test.getMaxLenPlnsub1("aaaaaaaaaa") == 10;
        assert test.getMaxLenPlnsub1("abccbaabcc") == 8;
        assert test.getMaxLenPlnsub1(tmp) == tmpLen;
        long t2 = System.nanoTime();
        System.out.println("len1:" + (t2 - t1));
    }

    @Test
    public void testGetMaxLenPlnsubStr1() throws Exception {
        MaxPalintromeSubstrLen test = new MaxPalintromeSubstrLen();
        long t1 = System.nanoTime();
        assert test.getLongestPlnsubStr1(null) == null;
        assert test.getLongestPlnsubStr1("").equals("");
        assert test.getLongestPlnsubStr1("s").equals("s");
        assert test.getLongestPlnsubStr1("ss").equals("ss");
        assert test.getLongestPlnsubStr1("saa").equals("aa");
        assert test.getLongestPlnsubStr1("sasas").equals("sasas");
        assert test.getLongestPlnsubStr1("aaaaaaaaaa").equals("aaaaaaaaaa");
        assert test.getLongestPlnsubStr1("abccbaabcc").equals("ccbaabcc");
        assert test.getLongestPlnsubStr1(tmp).equals(tmp);
        long t2 = System.nanoTime();
        System.out.println("str1:" + (t2 - t1));
    }

    @Test
    public void testGetMaxLenPlnsub2() throws Exception {
        MaxPalintromeSubstrLen test = new MaxPalintromeSubstrLen();
        long t1 = System.nanoTime();
        assert test.getMaxLenPlnsub2("") == 0;
        assert test.getMaxLenPlnsub2("s") == 1;
        assert test.getMaxLenPlnsub2("ss") == 2;
        assert test.getMaxLenPlnsub2("saa") == 2;
        assert test.getMaxLenPlnsub2("sasas") == 5;
        assert test.getMaxLenPlnsub2("aaaaaaaaaa") == 10;
        assert test.getMaxLenPlnsub2("abccbaabcc") == 8;
        assert test.getMaxLenPlnsub2(tmp) == tmpLen;
        long t2 = System.nanoTime();
        System.out.println("len2:" + (t2 - t1));
    }

    @Test
    public void testGetMaxLenPlnsubStr2() throws Exception {
        MaxPalintromeSubstrLen test = new MaxPalintromeSubstrLen();
        long t1 = System.nanoTime();
        assert test.getLongestPlnsubStr2(null) == null;
        assert test.getLongestPlnsubStr2("").equals("");
        assert test.getLongestPlnsubStr2("s").equals("s");
        assert test.getLongestPlnsubStr2("ss").equals("ss");
        assert test.getLongestPlnsubStr2("saa").equals("aa");
        assert test.getLongestPlnsubStr2("sasas").equals("sasas");
        assert test.getLongestPlnsubStr2("aaaaaaaaaa").equals("aaaaaaaaaa");
        assert test.getLongestPlnsubStr2("abccbaabcc").equals("ccbaabcc");
        assert test.getLongestPlnsubStr2(tmp).equals(tmp);
        long t2 = System.nanoTime();
        System.out.println("str2:" + (t2 - t1));
    }

}