package gr.aueb.cf.oop.ch16.ex1;

public class Circle extends AbstractShape implements ITwoDimensional {
    private double radius;

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }
}
