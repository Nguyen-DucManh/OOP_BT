import javax.swing.*;
import java.util.Objects;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
    double pi = Math.PI;
    protected double radius;
    private JFrame mainFrame;

    protected Point center;
    protected int size;
    private Color color;

    protected int vx = 5;
    protected int vy = 5;

    public Circle(Point center, int size, Color color, int vx, int vy) {
        this.center = center;
        this.size = size;
        this.color = color;
        this.vx = vx;
        this.vy = vy;
    }

    public Circle(JFrame frame, Point center, int size, Color color, int vx, int vy) {
        this.mainFrame = frame;
        this.center = center;
        this.size = size;
        this.color = color;
        this.vx = vx;
        this.vy = vy;
    }


    void update() {

        if (center.getPointX() > mainFrame.getWidth()) {
            center.setPointX(mainFrame.getWidth());
            vx *= -1;
        }

        if (center.getPointX() < 0) {
            center.setPointX(0);
            vx *= -1;
        }

        if (center.getPointY() > mainFrame.getHeight()) {
            center.setPointY(mainFrame.getHeight());
            vy *= -1;
        }

        if (center.getPointY() < 0) {
            center.setPointY(0);
            vy *= -1;
        }

        center.setPointX(center.getPointX() + vx);
        center.setPointY(center.getPointY() + vy);


    }

    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)center.getPointX(), (int)center.getPointY(), size, size);
    }

    // Check if this circle collides with another circle
    public boolean collidesWithC(Circle other) {
        double closestX = Math.max(this.center.getPointX(), Math.min(other.center.getPointX(), this.center.getPointX() + this.size / 2));
        double closestY = Math.max(this.center.getPointY(), Math.min(other.center.getPointY(), this.center.getPointY() + this.size / 2));

        double dx = other.center.getPointX() - closestX;
        double dy = other.center.getPointY() - closestY;

        return dx * dx + dy * dy < (other.size / 2) * (other.size / 2);
    }


    // Check if this circle collides with a rectangle
    public boolean collidesWith(Rectangle other) {
        double closestX = Math.max(other.topLeft.getPointX(), Math.min(this.center.getPointX(), other.topLeft.getPointX() + other.width));
        double closestY = Math.max(other.topLeft.getPointY(), Math.min(this.center.getPointY(), other.topLeft.getPointY() + other.length));

        double dx = this.center.getPointX() - closestX;
        double dy = this.center.getPointY() - closestY;

        return dx * dx + dy * dy < (this.size / 2) * (this.size / 2);
    }

    @Override
    public double getArea() {
        return pi * this.radius * this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * pi * radius;
    }
}

