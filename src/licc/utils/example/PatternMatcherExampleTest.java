package licc.utils.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherExampleTest {
    private static final String LOST_STR_PRE = "I lost my ";
    private static final String LOST_STR_1 = LOST_STR_PRE + "wallet";
    private static final String LOST_STR_2 = LOST_STR_PRE + "cellphone";
    private static final String LOST_STR_3 = LOST_STR_PRE + "textbook";
    private static final String LOST_STR_4 = LOST_STR_PRE + "hat";

    private static final String LOST_STR_REGEX = "\\w*I lost my (wallet|cellphone|textbook|hat)\\w*";
    private static final int INPUT_NUM = 100 * 100;
    private static final Random r = new Random(37);

    @Test
    public void testMatchLostPat() throws Exception {
        PatternMatcherExample e = new PatternMatcherExample();
        assert (e.matchLostPat(LOST_STR_1));
        assert (e.matchLostPat(LOST_STR_2));
        assert (e.matchLostPat(LOST_STR_3));
        assert (e.matchLostPat(LOST_STR_4));

    }

    @Test
    public void testMatchLostPat1() throws Exception {
        PatternMatcherExample e = new PatternMatcherExample();
        assert (e.matchLostPat(LOST_STR_REGEX, LOST_STR_1));
        assert (e.matchLostPat(LOST_STR_REGEX, LOST_STR_2));
        assert (e.matchLostPat(LOST_STR_REGEX, LOST_STR_3));
        assert (e.matchLostPat(LOST_STR_REGEX, LOST_STR_4));

    }

    /*
     * matchesLostPat1 uses e.matchLostPat(String input), which use Pattern.matcher.matches
     * matchesLostPat2 uses e.matchLostPat(String regex, String input), which use String.matches
     * matchesLostPat1 uses a pre-compiled Pattern, while matchesLostPat2 compile the Pattern each time, so
     * matchesLostPat2 waste the time to compile a Pattern each time the method called.
     */
    @Test
    public void testMatchLostPatCompare() throws Exception {
        ArrayList<String> inputs = new ArrayList<>();
        for (int i = 0; i < INPUT_NUM; ++i) {
            inputs.add(genRandLostStr(i));
        }

        long t1 = System.nanoTime();
        matchesLostPat1(inputs);
        long t2 = System.nanoTime();
        System.out.println("t2-t1: " + (t2 - t1) / 1000000 * 1.0);

        t1 = System.nanoTime();
        matchesLostPat2(inputs);
        t2 = System.nanoTime();
        System.out.println("t2-t1: " + (t2 - t1) / 1000000 * 1.0);

    }

    @Test
    public void testFindGroup() throws Exception {
        String input = "I have a cat, but I like my dog better.";
        Pattern p = Pattern.compile("(cat|dog)");
        Matcher m = p.matcher(input);

        assert (m.groupCount() == 1);
        //first match
        assert (m.find());
        assert (m.start() == 9);
        assert (m.end() == 12);
        //second match
        assert (m.find());
        assert (m.start() == 28);
        assert (m.end() == 31);

    }

    /*
     * matcher.group(i) is the i-th subgroup of the matcher.group()
     * matcher.group() equals matcher.group(0)
     * for a pattern "(clientId=)(\\d+)"
     * group() or group(0) is the pattern itself or groups "(clientId=)(\\d+)"
     * group(1) is the pattern/group (clientId=)
     * group(2) is the pattern/group (\\d+)
     */
    @Test
    public void testGroupI() {
        String input = "User clientId=23421. Some more text clientId=33432. This clientNum=100";
        Pattern p = Pattern.compile("(clientId=)(\\d+)");
        Matcher m = p.matcher(input);
        assert (m.groupCount() == 2);
        assert (m.find());
        assert (m.group().equals(m.group(0)));
        assert (m.group(1).equals("clientId="));
        assert (m.group(2).equals("23421"));
        assert (m.find());
        assert (m.group().equals(m.group(0)));
        assert (m.group(1).equals("clientId="));
        assert (m.group(2).equals("33432"));

    }

    @Test
    public void testReplaceAll() {
        String input = "User clientId=23421. Some more text clientId=33432. This clientNum=100";
        Pattern p = Pattern.compile("(clientId=)(\\d+)");
        Matcher m = p.matcher(input);

        String res = "User ***mask***. Some more text ***mask***. This clientNum=100";
        assert (m.replaceAll("***mask***").equals(res));

    }

    /*
     * from http://www.ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-1/
     */
    @Test
    public void testAppendSBWithReplace() {
        String input = "User clientId=23421. Some more text clientId=33432. This clientNum=100";
        Pattern p = Pattern.compile("(clientId=)(\\d+)");
        Matcher m = p.matcher(input);

        StringBuffer br = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(br, m.group(1) + "***masked***");
        }
        m.appendTail(br);
        String res = "User clientId=***masked***. Some more text clientId=***masked***. This clientNum=100";
        assert (br.toString().equals(res));
    }

    /*
     * Back reference in java regular expressions
     * with the example we can see \\i where i has same meaning with i in Matcher.group(i)
     * can be used to reference a repeated pattern
     */
    @Test
    public void testBackRefWithRE() {
        Pattern p1 = Pattern.compile("(\\d\\d\\d)\\1");
        Matcher m1 = p1.matcher("123123");
        Matcher m2 = p1.matcher("123456");

        assert (m1.matches());
        assert (!m2.matches());

        Pattern p2 = Pattern.compile("\\b(\\w+)\\b[\\w\\W]*\\b\\1\\b");
        Matcher m3 = p2.matcher("unique is not duplicate but unique");
        Matcher m4 = p2.matcher("duplicate is duplicate");
        Matcher m5 = p2.matcher("duplicate is duplicate.");
        Matcher m6 = p2.matcher("Duplicate is duplicate");
        assert (m3.matches());
        assert (m4.matches());
        assert (!m5.matches());     // for the dot \\.
        assert (!m6.matches());     // for the UpperCase D

        Pattern p3 = Pattern.compile(Pattern.quote("\\d\\d\\d"));
        Matcher m7 = p3.matcher("\\d\\d\\d");       //literal \d\d\d
        assert m7.matches();
        Pattern p4 = Pattern.compile("\\\\d\\\\d\\\\d");    //same as p3
        Matcher m8 = p4.matcher("\\d\\d\\d");
        assert m8.matches();

    }

    private void matchesLostPat1(ArrayList<String> inputs) {
        PatternMatcherExample e = new PatternMatcherExample();
        int count = 0;
        for (String s : inputs) {
            if (e.matchLostPat(s)) {
                count++;
            }
            if (count != 0 && count % (INPUT_NUM / 2) == 0) {
                System.out.println("matches: " + count);
            }
        }
    }

    private void matchesLostPat2(ArrayList<String> inputs) {
        PatternMatcherExample e = new PatternMatcherExample();
        int count = 0;
        for (String s : inputs) {
            if (e.matchLostPat(LOST_STR_REGEX, s)) {
                count++;
            }
            if (count != 0 && count % (INPUT_NUM / 2) == 0) {
                System.out.println("matches: " + count);
            }
        }
    }

    private String genRandLostStr(int i) {
        String pfx;
        if (i % 4 == 0) {
            pfx = LOST_STR_1;
        } else if (i % 4 == 1) {
            pfx = LOST_STR_2;
        } else if (i % 4 == 2) {
            pfx = LOST_STR_3;
        } else {
            pfx = LOST_STR_4;
        }
        StringBuilder br = new StringBuilder();
        return "a" + r.nextInt(26) + "a" + r.nextInt(26) +
                "a" + r.nextInt(26) + "a" + r.nextInt(26) + "a" + r.nextInt(26) +
                pfx +
                "a" + r.nextInt(26) + "a" + r.nextInt(26) +
                "a" + r.nextInt(26) + "a" + r.nextInt(26) + "a" + r.nextInt(26);
    }
}