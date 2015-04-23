package licc.utils.questions.javavisited;

import org.junit.Test;

public class BinaryToDecimalTest {

    @Test
    public void testBinaryToDecimal() throws Exception {
        assert (BinaryToDecimal.binaryToDecimal(101) == 5);
        assert (BinaryToDecimal.binaryToDecimal(0) == 0);
        assert (BinaryToDecimal.binaryToDecimal(1) == 1);
        assert (BinaryToDecimal.binaryToDecimal(111) == 7);
        assert (BinaryToDecimal.binaryToDecimal(10111) == 23);
        assert (BinaryToDecimal.binaryToDecimal(1011) == 11);
    }
}