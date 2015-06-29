package licc.utils.questions.leetcode;

import org.junit.Test;

public class IsPalindromeTest {

    @Test
    public void testIsPalindrome() throws Exception {
        IsPalindrome test = new IsPalindrome();
        assert test.isPalindrome(0);
        assert test.isPalindrome(1);
        assert !test.isPalindrome(-1);
        assert !test.isPalindrome(12345);
        assert test.isPalindrome(12321);
        assert !test.isPalindrome(1234567);
        assert test.isPalindrome(1234321);
        assert test.isPalindrome(123321);

    }
}