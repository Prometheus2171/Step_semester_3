import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Session9PracticeProblem1 {
    private abstract static class Plot {
        private final String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract String shape();

        abstract double area();

        String owner() {
            return owner;
        }
    }

    private static final class CirclePlot extends Plot {
        private final double radius;

        CirclePlot(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        String shape() { return "CIRCLE"; }
        double area() { return Math.PI * radius * radius; }
    }

    private static final class RectanglePlot extends Plot {
        private final double length;
        private final double width;

        RectanglePlot(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        String shape() { return "RECTANGLE"; }
        double area() { return length * width; }
    }

    private static final class TrianglePlot extends Plot {
        private final double base;
        private final double height;

        TrianglePlot(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        String shape() { return "TRIANGLE"; }
        double area() { return 0.5 * base * height; }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Plot> plots = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String shape = scanner.next();
                String owner = scanner.next();
                switch (shape) {
                    case "CIRCLE":
                        plots.add(new CirclePlot(owner, scanner.nextDouble()));
                        break;
                    case "RECTANGLE":
                        plots.add(new RectanglePlot(owner, scanner.nextDouble(), scanner.nextDouble()));
                        break;
                    case "TRIANGLE":
                        plots.add(new TrianglePlot(owner, scanner.nextDouble(), scanner.nextDouble()));
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown plot shape: " + shape);
                }
            }
            double totalArea = 0;
            for (Plot plot : plots) {
                double area = plot.area();
                System.out.printf("%s (%s): %.2f%n", plot.owner(), plot.shape(), area);
                totalArea += area;
            }
            System.out.printf("Total Area: %.2f%n", totalArea);
        }
    }
}