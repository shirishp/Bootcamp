import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RectangleTest {

    private Rectangle rectangle;

    @Before
    public void setUp() {
        rectangle = new Rectangle(10f, 20f);
    }

    @Test
    public void testArea() throws Exception {
        assertEquals("Invalid area", 200f, rectangle.getArea());
    }

    @Test
    public void testPerimeter() throws Exception {
        assertEquals("Invalid perimeter", 60f, rectangle.getPerimeter());
    }
}
