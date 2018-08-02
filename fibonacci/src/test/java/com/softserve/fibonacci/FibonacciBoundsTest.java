package com.softserve.fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author Artem on 01.08.2018
 */
@RunWith(Parameterized.class)
public class FibonacciBoundsTest {
    private int minBound;
    private int maxBound;
    private String expected;

    public FibonacciBoundsTest(int minBound, int maxBound, String expected) {
        this.minBound = minBound;
        this.maxBound = maxBound;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 100, "1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89"},
                {100, 999, "144, 233, 377, 610, 987"},
                {1000, 1000000,
                        "1597, 2584, 4181, 6765, 10946, 17711, 28657, "
                                + "46368, 75025, 121393, 196418, 317811, 514229, 832040"},
                {1, 2, "1, 1, 2"}
        });
    }

    @Test
    public void getFibonacciNumbers() {
        assertEquals(expected, Fibonacci.getFibonacciNumbers(minBound, maxBound));
    }
}