package Task1;

public class Cat extends Animal {

    private boolean hungry;
    private static int countOfCat;

    public Cat(String name) {
        super(name);
        countOfCat++;
    }

    @Override
    public void swim(int lengthOfBarrier) {
        System.out.println("Cat " + name + " cant swim!");
    }

    @Override
    public void run(int lengthOfBarrier) {
        if (lengthOfBarrier > 200 || lengthOfBarrier <= 0) {
            System.out.println("Cat " + name + " cant run " + lengthOfBarrier + " m!");
        } else {
            System.out.println("Cat " + name + " ran " + lengthOfBarrier + " m.");
        }
    }

    public static int getCountOfCat() {
        return countOfCat;
    }

    // Передаем в констуктор экземпляр какой-то тарелки (dish) и кол-во еды (food), которое съест кот
    public void eat(Dish dish, int food) {
        hungry = dish.feed(food);
    }

    public boolean getHungry() {
        return hungry;
    }

    public String getName() {
        return name;
    }

}
