package gr.aueb.cf.oop.ch16.ex2;

public class Rectangle extends AbstractShape implements IRectangle {
    private double width;
    private double height;

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getCircumference() {
        return (2 * width) + (2 * height);
    }
}
