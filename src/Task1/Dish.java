package Task1;

public class Dish {
    private int food;
    public Dish (int food) {
        if (food < 0) {
            System.out.println("In dish cant was food < 0");
        } else {
            this.food = food;
        }
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean feed(int food) {
        if (this.food - food < 0) {
            return false;
        }
        this.food -= food;
        return true;
    }

}
