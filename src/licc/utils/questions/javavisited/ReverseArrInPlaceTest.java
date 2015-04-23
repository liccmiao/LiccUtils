package licc.utils.questions.javavisited;

import org.junit.Test;

public class ReverseArrInPlaceTest {

    private static final int LEN = 10000;
    private int[] arr = new int[LEN];
    private int[] rev = new int[LEN];
    private int[] ori = new int[LEN];

    public ReverseArrInPlaceTest() {
        for (int i = 0; i < LEN; ++i) {
            arr[i] = i + 1;
            rev[i] = LEN - i;
            ori[i] = i + 1;
        }
    }

    @Test
    public void testReverseArr1() throws Exception {
        ReverseArrInPlace.reverseArr1(arr);
        for (int i = 0; i < LEN; ++i) {
            assert (arr[i] == rev[i]);
        }
        ReverseArrInPlace.reverseArr1(arr);
        for (int i = 0; i < LEN; ++i) {
            assert (arr[i] == ori[i]);
        }
        int[] testNull = null;
        int[] testEmpty = new int[0];
        ReverseArrInPlace.reverseArr1(testNull);
        ReverseArrInPlace.reverseArr1(testEmpty);
        assert(testNull == null);
        assert(testEmpty.length == 0);
    }

    @Test
    public void testReverseArr2() throws Exception {
        ReverseArrInPlace.reverseArr2(arr);
        for (int i = 0; i < LEN; ++i) {
            assert (arr[i] == rev[i]);
        }
        ReverseArrInPlace.reverseArr2(arr);
        for (int i = 0; i < LEN; ++i) {
            assert (arr[i] == ori[i]);
        }
        int[] testNull = null;
        int[] testEmpty = new int[0];
        ReverseArrInPlace.reverseArr1(testNull);
        ReverseArrInPlace.reverseArr1(testEmpty);
        assert(testNull == null);
        assert(testEmpty.length == 0);
    }
}