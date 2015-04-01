package licc.utils.example;

import org.junit.Test;

public class PassByValueTest {

    @Test
    public void testChange() throws Exception {
        String ori = "origin";
        PassByValue.change(ori);
        assert (ori.equals("origin"));
    }

    @Test
    public void testChange1() throws Exception {
        StringBuilder originSbr = new StringBuilder("origin");
        PassByValue.change(originSbr);
        assert (originSbr.toString().equals("origin"));
    }

    @Test
    public void testChange2() throws Exception {
        StringBuilder originSbr = new StringBuilder("origin");
        PassByValue.change2(originSbr);
        assert (originSbr.toString().equals("changed"));

    }
}