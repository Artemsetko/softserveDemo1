package com.softserve.fibonacci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Artem on 01.08.2018
 */
@RunWith(Parameterized.class)
public class FibonacciLengthTest {
    private int length;
    private String expected;

    public FibonacciLengthTest(int length, String expected) {
        this.length = length;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "1, 1, 2, 3, 5, 8"}, {2, "13, 21, 34, 55, 89"}, {3, "144, 233, 377, 610, 987"},
                {4, "1597, 2584, 4181, 6765"}
        });
    }

    @Test
    public void testFibonacciLength(){
        assertEquals(expected, Fibonacci.getFibonacciNumbers(length));
    }
}