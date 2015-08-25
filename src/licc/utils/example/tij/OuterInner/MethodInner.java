package licc.utils.example.tij.OuterInner;

/**
 * Created by mengc_000 on 2015/8/23.
 */
public class MethodInner {

    public class TestInner {
        public class TestInnerInner {
        }
    }

    public static class TestSInner {
        public static class TestSInnerSInner {
        }
    }


    public MyInterface getInner() {
        class Inner implements MyInterface {
            @Override
            public void test() {
                System.out.println("in MethodInner.getInner().Inner.test()");
            }
        }
        return new Inner();
    }

    public MyInterface getInner2() {
        return new MyInterface() {
            @Override
            public void test() {
                System.out.println("in MethodInner.getInner2().AnonymousClass.test()");
            }
        };
    }

    private class PInner implements MyInterface {
        @Override
        public void test() {
            System.out.println("in MethodInner.PInner.test()");
        }
    }

    public MyInterface getPInner() {
        return new PInner();
    }

    public SupportUses getAnonymousSupportUses(final int i) {
        return new SupportUses(i) {
            private int value = i;

            @Override
            public void dump() {
                System.out.println("In MethodInner.getAnonymousSupportUses(i).AnonymousClass.dump: " + (i + 1));
            }
        };
    }
}
