package licc.utils.example.collections.arrays;

import java.util.Comparator;

/**
 * Created by user on 2015/4/4.
 */
public class ArraysSortSubComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        ArraysSortSub as1 = (ArraysSortSub) o1;
        ArraysSortSub as2 = (ArraysSortSub) o2;
        return as1.getSubField() - as2.getSubField();
    }
}
