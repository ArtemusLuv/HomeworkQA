package Task1;

public class Animal {

    private static int countOfAnimal;
    protected String name;
    public Animal (String name) {
        this.name = name;
        countOfAnimal++;
    }

    public void run(int lengthOfBarrier) {
        if (lengthOfBarrier <= 0) {
            System.out.println("Animal " + name + " cant run " + lengthOfBarrier + " m!");
        } else {
            System.out.println(name + " ran " + lengthOfBarrier + " m.");
        }
    }

    public void swim(int lengthOfBarrier) {
        if (lengthOfBarrier <= 0) {
            System.out.println("Animal " + name + " cant swim " + lengthOfBarrier + " m!");
        } else {
            System.out.println(name + " swam " + lengthOfBarrier + " m.");
        }
    }

    public static int getCountOfAnimal() {
        return countOfAnimal;
    }

}
