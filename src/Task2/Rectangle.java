package Task2;

import java.awt.*;

public class Rectangle implements Figure {
    private int x,y;
    private String colorFill, colorBorder;

    public Rectangle (int x, int y, String colorFill, String colorBorder) {
        this.x = x;
        this.y = y;
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }

    public Rectangle (int x, String colorFill, String colorBorder) {
        this.x = x;
        y = x;
        this.colorFill = colorFill;
        this.colorBorder = colorBorder;
    }

    @Override
    public String getColorFill() {
        return colorFill;
    }

    @Override
    public String getColorBorder() {
        return colorBorder;
    }

    @Override
    public double getArea() {
        return x * y;
    }

    @Override
    public double getPerimeter() {
        return 2 * x + 2 * y;
    }

}
