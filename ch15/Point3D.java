package gr.aueb.cf.oop.ch15;

public class Point3D extends Point2D{
    private double z;

    public Point3D() {}

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }

    @Override
    public void movePlus10() {
        super.movePlus10();
        z += 10;
    }

    @Override
    protected void movePlus1() {
        super.movePlus1();
        z++;
    }

    @Override
    public double getDistanceFromOrigin() {
        return Math.sqrt((Math.pow(super.getX(), 2)) + Math.pow(super.getY(), 2) + Math.pow(this.getZ(), 2));
    }
}