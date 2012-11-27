package day1;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class RectangleTest {

    private Rectangle rectangle;

    @Before
    public void setup() {
        this.rectangle = new Rectangle(2, 4);
    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(8, rectangle.area());
    }

    @Test
    public void shouldCalculatePerimeter() {
        assertEquals(12, rectangle.perimeter());
    }

}
