package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMovablePoint2D {
    @Test
    public void testMoveToPointAndMoveRel() {
        MovablePoint2D p = new MovablePoint2D(10, 20);
        p.moveRel(5, -5);
        assertAll(
                () -> assertEquals(15, p.getX()),
                () -> assertEquals(15, p.getY())
        );

        p.moveTo(new Point(100, 200));
        assertAll(
                () -> assertEquals(100, p.getX()),
                () -> assertEquals(200, p.getY())
        );
    }

    @Test
    public void testEqualsAndHashCode() {
        MovablePoint2D p1 = new MovablePoint2D(1, 2);
        MovablePoint2D p2 = new MovablePoint2D(1, 2);
        MovablePoint2D p3 = new MovablePoint2D(2, 1);

        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1, p3);
    }
}

