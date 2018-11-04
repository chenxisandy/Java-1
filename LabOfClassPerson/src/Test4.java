import static java.lang.Math.PI;

public class Test4 {

    public static void main(String[] args) {
        Shape s1 = new Rectangle(10, 5);
        // Uncomment the code below when finished
        Shape s2 = new Circle(2);

        System.out.println("The size is " + s1.getArea());
        System.out.println("The size is " + s2.getArea());
    }


    public static abstract class Shape {

        public abstract double getArea();

    }


    public static class Rectangle extends Shape {
        private int width;
        private int height;

        public Rectangle(int w, int h) {
            this.width = w;
            this.height = h;
        }

        @Override
        public double getArea() {
            double area = this.height * this.width;
            return area;
        }

    }

    public static class Circle extends Shape {
        private int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            double area = this.radius * this.radius * PI;
            return area;
        }
    }


}

