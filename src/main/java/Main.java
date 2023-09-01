/*
 *   To uncomment select all text with // and use ctrl + /
 */

public class Main {
    public static void main(String[] args) {

            // Task 6
        int [] array = {1, 1, 1, 0, 0, 1};
//        for (int i:array) {
//            System.out.println(i);
//        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            }
        }
//        for (int i:array) {
//            System.out.println(i);
//        }

        // Task 7
        int [] secondArray = new int[100];
//        System.out.println(secondArray.length);
//        for (int i:secondArray) {
//            System.out.println(i);
//        }
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = i +1;
        }
//        for (int i:secondArray) {
//            System.out.println(i);
//        }

        // Task 8
        int [] thirdArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        for (int i: thirdArray) {
//            System.out.println(i);
//        }
        for (int i = 0; i < thirdArray.length; i++) {
            if (thirdArray[i] < 6) {
                thirdArray[i] *= 2;
            }
        }
//        for (int i: thirdArray) {
//            System.out.println(i);
//        }

        // Task 9
        int [][] matrix = new int[9][9];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else if (j == (matrix.length - 1) - i) {
                    matrix[i][(matrix.length - 1) - i] = 1;
                }
            }
        }

//        for (int i = 0; i < matrix.length; i++) {
//            System.out.println();
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(matrix[i][j]);
//            }
//        }

        // for Task 10
//        int [] array1 = createArray(3,10);
//        for (int i = 0; i < array1.length; i++){
//            System.out.print(array1[i] + " ");
//        }
    }


    // Task 1
    static boolean checkSumOfNumbers(int firstNumber, int secondNumber) {
//        if (firstNumber + secondNumber <= 20 && firstNumber + secondNumber >= 10) {
//            return true;
//        } else {
//            return false;
//        }
        boolean result = (firstNumber + secondNumber <= 20 && firstNumber + secondNumber >= 10) ? true : false;
        return result;
    }

    // Task 2
    static void checkSignOfNumber(int number) {
//        if (number >= 0) {
//            System.out.println("Your number is positive");
//        } else {
//            System.out.println("Your number is negative");
//        }
        String result = (number >= 0) ? "Your number is positive" : "Your number is negative";
        System.out.println(result);
    }

    // Task 3
    static boolean checkSign(int number) {
//        if (number < 0) {
//            return true;
//        } else {
//            return false;
//        }
        boolean result = (number < 0) ? true : false;
        return result;
    }

    // Task 4
    static void printString(int printQuantity, String str) {
        if (printQuantity > 0) {
            for (int i = 0; i < printQuantity; i++) {
                System.out.println(str);
            }
        } else {
            System.out.println("Number for print your str must was more than zero!");
        }
    }

    // Task 5
    static boolean checkYear(int year) {
//        if ((year % 4 == 0 && year != 100) || (year % 400 == 0 && year != 100)) {
//            return true;
//        } else {
//            return false;
//        }
        boolean result = ((year % 4 == 0 && year != 100) || (year % 400 == 0 && year != 100)) ? true : false;
        return result;
    }

    // Task 10
    static int[] createArray(int len, int initialValue) {
        int [] someArray = new int[len];
        for (int i = 0; i < someArray.length; i++) {
            someArray[i] = initialValue;
        }
        return someArray;
    }

}