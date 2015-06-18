package licc.utils.questions.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by user on 2015/6/17.
 */
public class MaxUniqSubstrLength {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int maxLength = 0;
        int eraseIdx = 0;
        Map<Character, Integer> ch2IndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            Integer index = ch2IndexMap.get(ch);

            if (index != null) {
                //found replication
                if (maxLength < ch2IndexMap.size()) {
                    maxLength = ch2IndexMap.size();
                }
                removeLEValue(s, ch2IndexMap, eraseIdx, index);
                eraseIdx = index + 1;
            }
            ch2IndexMap.put(ch, i);
        }
        if (!ch2IndexMap.isEmpty() && ch2IndexMap.size() > maxLength)
            maxLength = ch2IndexMap.size();

        return maxLength;
    }

    private void removeLEValue(String s, Map<Character, Integer> m, int eraseIdx, int index) {
        for (int i = eraseIdx; i <= index; ++i) {
            m.remove(s.charAt(i));
        }
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int maxLength = 0;
        int beginIdx = 0;
        Map<Character, Integer> ch2IndexMap = new HashMap<>();
        int i;
        for (i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            Integer index = ch2IndexMap.get(ch);

            if (index != null && index >= beginIdx) {
                beginIdx = index + 1;
            }
            ch2IndexMap.put(ch, i);
            if (maxLength < (i - beginIdx + 1)) {
                maxLength = i - beginIdx + 1;
            }
        }
        if (i - beginIdx > maxLength)
            maxLength = i - beginIdx;

        return maxLength;
    }

}
