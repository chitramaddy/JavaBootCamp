package com.company.abstractapproach;

public class App {

    public static void main(String[] args) {
        Circle c1 = new Circle(7);
        Square s1 = new Square(4);
        Triangle t1 = new Triangle(3, 4, 5);

        System.out.format("The name of the circle is %s.\n", c1.getName());
        System.out.format("The name of the square is %s.\n", s1.getName());
        System.out.format("The name of the triangle is %s.\n\n", t1.getName());

        double areaOfCircle = c1.area();
        System.out.format("Area of the circle is %.2f sq.units.\n", areaOfCircle);

        double perimeterOfCircle = c1.perimeter();
        System.out.format("Perimeter of the circle is %.2f units.\n\n", perimeterOfCircle);

        double areaOfSquare = s1.area();
        System.out.format("Area of the square is %.2f sq. units.\n", areaOfSquare);

        double perimeterOfSquare = s1.perimeter();
        System.out.format("Perimeter of the square is %.2f units.\n\n", perimeterOfSquare);

        double areaOfTriangle = t1.area();
        System.out.format("Area of the triangle is %.2f sq. units.\n", areaOfTriangle);

        double perimeterOfTriangle = t1.perimeter();
        System.out.format("Perimeter of the triangle is %.2f units. \n\n", perimeterOfTriangle);
    }

}



