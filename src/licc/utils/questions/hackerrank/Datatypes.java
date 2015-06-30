package licc.utils.questions.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by user on 2015/6/30.
 */
public class Datatypes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        for (int i = 0; i < num; ++i) {
            String line = in.nextLine();
            BigInteger bigInt = new BigInteger(line);
            DataType flag = DataType.NON;
            System.out.print(line);

            if (bigInt.compareTo(new BigInteger(Long.valueOf(Long.MIN_VALUE).toString())) >= 0 &&
                    bigInt.compareTo(new BigInteger(Long.valueOf(Long.MAX_VALUE).toString())) <= 0){
                flag = DataType.Long;
                if (bigInt.longValue() >= Integer.MIN_VALUE && bigInt.longValue() <= Integer.MAX_VALUE)
                    flag = DataType.Int;
                if (bigInt.longValue() >= Short.MIN_VALUE && bigInt.longValue() <= Short.MAX_VALUE)
                    flag = DataType.Short;
                if (bigInt.longValue() >= Byte.MIN_VALUE && bigInt.longValue() <= Byte.MAX_VALUE)
                    flag = DataType.Byte;
            }

            if (flag.value() > 0) {
                System.out.println(" can be fitted in:");
                System.out.println(flag.toString());
            } else {
                System.out.println(" can't be fitted anywhere.");
            }

        }
    }

    private enum DataType {
        NON, Byte, Short, Int, Long;

        public int value() {
            switch (this) {
                case Byte:
                    return 1;
                case Short:
                    return 2;
                case Int:
                    return 3;
                case Long:
                    return 4;
                default:
                    return 0;
            }
        }

        @Override
        public String toString() {
            String linesep = System.getProperty("line.separator");
            switch (this) {
                case Byte:
                    return "* byte" + linesep + "* short" + linesep + "* int" + linesep + "* long";
                case Short:
                    return "* short" + linesep + "* int" + linesep + "* long";
                case Int:
                    return "* int" + linesep + "* long";
                case Long:
                    return "* long";
                default:
                    return "";
            }
        }
    }
}
