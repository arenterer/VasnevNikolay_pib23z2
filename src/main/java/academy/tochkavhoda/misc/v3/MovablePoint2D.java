package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.iface.v3.Movable;

import java.util.Objects;

public class MovablePoint2D implements Movable {
    private int x;
    private int y;

    public MovablePoint2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MovablePoint2D() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveRel(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovablePoint2D that = (MovablePoint2D) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

