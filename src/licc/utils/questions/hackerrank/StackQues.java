package licc.utils.questions.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mengc_000 on 2015/6/30.
 */
public class StackQues {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            System.out.println(isBalanced(line));
        }
    }

    private static boolean isBalanced(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[')
                s.push(ch);
            else {
                if (s.empty())
                    return false;
                if (!isPair(s.pop(), ch))
                    return false;
            }
        }
        if (!s.empty())
            return false;
        return true;
    }

    private static boolean isPair(char a, char b) {
        return (a == '{' && b == '}') || (a == '[' && b == ']') || (a == '(' && b == ')');
    }
}
