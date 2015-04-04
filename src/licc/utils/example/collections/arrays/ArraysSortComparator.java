package licc.utils.example.collections.arrays;

import java.util.Comparator;

/**
 * Created by user on 2015/4/4.
 */
public class ArraysSortComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        ArraysSort a1 = (ArraysSort)o1;
        ArraysSort a2 = (ArraysSort)o2;
        return a1.getField() - a2.getField();
    }
}
