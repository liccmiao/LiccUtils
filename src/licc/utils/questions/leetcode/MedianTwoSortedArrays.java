package licc.utils.questions.leetcode;

/**
 * Created by mengchenli on 2015/6/19.
 */
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if ((n + m) % 2 == 1) {
            return getKthTwoSortedArrays(nums1, 0, n, nums2, 0, m, (n + m) / 2 + 1);
        } else {
            int k1 = getKthTwoSortedArrays(nums1, 0, n, nums2, 0, m, (n + m) / 2);
            int k2 = getKthTwoSortedArrays(nums1, 0, n, nums2, 0, m, (n + m) / 2 + 1);
            return (k1 + k2) * 1.0 / 2;
        }
    }

    private int getKthTwoSortedArrays(int[] n, int n_begin, int n_end, int[] m, int m_begin, int m_end, int k) {
        if (n_end - n_begin > m_end - m_begin)
            return getKthTwoSortedArrays(m, m_begin, m_end, n, n_begin, n_end, k);
        if (n_end == n_begin)
            return m[m_begin + k - 1];
        if (k == 1) {
            return Math.min(n[n_begin], m[m_begin]);
        }

        int n_num = Math.min(k / 2, n_end - n_begin), m_num = (k - n_num);
        int x = n[n_begin + n_num - 1], y = m[m_begin + m_num - 1];
        if (x == y)
            return x;
        else if (x < y)
            return getKthTwoSortedArrays(n, n_begin + n_num, n_end, m, m_begin, m_end, m_num);
        else
            return getKthTwoSortedArrays(n, n_begin, n_end, m, m_begin + m_num, m_end, n_num);

    }
}
