import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit> {

    private ArrayList<T> fruitArray;

    public Box (T... fruits) {
        this.fruitArray = new ArrayList<>(Arrays.asList(fruits));
    }

    public ArrayList<T> getFruits() {
        return fruitArray;
    }

    public boolean compare(Box secondBox) {
        return this.getWeight() == secondBox.getWeight();
    }

    public void addFruit(T... fruits) {
        fruitArray.addAll(Arrays.asList(fruits));
    }

    public double getWeight() {
        if (fruitArray.size() == 0) {
            return 0;
        }
        return fruitArray.size() * fruitArray.get(0).getWeight();
    }

    public void pourOver(Box<T> secondBox) {
        secondBox.fruitArray.addAll(this.fruitArray);
        this.fruitArray.clear();
    }

}
