package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class ColoredRectangle {
    private Point topLeft;
    private Point bottomRight;
    private int color;

    public ColoredRectangle(Point leftTop, Point rightBottom, int color) {
        this.topLeft = leftTop;
        this.bottomRight = rightBottom;
        this.color = color;
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        this.topLeft = new Point(xLeft, yTop);
        this.bottomRight = new Point(xRight, yBottom);
        this.color = color;
    }

    public ColoredRectangle(int length, int width, int color) {
        this.topLeft = new Point(0, -width);
        this.bottomRight = new Point(length, 0);
        this.color = color;
    }

    public ColoredRectangle(int color) {
        this(1, 1, color);
    }

    public ColoredRectangle() {
        this(1);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public int getColor() {
        return color;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    public int getWidth() {
        return bottomRight.getY() - topLeft.getY();
    }

    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();
        topLeft = new Point(x, y);
        bottomRight = new Point(x + length, y + width);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void resize(double ratio) {
        int newLength = (int) (getLength() * ratio);
        int newWidth = (int) (getWidth() * ratio);
        bottomRight = new Point(topLeft.getX() + newLength, topLeft.getY() + newWidth);
    }

    public void stretch(double xRatio, double yRatio) {
        int newLength = (int) (getLength() * xRatio);
        int newWidth = (int) (getWidth() * yRatio);
        bottomRight = new Point(topLeft.getX() + newLength, topLeft.getY() + newWidth);
    }

    public double getArea() {
        return getLength() * (double) getWidth();
    }

    public double getPerimeter() {
        return 2 * (getLength() + (double) getWidth());
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= bottomRight.getX()
                && y >= topLeft.getY() && y <= bottomRight.getY();
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(ColoredRectangle rectangle) {
        return !(rectangle.getBottomRight().getX() < topLeft.getX()
                || rectangle.getTopLeft().getX() > bottomRight.getX()
                || rectangle.getBottomRight().getY() < topLeft.getY()
                || rectangle.getTopLeft().getY() > bottomRight.getY());
    }

    public boolean isInside(ColoredRectangle rectangle) {
        return isInside(rectangle.getTopLeft()) && isInside(rectangle.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return color == that.color
                && Objects.equals(topLeft, that.topLeft)
                && Objects.equals(bottomRight, that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight, color);
    }
}