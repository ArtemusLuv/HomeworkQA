package org.astonqa;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {

    @DataProvider
    public Object[][] dataForTest() {
        return new Object[][] {
                {-1, 1},
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120}
        };
    }

    @Test(dataProvider =  "dataForTest")
    public void testFactorial(int input, int expected) {
        assertEquals(Factorial.getFactorial(input), expected);
    }

}