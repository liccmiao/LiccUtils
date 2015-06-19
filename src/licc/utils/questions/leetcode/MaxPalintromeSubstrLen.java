package licc.utils.questions.leetcode;

/**
 * Created by mengchenli on 2015/6/19.
 */
public class MaxPalintromeSubstrLen {
    public int getMaxLenPlnsub1(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        if (len == 1) return 1;

        for (int k = len; k > 1; k--) {
            for (int i = 0; i < len - k + 1; ++i) {
                if (isPalintrome(s, i, i + k - 1))
                    return k;
            }
        }
        return 1;
    }

    public String getLongestPlnsubStr1(String s) {
        if (s == null || s.isEmpty()) return s;
        int len = s.length();
        if (len == 1) return s;

        for (int k = len; k > 1; k--) {
            for (int i = 0; i < len - k + 1; ++i) {
                if (isPalintrome(s, i, i + k - 1))
                    return s.substring(i, i + k);

            }
        }
        return "" + s.charAt(0);
    }

    private boolean isPalintrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }

    public int getMaxLenPlnsub2(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        if (len == 1) return 1;

        int[] LPS = new int[1000];
        LPS[0] = 1;
        for (int i = 1; i < len; ++i) {
            int k = LPS[i - 1];
            LPS[i] = k;
            if (isPalintrome(s, i - k, i))
                LPS[i] = k + 1;

            if (isPalintrome(s, i - k, i - 1) && (i - k - 1 >= 0 && s.charAt(i - k - 1) == s.charAt(i)))
                LPS[i] = k + 2;
        }

        return LPS[len - 1];
    }

    public String getLongestPlnsubStr2(String s) {
        if (s == null || s.isEmpty()) return s;
        int len = s.length();
        if (len == 1) return s;

        int[] LPSLen = new int[1000];
        String LPS;
        LPSLen[0] = 1;
        LPS = s.substring(0, 1);
        for (int i = 1; i < len; ++i) {
            int k = LPSLen[i - 1];
            LPSLen[i] = k;
            if (isPalintrome(s, i - k, i)) {
                LPSLen[i] = k + 1;
                LPS = s.substring(i - k, i + 1);
            }

            if (isPalintrome(s, i - k, i - 1) && (i - k - 1 >= 0 && s.charAt(i - k - 1) == s.charAt(i))) {
                LPSLen[i] = k + 2;
                LPS = s.substring(i - k - 1, i + 1);
            }
        }

        return LPS;
    }
}
