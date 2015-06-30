package licc.utils.questions.hackerrank;

import java.util.Scanner;

/**
 * Created by user on 2015/6/30.
 */
public class IPRegex {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new myRegex().pattern));
        }
    }
}

class myRegex {
    public String pattern = "(([0-1]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-1]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])";
}
