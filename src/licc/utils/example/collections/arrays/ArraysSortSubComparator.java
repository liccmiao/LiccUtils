package licc.utils.example.collections.arrays;

import java.util.Comparator;

/**
 * Created by user on 2015/4/4.
 */
public class ArraysSortSubComparator implements Comparator<ArraysSortSub> {
    @Override
    public int compare(ArraysSortSub o1, ArraysSortSub o2) {
        return o1.getSubField() - o2.getSubField();
    }
}
