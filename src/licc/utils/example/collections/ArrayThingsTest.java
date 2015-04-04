package licc.utils.example.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;


public class ArrayThingsTest {

    @Test
    public void testPrintArray() throws Exception {
        int[] intArray = {1, 2, 3, 4, 5};
        assert (ArrayThings.printArray(null).equals("null"));
        assert (ArrayThings.printArray(new int[0]).equals("[]"));
        assert (ArrayThings.printArray(intArray).equals("[1, 2, 3, 4, 5]"));
    }

    @Test
    public void testArray2ArrayList() throws Exception {
        String[] stringArray = {"a", "b", "c", "d", "e"};

        ArrayList<String> arrayList = ArrayThings.array2ArrayList(null);
        assert (arrayList != null && arrayList.size() == 0);
        arrayList = ArrayThings.array2ArrayList(new String[0]);
        assert (arrayList != null && arrayList.size() == 0);
        arrayList = ArrayThings.array2ArrayList(stringArray);
        assert (arrayList != null);
        for (int i = 0; i < stringArray.length; ++i) {
            assert (stringArray[i] != null && stringArray[i].equals(arrayList.get(i)));
        }
    }

    @Test
    public void testArrayContainsStr() throws Exception {
        String[] stringArray = {"a", "b", "c", "d", "e"};

        assert (!ArrayThings.arrayContainsStr(null, null));
        assert (!ArrayThings.arrayContainsStr(null, ""));
        assert (!ArrayThings.arrayContainsStr(null, "a"));
        assert (!ArrayThings.arrayContainsStr(new String[0], null));
        assert (!ArrayThings.arrayContainsStr(new String[0], ""));
        assert (!ArrayThings.arrayContainsStr(new String[0], "b"));
        assert (!ArrayThings.arrayContainsStr(stringArray, null));
        assert (!ArrayThings.arrayContainsStr(stringArray, ""));
        assert (ArrayThings.arrayContainsStr(stringArray, "a"));
        assert (ArrayThings.arrayContainsStr(stringArray, "c"));
        assert (!ArrayThings.arrayContainsStr(stringArray, "f"));


    }

    @Test
    public void testConcat() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};
        int[] rs1 = ArrayThings.concat(null, null);
        assert (rs1 == null);
        int[] rs2 = ArrayThings.concat(null, new int[0]);
        assert (rs2 != null && rs2.length == 0);
        int[] rs3 = ArrayThings.concat(null, arr2);
        assert (rs3 != arr2 && Arrays.equals(rs3, arr2));
        int[] rs4 = ArrayThings.concat(new int[0], null);
        assert (rs4 != null && rs4.length == 0);
        int[] rs5 = ArrayThings.concat(arr1, null);
        assert (rs5 != arr1 && Arrays.equals(rs5, arr1));
        int[] rs6 = ArrayThings.concat(arr1, arr2);
        assert (rs6 != null);
        for (int i = 0; i < arr1.length; ++i)
            assert (rs6[i] == arr1[i]);
        for (int i = 0; i < arr2.length; ++i) {
            assert (rs6[arr1.length + i] == arr2[i]);
        }

    }

    @Test
    public void testJoin() throws Exception {
        String[] arr = {"a", "b", "c", "d", "e"};
        String d1 = ",";
        String d2 = "|";

        assert (ArrayThings.join(null, null) == null);
        assert (ArrayThings.join(null, d1) == null);
        assert (ArrayThings.join(new String[0], null) == null);
        assert (ArrayThings.join(new String[0], d1) == null);
        String rs1 = ArrayThings.join(arr, null);
        assert (rs1 != null && rs1.equals("a,b,c,d,e"));
        String rs2 = ArrayThings.join(arr, d1);
        assert (rs2 != null && rs2.equals("a,b,c,d,e"));
        String rs3 = ArrayThings.join(arr, d2);
        assert (rs3 != null && rs3.equals("a|b|c|d|e"));
    }

    @Test
    public void testArrayList2Array() throws Exception {
        String[] stringArray = {"a", "b", "c", "d", "e"};
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
        assert (ArrayThings.arrayList2Array(null) == null);
        String[] rs1 = ArrayThings.arrayList2Array(new ArrayList<String>());
        assert (rs1 != null && rs1.length == 0);
        String[] rs2 = ArrayThings.arrayList2Array(arrayList);
        assert (rs2 != null);
        for (int i = 0; i < rs2.length; ++i)
            assert (rs2[i] != null && rs2[i].equals(arrayList.get(i)));

    }

    @Test
    public void testArray2Set() throws Exception {
        String[] arr = {"a", "b", "c", "d", "e"};
        String[] arr2 = {"a", "a", "b", "b", "c"};
        assert (ArrayThings.array2Set(null) == null);
        Set<String> rs1 = ArrayThings.array2Set(new String[0]);
        assert (rs1 != null && rs1.size() == 0);
        Set<String> rs2 = ArrayThings.array2Set(arr);
        assert (rs2 != null && rs2.size() == 5);
        for (String s : arr) {
            assert (rs2.contains(s));
        }
        Set<String> rs3 = ArrayThings.array2Set(arr2);
        assert (rs3 != null && rs3.size() == 3);
        for (String s : arr2) {
            assert (rs3.contains(s));
        }

    }

    @Test
    public void testReverseArr() throws Exception {
        int[] intArray = {1, 2, 3, 4, 5};
        assert (ArrayThings.reverseArr(null) == null);
        int[] rs1 = ArrayThings.reverseArr(new int[0]);
        assert (rs1 != null && rs1.length == 0);
        int[] rs2 = ArrayThings.reverseArr(intArray);
        assert (rs2 != null && rs2.length == 5);
        for (int i = 0; i < rs2.length; ++i)
            assert (rs2[i] == intArray[intArray.length - i - 1]);
    }

    @Test
    public void testRemoveElement() throws Exception {
        int[] intArray = {1, 2, 3, 4, 5};
        assert (ArrayThings.removeElement(null, 0) == null);
        int[] zero = new int[0];
        assert (ArrayThings.removeElement(zero, 0) == zero);
        int[] rs1 = ArrayThings.removeElement(intArray, 0);
        assert (rs1 != null && rs1.length == intArray.length);
        for (int i = 0; i < intArray.length; ++i) {
            assert (rs1[i] == intArray[i]);
        }
        int[] rs2 = ArrayThings.removeElement(intArray, 5);
        assert (rs2 != null && rs2.length == intArray.length - 1);
        for (int i = 0; i < rs2.length; ++i) {
            assert (rs2[i] == intArray[i]);
        }

    }
}