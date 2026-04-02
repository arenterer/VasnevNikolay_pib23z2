package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStretchableBox {
    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testStretchResizeMoveAndArea() {
        StretchableBox b = new StretchableBox(1, 2, 3, 4);
        assertEquals(12.0, b.getArea(), DOUBLE_EPS);

        b.moveRel(5, 6);
        assertAll(
                () -> assertEquals(6, b.getX()),
                () -> assertEquals(8, b.getY())
        );

        b.moveTo(new Point(10, 20));
        assertAll(
                () -> assertEquals(10, b.getX()),
                () -> assertEquals(20, b.getY())
        );

        b.stretch(2, 3);
        assertAll(
                () -> assertEquals(6, b.getWidth()),
                () -> assertEquals(12, b.getHeight()),
                () -> assertEquals(72, b.getArea(), DOUBLE_EPS)
        );

        b.resize(2);
        assertAll(
                () -> assertEquals(12, b.getWidth()),
                () -> assertEquals(24, b.getHeight()),
                () -> assertEquals(288, b.getArea(), DOUBLE_EPS)
        );
    }

    @Test
    public void testEqualsAndHashCode() {
        StretchableBox b1 = new StretchableBox(1, 2, 3, 4);
        StretchableBox b2 = new StretchableBox(1, 2, 3, 4);
        StretchableBox b3 = new StretchableBox(1, 2, 3, 5);

        assertEquals(b1, b2);
        assertNotEquals(b1, b3);
        assertEquals(b1.hashCode(), b2.hashCode());
    }
}

