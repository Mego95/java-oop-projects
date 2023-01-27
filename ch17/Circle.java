package gr.aueb.cf.oop.ch17;

import java.awt.image.CropImageFilter;
import java.io.Serializable;

public class Circle extends AbstractShape implements ICircle, Cloneable, Serializable {
    private double radius;
    private static final long serialVersionUID = 1L;

    public Circle() {}

    // copy constructor
    public Circle(Circle circle) {
        this.radius = circle.radius;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    protected Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }
}
