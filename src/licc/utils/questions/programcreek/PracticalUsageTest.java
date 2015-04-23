package licc.utils.questions.programcreek;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PracticalUsageTest {

    @Test
    public void testSplitCamelCaseString() throws Exception {
        List<String> list = PracticalUsage.splitCamelCaseString(null);
        assert list == null;
        list = PracticalUsage.splitCamelCaseString("");
        assert list == null;
        list = PracticalUsage.splitCamelCaseString("camelCaseName");
        assert list.size() == 3;
        assert list.get(0).equals("camel") && list.get(1).equals("Case") && list.get(2).equals("Name");
        list = PracticalUsage.splitCamelCaseString("Classname");
        assert list.size() == 1;
        assert list.get(0).equals("Classname");
        list = PracticalUsage.splitCamelCaseString("lower");
        assert list.size() == 1;
        assert list.get(0).equals("lower");
        list = PracticalUsage.splitCamelCaseString("UPPER");
        assert list.get(0).equals("UPPER");
        list = PracticalUsage.splitCamelCaseString("specialCASE");
        assert list.size() == 2;
        assert list.get(0).equals("special") && list.get(1).equals("CASE");
    }

}