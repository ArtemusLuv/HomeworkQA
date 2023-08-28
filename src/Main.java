public class Main {
    public static void main(String[] args) {
        // Task 5
        printThreeWords();
        checkSumSigh();
        printColor();
        compareNumbers();
    }

    // Task 1
    static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    // Task 2
    static void checkSumSigh() {
        int a = 478, b = -1285;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Task 3
    static void  printColor() {
        int value = 0;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    // Task 4
    static void compareNumbers() {
        int a = -1, b = 259;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

}