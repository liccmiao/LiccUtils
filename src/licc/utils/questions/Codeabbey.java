package licc.utils.questions;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by user on 2015/8/11.
 */
public class Codeabbey {
    public static void main67(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        while (N-- > 0) {
            BigInteger bi = new BigInteger(in.next());
            BigInteger i = new BigInteger("0");
            BigInteger j = new BigInteger("1");
            int idx = 0;
            while (!i.equals(bi) && idx <= 1000) {
                j = i.add(j);
                i = j.subtract(i);
                idx++;
            }
            System.out.print(idx + " ");
        }
    }


    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger a = new BigInteger(in.next());
        BigInteger b = new BigInteger(in.next());
        System.out.println(a.add(b).toString());
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long sum = 0L;
        while (N-- > 0) {
            sum += in.nextInt();
        }
        System.out.println(sum);
    }

    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        while (N-- > 0) {
            System.out.print(in.nextInt() + in.nextInt() + " ");
        }
    }

    public static void main4(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int a, b;
        while (N-- > 0) {
            a = in.nextInt();
            b = in.nextInt();
            System.out.print((a < b ? a : b) + " ");
        }
    }

    public static void main5(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int a, b, c, min;
        while (N-- > 0) {
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            min = a < b ? a : b;
            min = min < c ? min : c;
            System.out.print(min + " ");
        }
    }

    public static void main15(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 300, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, i;
        while (n-- > 0) {
            i = in.nextInt();
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        System.out.print(max + " " + min);
    }

    public static void main6(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int a, b, div, mod;
        while (N-- > 0) {
            a = in.nextInt();
            b = in.nextInt();
            if (b == 0)
                continue;
            System.out.print(nearest(a, b) + " ");
        }
    }

    private static int nearest(int a, int b) {
        int div, mod;
        div = a / b;
        mod = a % b;
        if (mod * 1.0f / b > 0.5f) {
            if (div >= 0)
                div++;
            else
                div--;
        }
        return div;
    }

    private static int nearest(float f) {
        int i = (int) f;
        if (f - i > 0.5f) {
            if (f >= 0)
                i++;
            else
                i--;
        }
        return i;
    }

    public static void main7(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        while (N-- > 0) {
            int f = in.nextInt();
            float c = (f - 32) * 5 * 1.0f / 9;
            System.out.print(nearest(c) + " ");
        }
    }


}