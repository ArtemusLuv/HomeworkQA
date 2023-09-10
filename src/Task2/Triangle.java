package Task2;

public class Triangle implements Figure {

    private int x,y,z;
    private String colorFill, colorBorder;

    public Triangle (int x, int y, int z, String colorFill, String colorBorder) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    // Через полупериметр
    @Override
    public double getArea() {
        return Math.sqrt((x + y + z)/2 * ((x + y + z)/2 - x) * ((x + y + z)/2 - y) * ((x + y + z)/2 - z));
    }

    @Override
    public double getPerimeter() {
        return x + y + z;
    }
}
