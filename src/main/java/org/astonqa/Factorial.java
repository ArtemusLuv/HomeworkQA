package org.astonqa;

public class Factorial {
    public static int getFactorial(int number) {
        if (number == 1 || number == 0) {
            return 1;
        } else if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        } else {
            int k = 1;
            for (int i = 1; i <= number; i++) {
                k = k * i;
            }
            return k;
        }
    }
}
