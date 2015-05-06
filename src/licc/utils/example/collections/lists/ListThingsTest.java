package licc.utils.example.collections.lists;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class ListThingsTest {

    private static final int TEST_INPUT_LEN = 1000;

    @Test
    public void testLinkedListVsArrayList() {
        Random r = new Random(37);
        int[] randInts = new int[TEST_INPUT_LEN];
        for (int i = 0; i < randInts.length; ++i)
            randInts[i] = r.nextInt();

        List<Integer> ll = new LinkedList<>();
        List<Integer> al = new ArrayList<>(randInts.length);

        long t1, t2;
        t1 = System.nanoTime();
        for (int i = 0; i < randInts.length; ++i)
            ll.add(randInts[i]);
        t2 = System.nanoTime();
        System.out.println("ll add last: " + (t2 - t1));

        t1 = System.nanoTime();
        for (int i = 0; i < randInts.length; ++i)
            al.add(randInts[i]);
        t2 = System.nanoTime();
        System.out.println("al add last: " + (t2 - t1));

        t1 = System.nanoTime();
        for (int i = 0; i < randInts.length; i++) {
            ll.get(i);
        }
        t2 = System.nanoTime();
        System.out.println("ll get: " + (t2 - t1));

        t1 = System.nanoTime();
        for (int i = 0; i < randInts.length; i++) {
            al.get(i);
        }
        t2 = System.nanoTime();
        System.out.println("al get: " + (t2 - t1));

        t1 = System.nanoTime();
        for (int i = randInts.length - 1; i >= 0; i--) {
            ll.remove(i);
        }
        t2 = System.nanoTime();
        System.out.println("ll remove last: " + (t2 - t1));

        t1 = System.nanoTime();
        for (int i = randInts.length - 1; i >= 0; i--) {
            al.remove(i);
        }
        t2 = System.nanoTime();
        System.out.println("al remove last: " + (t2 - t1));

        t1 = System.nanoTime();
        for (int i = 0; i < randInts.length; i++) {
            ll.add(0, randInts[i]);
        }
        t2 = System.nanoTime();
        System.out.println("ll add first: " + (t2 - t1));

        t1 = System.nanoTime();
        for (int i = 0; i < randInts.length; i++) {
            al.add(0, randInts[i]);
        }
        t2 = System.nanoTime();
        System.out.println("al add first: " + (t2 - t1));

        t1 = System.nanoTime();
        while (ll.size() > 0) {
            ll.remove(0);
        }
        t2 = System.nanoTime();
        System.out.println("ll remove first: " + (t2 - t1));

        t1 = System.nanoTime();
        while (al.size() > 0) {
            al.remove(0);
        }
        t2 = System.nanoTime();
        System.out.println("al remove first: " + (t2 - t1));

        System.out.flush();
    }

    @Test
    public void testRemoveWhileIterating() {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            char c = (char) ('a' + i);
            arr.add(c + "");
        }
        // remove element while iterating collection 's mode
        Iterator<String> it = arr.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
            it.remove();
        }
        assert (arr.size() == 0);
    }

    @Test
    public void testList2IntArr() {

        assert (ListThings.list2IntArr(null) == null);
        assert (ListThings.list2IntArr(new ArrayList<Integer>()).length == 0);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            list.add(i + 1);
        }
        int[] res = ListThings.list2IntArr(list);
        for (int i = 0; i < 10; ++i) {
            assert (res[i] == list.get(i));
        }

    }

    @Test
    public void testIntArr2List() {
        assert (ListThings.intArr2List(null) == null);
        assert (ListThings.intArr2List(new int[0]).size() == 0);

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = i + 1;
        }
        List<Integer> l = ListThings.intArr2List(arr);
        assert (l != null && l.size() == 10);
        for (int i = 0; i < arr.length; ++i) {
            assert (l.get(i) == arr[i]);
        }

    }

    @Test
    public void testFilterCollection() {
        Integer[] d = new Integer[10];
        for (int i = 0; i < d.length; ++i) {
            d[i] = i + 1;
        }

        List<Integer> arr1 = new ArrayList<>();
        arr1.addAll(Arrays.asList(d));
        Set<Integer> set1 = new HashSet<>();
        set1.addAll(arr1);

        List<Integer> arr2 = new ArrayList<>(arr1);
        Set<Integer> set2 = new HashSet<>(set1);

        CollectionFilter<Integer> fGt5 = new CollectionFilter<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer > 5)
                    return true;
                return false;
            }
        };

        ListThings.filterCollection(arr1, fGt5);
        ListThings.filterCollection(set1, fGt5);
        assert (testGt5(arr1));
        assert (testGt5(set1));

        CollectionFilter<Integer> fLt5 = new CollectionFilter<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer < 5)
                    return true;
                return false;
            }
        };

        ListThings.filterCollection(arr2, fLt5);
        ListThings.filterCollection(set2, fLt5);
        assert (testLt5(arr2));
        assert (testLt5(set2));

    }

    private boolean testGt5(Collection<Integer> c) {
        for (Integer i : c) {
            if (i <= 5)
                return false;
        }
        return true;
    }

    private boolean testLt5(Collection<Integer> c) {
        for (Integer i : c) {
            if (i >= 5)
                return false;
        }
        return true;
    }

    @Test
    public void testList2Set() {
        assert (ListThings.list2HashSet(null) == null);
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < 10; ++i)
            l.add(i + 1);
        HashSet<Integer> hs = ListThings.list2HashSet(l);
        assert (hs.containsAll(l));
    }

    @Test
    public void testRemoveDupFromArrayList() {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                al.add(10 - j);
            }
        }
        System.out.println(al);
        //use LinkedHashSet to reverse the order in original ArrayList
        Set<Integer> s = new LinkedHashSet<>(al);
        al.clear();
        al.addAll(s);
        assert (al.size() == 10);
        System.out.println(al);
    }

    @Test
    public void testSortCollection() {
        //1. Collections.sort
        ArrayList<Integer> al = new ArrayList<>();
        Random r = new Random(37);
        int count = 0;
        final int NUM = 10;
        while (count++ < NUM) {
            al.add(r.nextInt(NUM * 10));
        }
        System.out.println(al);
        Collections.sort(al);
        System.out.println(al);
        //2. if no duplication, use TreeSet as the other alteration
    }

    @Test
    public void testCollectionCopy() {
        Random r = new Random(37);
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < 10; ++i)
            l1.add(i + 1);
        List<Integer> l2 = new ArrayList<>();
        l2.addAll(l1);
        System.out.println(l2);
        for (int i = 0; i < 10; ++i)
            l1.set(i, r.nextInt(100));
        Collections.copy(l2, l1);
        System.out.println(l2);
    }
}