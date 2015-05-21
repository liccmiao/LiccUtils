package licc.utils.questions.leetcode;

import org.junit.Test;

public class TwoSumTest {

    @Test
    public void testTwoSum() throws Exception {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = TwoSum.twoSum(numbers, target);
        assert res[0] == 1;
        assert res[1] == 2;
        numbers = new int[]{3, 2, 4};
        target = 6;
        res = TwoSum.twoSum(numbers, target);
        assert res[0] == 2;
        assert res[1] == 3;
    }

    @Test
    public void testTwoSum_2() throws Exception{
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = TwoSum.twoSum_2(numbers, target);
        assert res[0] == 1;
        assert res[1] == 2;
        numbers = new int[]{3, 2, 4};
        target = 6;
        res = TwoSum.twoSum_2(numbers, target);
        assert res[0] == 2;
        assert res[1] == 3;
        numbers = new int[]{0,4,3,0};
        target = 0;
        res = TwoSum.twoSum_2(numbers,target);
        assert res[0] == 1;
        assert res[1] == 4;
    }
}