package licc.utils.questions.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengchenli on 2015/5/21.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return null;
        int[] ret = new int[2];
        int i, j;
        for (i = 0; i < nums.length; ++i) {
            for (j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i + 1;
                    ret[1] = j + 1;
                    break;
                }
            }
            if (j != nums.length)
                break;
        }
        return ret;
    }

    public static int[] twoSum_2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return null;
        Map<Integer, Integer> m = new HashMap<>(nums.length);

        int[] ret = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            Integer oldValue = m.put(nums[i], i + 1);
            if (oldValue != null)
                if (nums[i] * 2 == target) {
                    ret[0] = oldValue;
                    ret[1] = i + 1;
                }
        }

        if (ret[0] != 0 && ret[1] != 0)
            return ret;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] * 2 == target)
                continue;
            Integer t = m.get(target - nums[i]);
            if (t != null) {
                ret[0] = i + 1;
                ret[1] = t;
                break;
            }
        }
        return ret;
    }
}
