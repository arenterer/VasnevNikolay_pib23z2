package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.iface.v2.Colored;

import java.util.Objects;

public class ColoredValue implements Colored {
    private int color;

    public ColoredValue(int color) {
        this.color = color;
    }

    public ColoredValue() {
        this(1);
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColoredValue that = (ColoredValue) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}

