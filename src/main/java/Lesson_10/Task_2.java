package Lesson_10;

public class Task_2 {
    interface Shape {
        double calculateArea();
        double calculatePerimeter();

        default double getPerimeter() {
            return calculatePerimeter();
        }

        // Дефолтные методы для расчета площади
        default double getArea() {
            return calculateArea();
        }

        String getFillColor();
        String getBorderColor();
    }

    class Circle implements Shape {
        private double radius;
        private String fillColor;
        private String borderColor;

        public Circle(double radius, String fillColor, String borderColor) {
            this.radius = radius;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    class Rectangle implements Shape {
        private double width;
        private double height;
        private String fillColor;
        private String borderColor;

        public Rectangle(double width, double height, String fillColor, String borderColor) {
            this.width = width;
            this.height = height;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculateArea() {
            return width * height;
        }

        @Override
        public double calculatePerimeter() {
            return 2 * (width + height);
        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    class Triangle implements Shape {
        private double a, b, c; // Стороны треугольника
        private String fillColor;
        private String borderColor;

        public Triangle(double a, double b, double c, String fillColor, String borderColor) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.fillColor = fillColor;
            this.borderColor = borderColor;
        }

        @Override
        public double calculateArea() {
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        @Override
        public double calculatePerimeter() {
            return a + b + c;
        }

        @Override
        public String getFillColor() {
            return fillColor;
        }

        @Override
        public String getBorderColor() {
            return borderColor;
        }
    }

    public class GeometryCalculator {
        public void main(String[] args) {
            Shape circle = new Circle(5.0, "Red", "Black");
            Shape rectangle = new Rectangle(4.0, 6.0, "Blue", "Green");
            Shape triangle = new Triangle(3.0, 4.0, 5.0, "Yellow", "Purple");

            printShapeDetails(circle);
            printShapeDetails(rectangle);
            printShapeDetails(triangle);
        }

        private void printShapeDetails(Shape shape) {
            System.out.println("Фигура: " + shape.getClass().getSimpleName());
            System.out.printf("Площадь: %.2f\n", shape.getArea());
            System.out.printf("Периметр: %.2f\n", shape.getPerimeter());
            System.out.println("Цвет заливки: " + shape.getFillColor());
            System.out.println("Цвет границы: " + shape.getBorderColor());
            System.out.println();
        }
    }
}
