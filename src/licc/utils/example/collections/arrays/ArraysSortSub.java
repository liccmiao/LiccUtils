package licc.utils.example.collections.arrays;

/**
 * Created by user on 2015/4/4.
 */
public class ArraysSortSub extends ArraysSort {
    private int subField;

    public ArraysSortSub(int field, int subField) {
        super(field);
        this.subField = subField;
    }

    public int getSubField() {
        return subField;
    }

    @Override
    public String toString() {
        return "ArraysSortSub{" +
                this.getField() + "," +
                this.subField
                + "} ";
    }
}
