package Task1;

public class Dog extends Animal {

    private static int countOfDog;

    public Dog(String name) {
        super(name);
        countOfDog++;
    }

    @Override
    public void swim(int lengthOfBarrier) {
        if (lengthOfBarrier > 10 || lengthOfBarrier <= 0) {
            System.out.println("Dog " + name + " cant swim " + lengthOfBarrier + " m!");
        } else {
            System.out.println("Dog " + name + " swam " + lengthOfBarrier + " m.");
        }
    }

    @Override
    public void run(int lengthOfBarrier) {
        if (lengthOfBarrier > 500 || lengthOfBarrier <= 0) {
            System.out.println("Dog " + name + " cant run " + lengthOfBarrier + " m!");
        } else {
            System.out.println("Dog " + name + " ran " + lengthOfBarrier + " m.");
        }
    }

    public static int getCountOfDog() {
        return countOfDog;
    }

    public String getName() {
        return name;
    }

}
