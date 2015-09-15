package licc.utils.example.tij.holding;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by mengc_000 on 2015/8/25.
 */
public class Tests {
    public static void main1(String[] args) {
        List<String> sl = new LinkedList<>();
        sl.add("hello");
        sl.add("sub");
        sl.add("list");
        sl.add("here's");
        sl.add("some");
        sl.add("test");
        System.out.println(sl);
        List<String> subSl = sl.subList(0, 2);
        System.out.println(subSl);
        //change subSl also change sl
        subSl.set(0, "hi");
        System.out.println(subSl);
        System.out.println(sl);
        List<String> copy = new LinkedList<>(subSl);
        List<String> copySl = new LinkedList<>(sl);
        sl.retainAll(copy);
        System.out.println(sl);
        copySl.removeAll(copy);
        System.out.println(copySl);

    }

    public static void main(String[] args) {
        List<String> ll = new LinkedList<>();
        ll.add("test");
        ll.add("listIterator");
        ll.add("example");

        ListIterator<String> lItr = ll.listIterator();
        while (lItr.hasNext()) {
            System.out.println(lItr.next() + ", " + lItr.nextIndex() + ", " + lItr.previousIndex());
        }

    }

}
