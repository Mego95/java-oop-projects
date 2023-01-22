package gr.aueb.cf.oop.ch16.ex1;

public class Rectangle extends AbstractShape implements ITwoDimensional {
    private double width;
    private double height;

    @Override
    public double getArea() {
        return width * height;
    }
}
