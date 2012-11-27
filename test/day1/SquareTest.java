package day1;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SquareTest {

    private Rectangle square;

    @Before
    public void setup() {
        this.square = Rectangle.createSquare(2);
    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(4, square.area());
    }

    @Test
    public void shouldCalculatePerimeter() {
        assertEquals(8, square.perimeter());
    }

}
