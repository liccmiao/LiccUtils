package licc.utils.example.collections.maps;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by mengchenli on 2015/5/7.
 */
public class MapThingsTest {

    private Map<String, Integer> m;
    private Logger log = Logger.getLogger(MapThingsTest.class);

    @Before
    public void setUp() throws Exception {
        m = new HashMap<>();
        m.put("a", 3);
        m.put("c", 2);
        m.put("b", 1);
    }

    @Test
    public void testMapSortByKey() {
        List<Map.Entry<String, Integer>> l = new ArrayList<>(m.entrySet());
        System.out.println(l);
        Collections.sort(l, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        System.out.println(l);

        SortedMap<String, Integer> tm = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        tm.putAll(m);
        System.out.println(tm);
    }

    @Test
    public void testMapSortByValue() {
        List<Map.Entry<String, Integer>> l = new ArrayList<>(m.entrySet());
        System.out.println(l);
        Collections.sort(l, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(l);
    }

    @Test
    public void testInitStaticImmutMap() {
        Map<String, Integer> siM = Collections.unmodifiableMap(m);
        try {
            siM.put("d", 4);
        } catch (UnsupportedOperationException e) {
            log.warn("Can not put new mapping into unmodifiableMap", e);
        }
    }

}
