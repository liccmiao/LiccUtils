package licc.utils.example.collections.lists;

import java.util.*;

/**
 * Created by mengchenli on 2015/5/6.
 */
public class ListThings {

    public static int[] list2IntArr(List<Integer> l) {
        if (l == null) return null;
        //if Integer[] , then use List.toArray(T[] )
        /*
         * Integer[] ret = new Integer[l.size()];
         * ret = l.toArray(ret);
         */
        int[] ret = new int[l.size()];
        int i = 0;
        for (Integer e : l) {
            ret[i++] = e;
        }
        return ret;

    }

    public static List<Integer> intArr2List(int[] arr) {
        if (arr == null) return null;
        if (arr.length == 0) return new ArrayList<>();
        //if Integer[] , then use Arrays.asList
        /*  Integer[] arrI = new Integer[10];
         *  List<Integer> l = Arrays.asList(arrI);
         */
        //for int[] , Arrays.asList would return List<int[]>, which is not what we want
        List<Integer> l = new ArrayList<>(arr.length);
        for (int i : arr) {
            l.add(i);
        }
        return l;
    }

    public static <T> void filterCollection(Collection<T> c, CollectionFilter<T> f) {
        if (c == null || f == null) return;
        if (c.size() == 0) return;
        //1.using sometest() to filter
        //2.from http://www.programcreek.com/2013/09/top-10-questions-for-java-collections/
        Iterator<T> it = c.iterator();
        while (it.hasNext()) {
            //1. if (false == sometest(it.next())) {
            //2. f.test()
            if (!f.test(it.next()))
                it.remove();
        }
    }

    private static <T> boolean sometest(T t) {
        //if ... return false
        return true;
    }

    public static <T> HashSet<T> list2HashSet(List<T> l) {
        if (l == null) return null;
        return new HashSet<>(l);
    }
}
