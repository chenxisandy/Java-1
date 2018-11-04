/*
 * exercise 1-2
 */

import java.lang.Math;
import java.util.Collections;

public class Test3 {

    public static void main(String[] args) {
        // Uncomment the code below when finished
        abstract class Point {
            protected int px; // position in x
            protected int py; // position in y

            protected int greyscale;

            /*
             * Return the euclidean distance between this point
             * and another point p
             * @param p another point
             * @return the euclidean distance
             */
            public abstract double getDistance(Point p);

            /*
             * Return the difference in grayscale between this point
             * and another point p
             * @param p another point
             * @return the grayscale difference
             */
            public abstract int grayscaleDiff(Point p);


        }


        class PointGrey extends Point {
            protected int greyscale; // [0, 255] from black to white

            // TODO: add a constructor for PointGrey
            public PointGrey() {

            }


            public PointGrey(int px, int py, int greyscale) {
                this.greyscale = greyscale;
                super.px = px;
                super.py = py;
            }


            @Override
            public double getDistance(Point p) {

                return Math.sqrt(Math.pow(super.px - p.px, 2) + Math.pow(super.py - p.py, 2));
            }

            @Override
            public int grayscaleDiff(Point p) {
                int result;
                result = Math.abs(this.greyscale - p.greyscale);
                return result; // to be replaced
            }

        }

        class PointColor extends PointGrey {

            public PointColor(int px, int py, int redScale, int greenScale, int blueScale) {
                super.greyscale = (redScale + greenScale + blueScale) / 3;
                super.px = px;
                super.py = py;
            }
        }


        Point p1 = new PointGrey(10, 50, 100);
        Point p2 = new PointGrey(100, 50, 255);
        Point p3 = new PointColor(50, 50, 255, 0, 0);
        Point p4 = new PointColor(150, 20, 0, 0, 255);

        Point[] plist = {p1, p2, p3};
        System.out.println("The euclidean distance between p4 and p1,p2,p3 are:");
        for (Point p : plist) {
            System.out.println(p4.getDistance(p));
        }

        System.out.println("The grayscale difference between p4 and p1,p2,p3 are:");
        for (Point p : plist) {
            System.out.println(p4.grayscaleDiff(p));
        }

    }



}
