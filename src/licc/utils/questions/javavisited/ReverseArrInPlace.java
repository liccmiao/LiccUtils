package licc.utils.questions.javavisited;

/**
 * Created by mengchenli on 2015/3/31.
 */
public class ReverseArrInPlace {
    public static void reverseArr1(int[] arr) {
        if(arr == null || arr.length ==0)
            return;
        int len = arr.length;
        int i = 0, j = len - 1;
        while (i < j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
            ++i;
            --j;
        }
    }

    public static void reverseArr2(int[] arr) {
        if(arr == null || arr.length ==0)
            return;
        int len = arr.length;
        int i = 0, j = len - 1;
        while (i < j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
            ++i;
            --j;
        }
    }
}
