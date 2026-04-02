package academy.tochkavhoda.figures.v2;

import java.util.Objects;

public class Square extends Figure {
    private Point topLeft;
    private int size;

    public Square(Point leftTop, int size) {
        this.topLeft = leftTop;
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this.topLeft = new Point(xLeft, yTop);
        this.size = size;
    }

    public Square(int size) {
        this.topLeft = new Point(0, -size);
        this.size = size;
    }

    public Square() {
        this(1);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return new Point(topLeft.getX() + size, topLeft.getY() + size);
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getLength() {
        return size;
    }

    @Override
    public void moveTo(int x, int y) {
        topLeft = new Point(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {
        size = (int) (size * ratio);
    }

    @Override
    public double getArea() {
        return size * (double) size;
    }

    @Override
    public double getPerimeter() {
        return 4 * (double) size;
    }

    @Override
    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= topLeft.getX() + size
                && y >= topLeft.getY() && y <= topLeft.getY() + size;
    }

    public boolean isIntersects(Square square) {
        return !(square.getBottomRight().getX() < topLeft.getX()
                || square.getTopLeft().getX() > topLeft.getX() + size
                || square.getBottomRight().getY() < topLeft.getY()
                || square.getTopLeft().getY() > topLeft.getY() + size);
    }

    public boolean isInside(Square square) {
        return isInside(square.getTopLeft()) && isInside(square.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return size == square.size && Objects.equals(topLeft, square.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, size);
    }
}

