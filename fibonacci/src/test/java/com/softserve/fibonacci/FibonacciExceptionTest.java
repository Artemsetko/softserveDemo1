package com.softserve.fibonacci;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Artem on 01.08.2018
 */
public class FibonacciExceptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void getFibonacciFirstArgMoreThanSecond() {
        Fibonacci.getFibonacciNumbers(10, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFibonacciNumbersEqualsArgs() {
        Fibonacci.getFibonacciNumbers(2, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFibonacciZeroLength() {
        Fibonacci.getFibonacciNumbers(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFibonacciNegativeLength() {
        Fibonacci.getFibonacciNumbers(-5);
    }
}