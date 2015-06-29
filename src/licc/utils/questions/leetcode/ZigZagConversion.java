package licc.utils.questions.leetcode;

/**
 * Created by mengchenli on 2015/6/26.
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1 || s.length() <= numRows)
            return s;
        StringBuilder[] sbrs = new StringBuilder[numRows];
        int[] index = new int[numRows];
        int[] gap = new int[numRows];

        for (int i = 0; i < numRows; ++i) {
            index[i] = i;
            gap[i] = 2 * (numRows - 1 - i);
            sbrs[i] = new StringBuilder("" + s.charAt(i));
        }

        boolean continueFlag = true;
        while (continueFlag) {

            for (int i = 0; i < numRows; ++i) {
                int gap1 = gap[i];
                int gap2 = 2 * numRows - 2 - gap1;

                if (gap1 != 0) {
                    index[i] += gap1;
                    if (index[i] < s.length())
                        sbrs[i].append(s.charAt(index[i]));
                    else
                        continueFlag = false;
                }

                if (gap2 != 0) {
                    index[i] += gap2;
                    if (index[i] < s.length())
                        sbrs[i].append(s.charAt(index[i]));
                    else
                        continueFlag = false;
                }

            }

        }

        for (int i = 1; i < numRows; ++i) {
            sbrs[0].append(sbrs[i].toString());
        }
        return sbrs[0].toString();
    }
}
