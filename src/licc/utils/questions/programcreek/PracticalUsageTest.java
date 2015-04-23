package licc.utils.questions.programcreek;

import org.junit.Test;

import java.util.List;

public class PracticalUsageTest {

    @Test
    public void testSplitCamelCaseString() throws Exception {
        List<String> list = PracticalUsage.splitCamelCaseString(null);
        assert list == null;
        list = PracticalUsage.splitCamelCaseString("");
        assert list == null;
        list = PracticalUsage.splitCamelCaseString("camelCaseName");
        assert list.size() == 3;
        assert list.get(0).equals("camel") && list.get(1).equals("Case") && list.get(2).equals("Name");
        list = PracticalUsage.splitCamelCaseString("Classname");
        assert list.size() == 1;
        assert list.get(0).equals("Classname");
        list = PracticalUsage.splitCamelCaseString("lower");
        assert list.size() == 1;
        assert list.get(0).equals("lower");
        list = PracticalUsage.splitCamelCaseString("UPPER");
        assert list.get(0).equals("UPPER");
        list = PracticalUsage.splitCamelCaseString("specialCASE");
        assert list.size() == 2;
        assert list.get(0).equals("special") && list.get(1).equals("CASE");
    }

    @Test
    public void testShuffleWithCollectionShuffle() throws Exception {
        Integer[] input = intArr2IntegerArr(range(10));
        System.out.println("Before Shuffle:");
        printArrays(input);
        PracticalUsage.shuffleWithCollectionShuffle(input);
        System.out.println("After Shuffle:");
        printArrays(input);

    }

    @Test
    public void testShuffleWithArrayInPlace() throws Exception {
        int[] input = range(10);
        System.out.println("Before Shuffle:");
        printArrays(intArr2IntegerArr(input));
        PracticalUsage.shuffleWithArrayInPlace(input);
        System.out.println("After Shuffle:");
        printArrays(intArr2IntegerArr(input));
    }

    private <T> void printArrays(T[] input) {
        for (T t : input) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    private Integer[] intArr2IntegerArr(int[] arr) {
        Integer[] ret = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i)
            ret[i] = arr[i];
        return ret;
    }

    private int[] range(int len) {
        int[] ret = new int[len];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = i + 1;
        }
        return ret;
    }

}