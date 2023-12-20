import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
    protected double width;
    protected boolean collided = false;

    protected double length;
    protected Point topLeft;
    private JFrame mainFrame;
    protected int vx = 5;
    protected int vy = 5;

    public Rectangle(JFrame frame, Point topLeft, double width, double length, Color color) {
        this.mainFrame = frame;
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
        this.color = color;
    }

    void update() {
        if (topLeft.getPointX() > mainFrame.getWidth() - width || topLeft.getPointX() < 0) {
            vx *= -1;
        }

        if (topLeft.getPointY() > mainFrame.getHeight() - length || topLeft.getPointY() < 0) {
            vy *= -1;
        }

        if (topLeft.getPointX() > mainFrame.getWidth() - width) {
            topLeft.setPointX(mainFrame.getWidth() - width);
        }

        if (topLeft.getPointX() < 0) {
            topLeft.setPointX(0);
        }

        if (topLeft.getPointY() > mainFrame.getHeight() - length) {
            topLeft.setPointY(mainFrame.getHeight() - length);
        }

        if (topLeft.getPointY() < 0) {
            topLeft.setPointY(0);
        }

        topLeft.setPointX(topLeft.getPointX() + vx);
        topLeft.setPointY(topLeft.getPointY() + vy);


    }

    void draw(Graphics g) {
        g.setColor(color);
        g.fillRect((int)topLeft.getPointX(), (int)topLeft.getPointY(), (int)width, (int)length);
    }

    // Check if this rectangle collides with another rectangle
    // Check if this rectangle collides with another rectangle
    // Kiểm tra xem hình chữ nhật này có va chạm với một hình chữ nhật khác không
    public boolean collidesWithR(Rectangle other) {
        double closestX = Math.max(other.topLeft.getPointX(), Math.min(this.topLeft.getPointX(), other.topLeft.getPointX() + other.width));
        double closestY = Math.max(other.topLeft.getPointY(), Math.min(this.topLeft.getPointY(), other.topLeft.getPointY() + other.length));

        double dx = this.topLeft.getPointX() - closestX;
        double dy = this.topLeft.getPointY() - closestY;

        return dx * dx + dy * dy < (this.width / 2) * (this.width / 2);
    }



    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }
}
