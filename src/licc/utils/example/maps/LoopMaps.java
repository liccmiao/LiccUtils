package licc.utils.example.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by mengchenli on 2015/2/4.
 */
public class LoopMaps {
    private static Map<String, String> map = new HashMap<String, String>();

    private static void init() {
        map.clear();
        map.put("LoopMaps", "LoopMaps.java");
        map.put("HelloWorld", "HelloWorld.java");
    }

    public static void showLoopMapsExamples() {
        loopByEntrySet();
        System.out.println("---------------------------------------");
        loopByForKeySet();
        System.out.println("---------------------------------------");
        loopByEntrySetIterator();
        System.out.println("---------------------------------------");
        loopByKeySetIterator();
    }

    public static void loopByForKeySet() {
        init();
        for (String k : map.keySet()) {
            System.out.println("loop for keySet, key: " + k + ", value: " + map.get(k));
        }
    }

    public static void loopByEntrySet() {
        init();
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry : set) {
            System.out.println("loop EntrySet, key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }

    public static void loopByKeySetIterator() {
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            System.out.println("loop KeySetIterator, key: " + k + ", value: " + map.get(k));
        }
    }

    public static void loopByEntrySetIterator() {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("loop EntrySetIterator, key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }

}
