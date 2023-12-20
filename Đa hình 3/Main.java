import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
}

class Program {
    private JFrame mainFrame;
    private DrawPanel drawPanel;
    private java.util.List<Circle> circles;
    private java.util.List<Rectangle> rectangles;

    private int windowWidth = 640;
    private int windowHeight = 480;
    private String windowLabel = "Bounce Program";

    void run() {
        /* Initialize program */
        mainFrame = new JFrame();
        drawPanel = new DrawPanel();
        mainFrame.getContentPane().add(drawPanel);
        mainFrame.setTitle(windowLabel);
        mainFrame.setSize(windowWidth, windowHeight);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        circles = new ArrayList<>();
        rectangles = new ArrayList<>();

        mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == 'c') {
                    Circle circle = new Circle(
                            mainFrame,
                            new Point(Math.floor(Math.random() * windowWidth), Math.floor(Math.random() * windowHeight)),
                            (int) Math.floor(Math.random() * 40) + 20,
                            new Color(
                                    (int) Math.floor((Math.random() * 256)),
                                    (int) Math.floor((Math.random() * 256)),
                                    (int) Math.floor((Math.random() * 256))
                            ),
                            (int) Math.floor((Math.random() * 10) - 5),
                            (int) Math.floor((Math.random() * 10) - 5)
                    );
                    circles.add(circle);
                } else if (e.getKeyChar() == 'r') {
                    Rectangle rectangle = new Rectangle(
                            mainFrame,
                            new Point(Math.floor(Math.random() * windowWidth), Math.floor(Math.random() * windowHeight)),
                            Math.floor(Math.random() * 40) + 20,
                            Math.floor(Math.random() * 40) + 20,
                            new Color(
                                    (int) Math.floor((Math.random() * 256)),
                                    (int) Math.floor((Math.random() * 256)),
                                    (int) Math.floor((Math.random() * 256))
                            )
                    );
                    rectangles.add(rectangle);
                } else if (e.getKeyChar() == 'd') {
                    if (!circles.isEmpty()) {
                        circles.remove(circles.size() - 1);
                    }
                }
                else if (e.getKeyChar() == 'm') {
                    if (!rectangles.isEmpty()) {
                        rectangles.remove(rectangles.size() - 1);
                    }
                }
            }
        });

        while (true) {
            for (Circle c: circles) {
                c.update();
            }

            for (Rectangle r: rectangles) {
                r.update();
            }

            // Detect collisions
            for (Circle c1 : circles) {
                for (Circle c2 : circles) {
                    if (c1 != c2 && c1.collidesWithC(c2)) {
                        // Handle collision...
                        c1.vx *= -1;
                        c1.vy *= -1;
                        c2.vx *= -1;
                        c2.vy *= -1;
                    }
                }
            }

            for (Rectangle r1 : rectangles) {
                for (Rectangle r2 : rectangles) {
                    if (r1.collidesWithR(r2)) {
                        // Handle collision...
                        r1.vx *= -1;
                        r1.vy *= -1;
                        r2.vx *= -1;
                        r2.vy *= -1;
                    }
                }
            }

            // Detect collisions between circles and rectangles
            for (Circle c : circles) {
                for (Rectangle r : rectangles) {
                    if (c.collidesWith(r)) {
                        // Handle collision...
                        c.vx *= -1;
                        c.vy *= -1;
                        r.vx *= -1;
                        r.vy *= -1;
                    }
                }
            }

            // Remove duplicates
            for (Iterator<Circle> iterator = circles.iterator(); iterator.hasNext();) {
                Circle c1 = iterator.next();
                for (Circle c2 : circles) {
                    if (c1 != c2 && c1.equals(c2)) {
                        iterator.remove();
                        break;
                    }
                }
            }

            for (Iterator<Rectangle> iterator = rectangles.iterator(); iterator.hasNext();) {
                Rectangle r1 = iterator.next();
                for (Rectangle r2 : rectangles) {
                    if (r1 != r2 && r1.equals(r2)) {
                        iterator.remove();
                        break;
                    }
                }
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mainFrame.repaint();
        }
    }

    class DrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

            for (Circle c: circles) {
                c.draw(graphics);
            }

            for (Rectangle r: rectangles) {
                r.draw(graphics);
            }
        }
    }
}
