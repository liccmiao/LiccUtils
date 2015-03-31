package licc.utils.example.objectmethods;

import org.junit.Test;

public class RectangleTest {

    @Test
    public void testClone() throws Exception {
        Rectangle rec = new Rectangle(30, 40);
        Rectangle copy = null;

        try {
            copy = rec.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("[Clone not support:" + Rectangle.class.getName() + "]," + e.getMessage());
        }

        assert (rec != copy);
        assert (rec.getClass() == copy.getClass());
        assert (rec.equals(copy));
        assert (rec.toString().equals(copy.toString()));

        System.out.println(copy.toString());
        copy.setWidth(10);
        copy.setHeight(20);
        System.out.println(copy.toString());

        assert (!rec.equals(copy));

    }
}