package licc.utils.questions.hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2015/6/30.
 */
public class WordToken {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String input = new Scanner(System.in).nextLine();
        Pattern p = Pattern.compile("[A-Za-z]+");
        Matcher m = p.matcher(input);
        StringBuffer sbr = new StringBuffer();
        int cnt = 0;
        String linesep = System.getProperty("line.separator");
        while (m.find()) {
            cnt++;
            sbr.append(m.group() + linesep);
        }
        System.out.println(cnt);
        System.out.println(sbr.toString());
    }
}
