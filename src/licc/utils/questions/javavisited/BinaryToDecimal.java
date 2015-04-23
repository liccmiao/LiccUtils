package licc.utils.questions.javavisited;

/**
 * Created by mengchenli on 2015/3/30.
 * Problem : Write a Java program to convert a binary number into decimal format,
 * without using any library method which can directly solve the problem. You are
 * free to use basic Java functions though e.g. those defined in java.lang and all
 * kinds of Java operator e.g. arithmetic and logical operator, bitwise and bitshift
 * operator and relational operators.Read more: http://javarevisited.blogspot.com/2015/01/how-to-convert-binary-number-to-decimal.html#ixzz3VqiCDt2Q
 */
public class BinaryToDecimal {
    //no consideration of 2's complement
    public static int binaryToDecimal(int number) throws NumberFormatException {
        int result = 0;
        int power = 0;
        if (number < 0) {
            throw new NumberFormatException("input not standard");
        }
        while (number > 0) {
            if (number % 10 != 0 && number % 10 != 1)
                throw new NumberFormatException("input not standard");
            result += (number % 10) * (1 << power);
            power++;
            number /= 10;
        }

        return result;

    }
}
