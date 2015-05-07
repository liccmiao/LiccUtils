package licc.utils.example.collections.maps;

import com.sun.org.apache.xml.internal.utils.MutableAttrListImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 2015/5/7.
 */
public class MapCounterTest {

    private String[] sArr;
    private static final long ITER_NUM = 1000 * 1000;

    @Before
    public void setUp() throws Exception {
        String s = "The last couple of months I have met several young developers that either looking for the first job or are still trying";
        sArr = s.split(" ");
    }

    @Test
    public void testMapCounterCompare() {
        long t1, t2;
        t1 = System.nanoTime();
        counterIntContainsKey();
        t2 = System.nanoTime();
        System.out.println("Integer-ContainsKey : " + (t2 - t1));

        t1 = System.nanoTime();
        counterMutIntContainsKey();
        t2 = System.nanoTime();
        System.out.println("MutableInteger-ContainsKey : " + (t2 - t1));

        t1 = System.nanoTime();
        counterMulIntPutKVSetV();
        t2 = System.nanoTime();
        System.out.println("MutableInteger-PutKVSetV : " + (t2 - t1));

        t1 = System.nanoTime();
        counterMutIntGetKey();
        t2 = System.nanoTime();
        System.out.println("MutableInteger-GetKey : " + (t2 - t1));

        t1 = System.nanoTime();
        counterAtomicIntGetKey();
        t2 = System.nanoTime();
        System.out.println("AtomicInteger-GetKey : " + (t2 - t1));

        t1 = System.nanoTime();
        counterIntArrGetKey();
        t2 = System.nanoTime();
        System.out.println("IntArray-GetKey : " + (t2 - t1));

    }

    private void counterIntContainsKey() {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < ITER_NUM; ++i) {
            for (String s : sArr) {
                if (m.containsKey(s)) {
                    Integer num = m.get(s);
                    m.put(s, num + 1);
                } else {
                    m.put(s, 1);
                }
            }
        }
    }

    private void counterMutIntContainsKey() {
        Map<String, MutableInteger> m = new HashMap<>();
        for (int i = 0; i < ITER_NUM; ++i) {
            for (String s : sArr) {
                if (m.containsKey(s)) {
                    MutableInteger num = m.get(s);
                    num.setValue(num.getValue() + 1);
                } else {
                    m.put(s, new MutableInteger(1));
                }
            }
        }

    }

    private void counterMulIntPutKVSetV() {
        Map<String, MutableInteger> m = new HashMap<>();
        for (int i = 0; i < ITER_NUM; ++i) {
            for (String s : sArr) {
                MutableInteger newValue = new MutableInteger(1);
                MutableInteger oldValue = m.put(s, newValue);
                if (oldValue != null) {
                    newValue.setValue(oldValue.getValue() + 1);
                }
            }
        }

    }

    private void counterMutIntGetKey() {
        Map<String, MutableInteger> m = new HashMap<>();
        for (int i = 0; i < ITER_NUM; ++i) {
            for (String s : sArr) {
                MutableInteger num = m.get(s);
                if (num != null) {
                    num.setValue(num.getValue() + 1);
                } else {
                    m.put(s, new MutableInteger(1));
                }
            }
        }

    }

    private void counterAtomicIntGetKey() {
        Map<String, AtomicInteger> m = new HashMap<>();
        for (int i = 0; i < ITER_NUM; ++i) {
            for (String s : sArr) {
                AtomicInteger num = m.get(s);
                if (num != null) {
                    num.incrementAndGet();
                } else {
                    m.put(s, new AtomicInteger(1));
                }
            }
        }

    }

    private void counterIntArrGetKey() {
        Map<String, int[]> m = new HashMap<>();
        for (int i = 0; i < ITER_NUM; ++i) {
            for (String s : sArr) {
                int[] arr = m.get(s);
                if (arr != null) {
                    arr[0]++;
                } else {
                    m.put(s, new int[]{1});
                }
            }
        }

    }

    class MutableInteger {
        private int value;

        public MutableInteger(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "MutableInteger{" +
                    "value=" + value +
                    '}';
        }
    }
}
