package gr.aueb.cf.oop.ch15;

public class Point2D extends Point{
    private double y;

    public Point2D() {
        super();
        y = 0;
    }

    public Point2D(double x, double y) {
        super(x);
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + super.getX() + ", " + y + ")";
    }

    @Override
    public void movePlus10() {
        super.movePlus10();
        y += 10.0;
    }

    @Override
    protected void movePlus1() {
        super.movePlus1();
        y++;
    }

    @Override
    public double getDistanceFromOrigin() {
        return Math.sqrt((Math.pow(super.getX(), 2)) + Math.pow(this.getY(), 2));
    }
}