package gr.aueb.cf.oop.ch16.ex2;

public class Circle extends AbstractShape implements ICircle {
    private double radius;

    @Override
    public double getDiameter() {
        return radius * 2;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getCircumference() {
        return radius * Math.PI;
    }
}
