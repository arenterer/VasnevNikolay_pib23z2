package academy.tochkavhoda.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestColoredValue {
    @Test
    public void testColorGetterSetterAndEquals() {
        ColoredValue v1 = new ColoredValue();
        assertEquals(1, v1.getColor());

        v1.setColor(7);
        assertEquals(7, v1.getColor());

        ColoredValue v2 = new ColoredValue(7);
        ColoredValue v3 = new ColoredValue(8);

        assertEquals(v1, v2);
        assertNotEquals(v1, v3);
        assertEquals(v1.hashCode(), v2.hashCode());
    }
}

