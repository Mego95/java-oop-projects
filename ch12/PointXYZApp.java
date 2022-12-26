package gr.aueb.cf.oop.ch12;

public class PointXYZApp {

    public static void main(String[] args) {
        PointXYZ point = new PointXYZ(1, 2, 3);

        System.out.println(point.getX());
        System.out.println(point.getY());
        System.out.println(point.getZ());
        System.out.println(point.convertToString());
    }
}
