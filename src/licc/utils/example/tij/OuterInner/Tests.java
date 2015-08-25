package licc.utils.example.tij.OuterInner;

/**
 * Created by mengc_000 on 2015/8/23.
 */
public class Tests {

    public static void main1(String[] args) {
        MethodInner m = new MethodInner();
        m.getInner().test();
        m.getInner2().test();
    }

    public static void main2(String[] args) {
        MethodInner m = new MethodInner();
        MyInterface itf = m.getPInner();
//        cannot access MethodInner.PInner
//        MethodInner.PInner p = (PInner)itf;
        itf.test();
    }

    public static void main3(String[] args) {
        SupportUses su = new SupportUses(37);
        su.dump();
        MethodInner m = new MethodInner();
        m.getAnonymousSupportUses(37).dump();
    }
}
