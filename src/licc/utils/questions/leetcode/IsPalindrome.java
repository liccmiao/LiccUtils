package licc.utils.questions.leetcode;

/**
 * Created by user on 2015/6/29.
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int rev = 0, ori = x;
        while (x > 0) {
            rev *= 10;
            rev += x % 10;
            x /= 10;
        }
        return rev == ori;
    }
}
