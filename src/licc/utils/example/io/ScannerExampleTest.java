package licc.utils.example.io;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mengchenli on 2015/5/4.
 */
public class ScannerExampleTest {

    @Test
    public void testScannerNextIntExample() {
        String input = "1 2 a d3 10";
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(input);

        while (scanner.hasNextInt()) {
            list.add("" + (scanner.nextInt()));
        }
        assert (list.size() == 2 && list.get(0).equals("1") && list.get(1).equals("2"));
    }

    @Test
    public void testScannerNextExample() {
        String input = "1 2 a d3 10";
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(input);

        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        assert (list.size() == 5 && list.get(0).equals("1") && list.get(1).equals("2")
                && list.get(2).equals("a") && list.get(3).equals("d3") && list.get(4).equals("10"));
    }
}
