import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Layer {
    private List<Shape> shapes = new ArrayList<Shape>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * javadoc.
     */
    public String getInfo() {
        StringBuilder info = new StringBuilder("Layer of crazy shapes:\n");
        for (Shape shape : shapes) {
            info.append(String.format("%s\n", shape.toString()));
        }
        return info.toString();
    }

    /**
     * javadoc.
     */
    public void removeCircles() {
        List<Shape> nonCircles = new ArrayList<>();
        for (Shape shape : shapes) {
            if (!(shape instanceof Circle)) {
                nonCircles.add(shape);
            }
        }
        shapes = nonCircles;
    }

    /**
     * javadoc.
     */
    public void removeDuplicates() {
        Set<Shape> uniqueShapes = new HashSet<>();
        List<Shape> uniqueShapesList = new ArrayList<>();

        for (Shape shape : shapes) {
            if (!uniqueShapes.contains(shape)) {
                uniqueShapes.add(shape);
                uniqueShapesList.add(shape);
            }
        }

        shapes = uniqueShapesList;
    }


}
