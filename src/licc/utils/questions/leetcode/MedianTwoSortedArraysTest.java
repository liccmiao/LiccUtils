package licc.utils.questions.leetcode;

import org.junit.Test;

public class MedianTwoSortedArraysTest {

    @Test
    public void testFindMedianSortedArrays() throws Exception {
        MedianTwoSortedArrays test = new MedianTwoSortedArrays();
        int[] a = {1};
        int[] b = {};
        assert test.findMedianSortedArrays(a, b) == 1;

        a = new int[]{};
        b = new int[]{1};
        assert test.findMedianSortedArrays(a, b) == 1;
        a = new int[]{1};
        b = new int[]{2};
        assert test.findMedianSortedArrays(a, b) == 1.5;
        a = new int[]{1, 1};
        b = new int[]{2};
        assert test.findMedianSortedArrays(a, b) == 1;
        a = new int[]{1};
        b = new int[]{2, 2};
        assert test.findMedianSortedArrays(a, b) == 2;

        a = new int[]{1, 2, 3, 3};
        b = new int[]{5};
        assert test.findMedianSortedArrays(a, b) == 3;
        a = new int[]{1, 2, 3, 4};
        b = new int[]{5, 6, 7, 8};
        assert test.findMedianSortedArrays(a, b) == 4.5;

        a = new int[]{1};
        b = new int[]{2, 3, 4, 5, 6};
        assert test.findMedianSortedArrays(a, b) == 3.5;
    }
}