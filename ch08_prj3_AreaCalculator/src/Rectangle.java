public class Rectangle extends Square {

    private double height;

    public Rectangle(double width, double height) {
        super(width);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return (getWidth() * height);
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
