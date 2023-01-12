package gr.aueb.cf.oop.ch15;

public class Main {

    public static void main(String[] args) {
        Point p1 = new Point(2.0);
        Point p2 = new Point2D(3.0, 4.0);
        Point p3 = new Point3D(1.0, 2.0, 3.0);

        double distance1 = PointUtil.distanceFromOrigin(p1);
        double distance2 = PointUtil.distanceFromOrigin(p2);
        double distance3 = PointUtil.distanceFromOrigin(p3);

        System.out.println("Point distance: " + distance1);
        System.out.println("Point2D distance: " + distance2);
        System.out.println("Point3d distance: " + distance3);
    }
}
