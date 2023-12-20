import java.awt.*;

public abstract class Shape {
    protected Color color;
    protected boolean filled;
    protected double side;

    public Shape() {}

    public Shape(String color, boolean filled) {
        this.color = Color.decode(color);
        this.filled = filled;
    }

    public String getColor() {
        return String.valueOf(color);
    }

    public void setColor(String color) {
        this.color = Color.decode(color);
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public String toString() {
        return "Shape[color=" + this.getColor() + ",filled=" + this.isFilled() + "]";
    }


}
