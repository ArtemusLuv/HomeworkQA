package Task2;

import java.awt.*;

interface Figure {

    String getColorFill();
    String getColorBorder();
    double getArea();
    double getPerimeter();
    default void getInfo() {
        System.out.printf("Color fill is " + getColorFill() + "\n" +
                        "Color border is " + getColorBorder() + "\n" +
                        "Area = " + getArea() + "\n" +
                        "Perimeter = " + getPerimeter() + "\n");
    }

}
