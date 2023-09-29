
public class Main {
    public static void main(String[] args) {

        Box<Apple> firstBox = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Apple> secondBox = new Box<>();
        Box<Orange> thirdBox = new Box<>(new Orange(), new Orange(), new Orange());

        System.out.println("\nFirst apple box weight = " + firstBox.getWeight() + "\n" +
                "Second apple box weight = " + secondBox.getWeight() + "\n" +
                "Third orange box weight = " + thirdBox.getWeight());

        secondBox.addFruit(new Apple(), new Apple());
        System.out.println("\nSecond apple box weight when we put 2 apple in box = " + secondBox.getWeight());


        System.out.println("\nIs the Second box compare to First box? It is " + secondBox.compare(firstBox));
        System.out.println("Is the Second box compare to Third box? It is " + secondBox.compare(thirdBox));

        firstBox.pourOver(secondBox);
        System.out.println("\nFirst box weight after pour over = " + firstBox.getWeight());
        System.out.println("Second box weight after pour over = " + secondBox.getWeight());

    }
}