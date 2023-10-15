package org.astonqa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @DisplayName("Test case factorial [0;1]")
    @Test
    void isCorrectWorkingWithOneAndZero() {
        assertEquals(1,Factorial.getFactorial(1));
        assertEquals(1,Factorial.getFactorial(0));
    }

    @DisplayName("Test case factorial [2;5]")
    @Test
    void isCorrectWorkingMoreThanOne() {
        assertEquals(2,Factorial.getFactorial(2));
        assertEquals(6,Factorial.getFactorial(3));
        assertEquals(24,Factorial.getFactorial(4));
        assertEquals(120,Factorial.getFactorial(5));
    }

    @DisplayName("Test case factorial < 0")
    @Test
    void isCorrectWorkingWithNegativeNumber() {
        Throwable ex = assertThrows(IllegalArgumentException.class,() -> Factorial.getFactorial(-5));
    }

}