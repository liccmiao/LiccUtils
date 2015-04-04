package licc.utils.example.collections.arrays;

import java.util.Arrays;

/**
 * Created by user on 2015/4/4.
 */
public class ArraysSort {

    private int field;

    public ArraysSort(int field) {
        this.field = field;
    }

    public int getField() {
        return field;
    }

    @Override
    public String toString() {
        return "ArraysSort{" +
                +field +
                '}';
    }

    public static void main(String[] args) {
        ArraysSort[] arr = new ArraysSort[3];
        arr[0] = new ArraysSort(2);
        arr[1] = new ArraysSort(3);
        arr[2] = new ArraysSort(1);

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new ArraysSortComparator());
        System.out.println(Arrays.toString((arr)));

        ArraysSortSub[] arrss = new ArraysSortSub[3];
        arrss[0] = new ArraysSortSub(2, 1);
        arrss[1] = new ArraysSortSub(1, 3);
        arrss[2] = new ArraysSortSub(3, 2);

        System.out.println(Arrays.deepToString(arrss));
        Arrays.sort(arrss, new ArraysSortComparator());
        System.out.println(Arrays.deepToString(arrss));
        Arrays.sort(arrss, new ArraysSortSubComparator());
        System.out.println(Arrays.deepToString(arrss));
    }
}
