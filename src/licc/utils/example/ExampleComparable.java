package licc.utils.example;

import java.util.Collections;
import java.util.TreeSet;

/**
 * Created by user on 2015/4/7.
 */
public class ExampleComparable implements Comparable {
    private int field;

    @Override
    public int compareTo(Object o) {
        ExampleComparable e = (ExampleComparable) o;
        return this.field - e.field;
    }

    public ExampleComparable(int field) {
        this.field = field;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "ExampleComparable{" +
                "field=" + field +
                '}';
    }

    public static void main(String[] args) {
        ExampleComparable e1 = new ExampleComparable(1);
        ExampleComparable e2 = new ExampleComparable(2);
        ExampleComparable e3 = new ExampleComparable(3);

        TreeSet<ExampleComparable> tree = new TreeSet<>();
        tree.add(e3);
        tree.add(e2);
        tree.add(e1);

        System.out.println("Order :");
//        treeSetToString(tree);
        treeSetToString2(tree);

        TreeSet<ExampleComparable> tree2 = new TreeSet<>(new ExampleComparator());
        tree2.add(new ExampleComparable(3));
        tree2.add(new ExampleComparable(1));
        tree2.add(new ExampleComparable(2));

        System.out.println("Reverse order :");
//        treeSetToString(tree2);
        treeSetToString2(tree2);

        System.out.println("Change tree : ");
        e1.setField(4);
//        treeSetToString(tree);
        treeSetToString2(tree);

    }


    private static void treeSetToString(TreeSet tree) {
        ExampleComparable[] arr = new ExampleComparable[tree.size()];
        tree.toArray(arr);
        for (ExampleComparable e : arr) {
            System.out.println(e.toString());
        }
    }

    private static void treeSetToString2(TreeSet<ExampleComparable> tree) {
        for (ExampleComparable e : tree) {
            System.out.println(e);
        }
    }

}
