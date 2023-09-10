import Task1.Cat;
import Task1.Dish;
import Task2.Circle;
import Task2.Rectangle;
import Task2.Triangle;

public class Main {
    public static void main(String[] args) {

        // Check Task 1
        Dish dish = new Dish(100);
        Cat [] cats = {new Cat("Vasya"), new Cat("Petya"), new Cat("Jack"), new Cat("Alex")};
        cats[0].eat(dish,10);
        cats[1].eat(dish,50);
        cats[2].eat(dish, 40);
        cats[3].eat(dish,50);
        for (Cat cat : cats) {
            System.out.println(cat.getHungry());
        }

        // Check Task 2
        Circle circle = new Circle(3,"White", "Black");
        System.out.println("\nCircle:");
        circle.getInfo();

        Rectangle rectangle = new Rectangle(2,1,"Black","Orange");
        System.out.println("\nRectangle:");
        rectangle.getInfo();

        Triangle triangle = new Triangle(5,5,3,"Yellow","Purple");
        System.out.println("\nTriangle:");
        triangle.getInfo();
    }
}