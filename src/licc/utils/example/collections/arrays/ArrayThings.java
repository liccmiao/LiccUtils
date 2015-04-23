package licc.utils.example.collections.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengchenli on 2015/4/3.
 */
public class ArrayThings {
    //1. Print an array in Java
    //int[] intArray = {1, 2, 3, 4, 5};
    public static String printArray(int[] arr) {
        // no need test arr==null || arr.length ==0, since Arrays.toString has done it
        return Arrays.toString(arr);
    }

    //2. Create an ArrayList from an array
    //String[] stringArray = { "a", "b", "c", "d", "e" };
    public static ArrayList<String> array2ArrayList(String[] strArr) {
        if (strArr == null || strArr.length == 0)
            return new ArrayList<>();
        else
            return new ArrayList<>(Arrays.asList(strArr));
    }

    //3. Check if an array contains a certain value
    //String[] stringArray = {"a", "b", "c", "d", "e"};
    public static boolean arrayContainsStr(String[] arr, String c) {
        if (arr == null || c == null || arr.length == 0) return false;
        for (String s : arr) {
            if (s.equals(c))
                return true;
        }
        return false;
    }

    //4. Concatenate two arrays
    //int[] intArray = {1, 2, 3, 4, 5};
    //int[] intArray2 = {6, 7, 8, 9, 10};
    public static int[] concat(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return null;
        if (arr1 == null) return Arrays.copyOf(arr2, arr2.length);
        if (arr2 == null) return Arrays.copyOf(arr1, arr1.length);
        int[] arr = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);
        return arr;
    }

    //6. Joins the elements of the provided array into a single String
    public static String join(String[] arr, String d) {
        if (arr == null || arr.length == 0)
            return null;
        if (d == null)
            d = ",";
        StringBuilder sbder = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            sbder.append(arr[i]);
            if (i != arr.length - 1)
                sbder.append(d);
        }
        //return new String(sbder);
        return sbder.toString();
    }

    //7. Covnert an ArrayList to an array
    public static String[] arrayList2Array(ArrayList<String> arrList) {
        if (arrList == null) return null;
        String[] resArr = new String[arrList.size()];
        return arrList.toArray(resArr);
    }

    //8. Convert an array to a set
    public static Set<String> array2Set(String[] arr) {
        if (arr == null) return null;
        return new HashSet<>(Arrays.asList(arr));
    }

    //9. Reverse an array
    // not in place but return a new Array
    // for in place reverse, see ReverseArrInPlace in pkg java revisited questions
    public static int[] reverseArr(int[] arr) {
        if (arr == null) return null;
        int[] ret = new int[arr.length];
        final int len = arr.length;
        for (int i = 0; i < arr.length; ++i) {
            ret[i] = arr[len - i - 1];
        }
        return ret;
    }

    //10. Remove element of an array
    //int[] intArray = { 1, 2, 3, 4, 5 };
    // return a new Array without the removed elements, original Array not changed
    public static int[] removeElement(int[] arr, int n) {
        if (arr == null || arr.length == 0) return arr;
        int[] tempArr = new int[arr.length];
        int j = 0;
        for (int e : arr) {
            if (e != n) {
                tempArr[j] = e;
                j++;
            }
        }
        return Arrays.copyOf(tempArr, j);
    }
}
