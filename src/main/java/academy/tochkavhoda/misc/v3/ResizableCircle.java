package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.iface.v3.HasArea;
import academy.tochkavhoda.iface.v3.Resizable;

import java.util.Objects;

public class ResizableCircle implements Resizable, HasArea {
    private int radius;

    public ResizableCircle(int radius) {
        this.radius = radius;
    }

    public ResizableCircle() {
        this(1);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void resize(double ratio) {
        radius = (int) (radius * ratio);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * (double) radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResizableCircle that = (ResizableCircle) o;
        return radius == that.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}

