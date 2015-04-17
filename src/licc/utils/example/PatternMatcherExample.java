package licc.utils.example;

import java.util.regex.Pattern;

/**
 * Created by mengchenli on 2015/4/16.
 */
public class PatternMatcherExample {
    private static final Pattern PAT_TEST_LOST = Pattern.compile("\\w*I lost my (wallet|textbook|cellphone|hat)\\w*");

    public boolean matchLostPat(String input) {
        return PAT_TEST_LOST.matcher(input).matches();
    }

    public boolean matchLostPat(String regex, String input) {
        return input.matches(regex);
    }

}
