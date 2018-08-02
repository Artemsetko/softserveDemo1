package com.softserve.numbersequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Artem on 01.08.2018
 */
public class NumberSequenceTest {

    @Test
    public void testGetCorrectNumberSequence() {
        String actual = NumberSequence.getNumberSequence(10, 20);
        String expected = "5, 6, 7, 8, 9, 10, 11, 12, 13, 14";
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIncorrectNumberSequence() {
        String actual = NumberSequence.getNumberSequence(-1, -1);
    }

    @Test
    public void testGetEmptyNumberSequence() {
        String actual = NumberSequence.getNumberSequence(0, 0);
        String expected = "";
        assertEquals(expected, actual);
    }
}