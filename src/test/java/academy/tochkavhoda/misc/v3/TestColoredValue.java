package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestColoredValue {
    @Test
    public void testColorGetterSetterAndEquals() throws ColorException {
        ColoredValue v1 = new ColoredValue();
        assertEquals(Color.RED, v1.getColor());

        v1.setColor(Color.GREEN);
        assertEquals(Color.GREEN, v1.getColor());

        ColoredValue v2 = new ColoredValue(Color.GREEN);
        ColoredValue v3 = new ColoredValue(Color.BLUE);

        assertEquals(v1, v2);
        assertNotEquals(v1, v3);
        assertEquals(v1.hashCode(), v2.hashCode());
    }

    @Test
    public void testSetColorFromString() throws ColorException {
        ColoredValue v = new ColoredValue("GREEN");
        assertEquals(Color.GREEN, v.getColor());

        v.setColor("BLUE");
        assertEquals(Color.BLUE, v.getColor());
    }

    @Test
    public void testWrongAndNullColor() {
        assertThrows(ColorException.class, () -> new ColoredValue((Color) null));
        assertThrows(ColorException.class, () -> new ColoredValue((String) null));
        assertThrows(ColorException.class, () -> new ColoredValue("YELLOW"));

        try {
            new ColoredValue("YELLOW");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }

        try {
            new ColoredValue((String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }

        try {
            new ColoredValue((Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
    }
}

