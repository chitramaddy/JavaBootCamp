package com.company.interfaceapproach;

public class App {
    public static void main(String[] args) {
        Circle c1 = new Circle(3);
        Square s1 = new Square(10);
        Triangle t1 = new Triangle(4, 2, 3);

        double areaOfCircle = c1.area();
        System.out.format("Area of the circle is %.2f sq.units.\n", areaOfCircle);

        double perimeterOfCircle = c1.perimeter();
        System.out.format("Perimeter of the circle is %.2f units.\n", perimeterOfCircle);

        double areaOfSquare = s1.area();
        System.out.format("Area of the square is %.2f sq. units.\n", areaOfSquare);

        double perimeterOfSquare = s1.perimeter();
        System.out.format("Perimeter of the square is %.2f units.\n", perimeterOfSquare);

        double areaOfTriangle = t1.area();
        System.out.format("Area of the triangle is %.2f sq. units.\n", areaOfTriangle);

        double perimeterOfTriangle = t1.perimeter();
        System.out.format("Perimeter of the triangle is %.2f units. \n", perimeterOfTriangle);
    }
}
