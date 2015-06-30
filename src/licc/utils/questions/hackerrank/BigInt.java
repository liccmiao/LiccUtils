package licc.utils.questions.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by user on 2015/6/30.
 */
public class BigInt {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        BigInteger bigA = new BigInteger(a);
        BigInteger bigB = new BigInteger(b);
        System.out.println(bigA.add(bigB));
        System.out.println(bigA.multiply(bigB));
    }
}
