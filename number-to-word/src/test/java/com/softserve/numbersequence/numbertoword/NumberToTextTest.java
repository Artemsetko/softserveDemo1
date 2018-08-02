package com.softserve.numbersequence.numbertoword;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Artem on 01.08.2018
 */
public class NumberToTextTest {

    @Test
    public void testswordsRusCorrectArgument() {
        String actual = NumberToText.WordsRus(123456789012345L);
        String expected = "сто двадцать три триллиона четыреста пятьдесят шесть миллиардов"
                + " семьсот восемьдесят девять миллионов двенадцать тысяч триста сорок пять ";
        assertEquals(expected, actual);

    }

    @Test
    public void testswordsRusInCorrectLargeArgument() {
        String actual = NumberToText.WordsRus(123456789012345000L);
        String expected = "Число выходит за рамки указанного диапазона";
        assertEquals(expected, actual);

    }

    @Test
    public void testswordsRusInCorrectNegativeLargeArgument() {
        String actual = NumberToText.WordsRus(-123456789012345000L);
        String expected = "Число выходит за рамки указанного диапазона";
        assertEquals(expected, actual);

    }


    @Test
    public void testswordsRusZeroArgument() {
        String actual = NumberToText.WordsRus(0);
        String expected = "ноль ";
        assertEquals(expected, actual);

    }

    @Test
    public void testswordsRusCorrectNegativeArgument() {
        String actual = NumberToText.WordsRus(-999999999999999L);
        String expected = "минус девятьсот девяносто девять триллионов девятьсот девяносто девять миллиардов девятьсот девяносто девять миллионов"
                + " девятьсот девяносто девять тысяч девятьсот девяносто девять ";
        assertEquals(expected, actual);

    }
}