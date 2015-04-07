package licc.utils.example;

import java.util.Comparator;

/**
 * Created by user on 2015/4/7.
 */
public class ExampleComparator implements Comparator<ExampleComparable> {

    /*
     * Note : reverse order comparator
     */
    @Override
    public int compare(ExampleComparable o1, ExampleComparable o2) {
        return o2.getField() - o1.getField();
    }
}
