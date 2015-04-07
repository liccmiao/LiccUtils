package licc.utils.example.collections.arrays;

import java.util.Comparator;

/**
 * Created by user on 2015/4/4.
 */
public class ArraysSortComparator implements Comparator<ArraysSort> {
    @Override
    public int compare(ArraysSort o1, ArraysSort o2) {
        return o1.getField() - o2.getField();
    }
}
