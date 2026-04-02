package academy.tochkavhoda.misc.v3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestResizableCircle {
    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testResizeAndArea() {
        ResizableCircle c = new ResizableCircle(10);
        assertEquals(Math.PI * 100, c.getArea(), DOUBLE_EPS);

        c.resize(2);
        assertEquals(20, c.getRadius());
        assertEquals(Math.PI * 400, c.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testEqualsAndHashCode() {
        ResizableCircle c1 = new ResizableCircle(3);
        ResizableCircle c2 = new ResizableCircle(3);
        ResizableCircle c3 = new ResizableCircle(4);

        assertEquals(c1, c2);
        assertNotEquals(c1, c3);
        assertEquals(c1.hashCode(), c2.hashCode());
    }
}

