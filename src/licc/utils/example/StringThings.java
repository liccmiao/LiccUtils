package licc.utils.example;


import java.nio.charset.Charset;
import java.util.Locale;

/**
 * Created by mengchenli on 2015/4/3.
 */
public class StringThings {
    private static final String TEST_STR = "a test string";

    public static void stringThings() {
        byte[] bytes = new byte[]{97, 56, 32};
        char[] chars = new char[]{'a', ' ', '#' };
        //string(byte[] bytes) 通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。
        System.out.println(new String(bytes));
        //string( byte[] bytes, Charset charset) 通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。
        System.out.println(new String(bytes, Charset.defaultCharset()));
        //string( char[] value) 分配一个新的 string，使其表示字符数组参数中当前包含的字符序列。
        System.out.println(new String(chars));
        //char charat ( int index) 返回指定索引处的 char 值。
        System.out.println(TEST_STR.charAt(0));
        //int codepointat ( int index) 返回指定索引处的字符（unicode 代码点）。
        System.out.println(TEST_STR.codePointAt(0));
        //int compareto (string anotherstring) 按字典顺序比较两个字符串。
        System.out.println(TEST_STR.compareTo(TEST_STR));
        //int comparetoignorecase (string str) 按字典顺序比较两个字符串，不考虑大小写。
        System.out.println(TEST_STR.compareToIgnoreCase(TEST_STR.toUpperCase()));
        //string concat (string str) 将指定字符串连接到此字符串的结尾。
        System.out.println(TEST_STR.concat("CONCAT"));
        //boolean contains (charsequence s)  当且仅当此字符串包含指定的 char 值序列时，返回 true。
        System.out.println(TEST_STR.contains("test"));
        //boolean contentequals (charsequence cs) 将此字符串与指定的 charsequence 比较。
        System.out.println(TEST_STR.contentEquals("test"));
        //static string copyvalueof ( char[] data) 返回指定数组中表示该字符序列的 string。
        System.out.println(String.copyValueOf(chars));
        //boolean endswith (string suffix) 测试此字符串是否以指定的后缀结束。
        System.out.println(TEST_STR.endsWith("ing"));
        //static string format (locale l, string format, object...args)使用指定的语言环境、格式字符串和参数返回一个格式化字符串。
        System.out.println(String.format(Locale.ENGLISH, "a string: %s", TEST_STR));
        //byte[] getbytes () 使用平台的默认字符集将此 string 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
        System.out.println(TEST_STR.getBytes());
        // void getchars ( int srcbegin, int srcend, char[] dst, int dstbegin)将字符从此字符串复制到目标字符数组。
        char[] chars2 = new char[5];
        TEST_STR.getChars(0, 4, chars2, 0);
        System.out.println(String.copyValueOf(chars2));
        //int hashcode () 返回此字符串的哈希码。
        System.out.println(TEST_STR.hashCode());
        //int indexof ( int ch) 返回指定字符在此字符串中第一次出现处的索引。
        System.out.println(TEST_STR.indexOf('s'));
        //boolean isempty () 当且仅当 length () 为 0 时返回 true。
        System.out.println("".isEmpty());
        //int lastindexof ( int ch) 返回指定字符在此字符串中最后一次出现处的索引。
        System.out.println(TEST_STR.lastIndexOf(' '));
        //boolean matches (string regex) 告知此字符串是否匹配给定的正则表达式。
        System.out.println(TEST_STR.matches("[a-z]+"));
        //int offsetbycodepoints ( int index, int codepointoffset)返回此 string 中从给定的 index 处偏移 codepointoffset 个代码点的索引。
        System.out.println(TEST_STR.offsetByCodePoints(0, 2));
        //boolean regionmatches ( int toffset, string other,int ooffset, int len) 测试两个字符串区域是否相等。
        System.out.println("s1-我:" + "s1".regionMatches(0, "我", 0, 2));
        //string replace (charsequence target, charsequence replacement) 使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
        System.out.println(TEST_STR.replace("test", "aaaa"));
        //string replaceall (string regex, string replacement) 使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
        System.out.println(TEST_STR.replaceAll("\\s+", "1"));
        //string replacefirst (string regex, string replacement) 使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
        System.out.println(TEST_STR.replaceFirst("\\s+", "1"));
        //string[] split (string regex) 根据给定正则表达式的匹配拆分此字符串。
        System.out.println(TEST_STR.split("\\s+"));
        // boolean startswith (string prefix) 测试此字符串是否以指定的前缀开始。
        System.out.println(TEST_STR.startsWith("a"));
        //charsequence subsequence ( int beginindex, int endindex) 返回一个新的字符序列，它是此序列的一个子序列。
        System.out.println(TEST_STR.subSequence(1, 4));
        //string substring ( int beginindex, int endindex) 返回一个新的字符串，它是此字符串的一个子字符串。
        System.out.println(TEST_STR.substring(1, 4));
        //   char[] tochararray () 将此字符串转换为一个新的字符数组。
        System.out.println(TEST_STR.toCharArray());
    }
}
