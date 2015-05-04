package licc.utils.example;

import org.junit.Test;


public class PropertiesExampleTest {

    @Test
    public void testPropertiesExample() {
        PropertiesExample pe = PropertiesExample.getInstance();
        assert (pe.getPropertyFile().equals("file/proptest.properties"));
        pe.load(pe.getPropertyFile());
        assert (pe.contains("proptest.value1"));
        assert (pe.contains("proptest.value2"));
        assert (pe.containsKey("proptest.key1"));
        assert (pe.containsKey("proptest.key2"));
        assert (pe.getProperty("notexistkey") == null);
        assert (pe.getProperty("proptest.key1").equals("proptest.value1"));
        assert (pe.getProperty("proptest.key2").equals("proptest.value2"));

        if (pe.containsKey("proptest.addedkey"))
            pe.removeProperty("proptest.addedkey");
        assert (pe.size() == 2);

        if (!pe.containsKey("proptest.addedkey"))
            pe.setProperty("proptest.addedkey", "proptest.addedvalue");

        assert (pe.size() == 3);
        assert (pe.containsKey("proptest.addedkey"));
        assert (pe.contains("proptest.addedvalue"));
        pe.save();
    }
}