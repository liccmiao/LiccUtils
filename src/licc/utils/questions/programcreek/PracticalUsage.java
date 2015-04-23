package licc.utils.questions.programcreek;

import java.util.LinkedList;

/**
 * Created by mengchenli on 2015/4/22.
 */
public class PracticalUsage {

    /*
     * Java method for splitting a camelcase string
     * from http://www.programcreek.com/2011/03/java-method-for-spliting-a-camelcase-string/
     */
    public static LinkedList<String> splitCamelCaseString(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int index = 0;
        LinkedList<String> retList = new LinkedList<>();
        for (int i = 0, j = 1; j < s.length(); ++i, ++j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (Character.isLowerCase(ci) && Character.isUpperCase(cj)) {
                retList.add(s.substring(index, j));
                index = j;
            }
        }

        if (index < s.length()) {
            retList.add(s.substring(index));
        }

        return retList;
    }

}
