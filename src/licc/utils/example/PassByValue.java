package licc.utils.example;

/**
 * Created by mengchenli on 2015/4/1.
 */
public class PassByValue {
    /*
     * for change(String s)         won't change the original value passed to parameter s
     * for change(StringBuilder sb)     won't change
     * for change2(StringBuilder sb)    change the original object
     * when we talk about java 's pass-by-value for method calling and parameter passing,
     * the original variable 's value is passed, so the parameter (e.g s and sb here) get the value of the reference of object
     * but the variable itself is not the reference, its value is the reference
     * here when we use s = "changed", or sb = new StringBuilder("changed"), these two actions have the same meaning, which
     * is to change the parameter 's value to a new reference of some object, while the original value is not changed
     * but when we use sb.delete or sb.append, we changed the value outside the method(here is change2), and then cause the original value outside.
     * This is a confusing example for someone, since the String 's immutability and java's pass-by-value appear at same time.
     *
     * BTW, if the String Class is not immutable, we can use some method like this to change the original value:
     * s.changeContent("changed")
     * but String is immutable in java, so we can't do it.
     */
    public static void change(String s) {
        s = "changed";
    }

    public static void change(StringBuilder sb) {
        sb = new StringBuilder("changed");
    }

    public static void change2(StringBuilder sb) {
        sb.delete(0, sb.length()).append("changed");
    }
}
