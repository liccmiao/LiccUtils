package licc.utils.questions.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mengchenli on 2015/6/30.
 */
public class PhoneBookQuery {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String, String> map = new HashMap<>();
        String name;
        String phone;
        while (n > 0) {
            name = in.nextLine();
            phone = in.nextLine();
            map.put(name, phone);
            n--;
        }
        String query;
        String result;
        while (in.hasNext()) {
            query = in.nextLine();
            result = map.get(query);
            if (result != null)
                System.out.println(query + "=" + result);
            else
                System.out.println("Not found");
        }
        in.close();
    }
}
