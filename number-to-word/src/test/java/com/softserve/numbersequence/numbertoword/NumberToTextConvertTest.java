package com.softserve.numbersequence.numbertoword;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author Artem on 05.08.2018
 */
@RunWith(Parameterized.class)
public class NumberToTextConvertTest {

    private long actualNumber;
    private String expected;

    public NumberToTextConvertTest(long actual, String expected) {
        this.actualNumber = actual;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "один"},
                {-3, "минус три"},
                {14, "четырнадцать"},
                {-18, "минус восемнадцать"},
                {101, "сто один"},
                {-123, "минус сто двадцать три"},
                {1657, "одна тысяча шестьсот пятьдесят семь"},
                {-8542, "минус восемь тысяч пятьсот сорок два"},
                {98765, "девяносто восемь тысяч семьсот шестьдесят пять"},
                {-56437, "минус пятьдесят шесть тысяч четыреста тридцать семь"},
                {777888, "семьсот семьдесят семь тысяч восемьсот восемьдесят восемь"},
                {-433367, "минус четыреста тридцать три тысячи триста шестьдесят семь"},
                {7891234,"семь миллионов восемьсот девяносто одна тысяча двести тридцать четыре"},
                {987654321,"девятьсот восемьдесят семь миллионов шестьсот пятьдесят четыре тысячи триста двадцать один"},
                {97531246810L, "девяносто семь миллиардов пятьсот тридцать один миллион двести сорок шесть тысяч " +
                        "восемьсот десять"},
                {-975312468101L, "минус девятьсот семьдесят пять миллиардов триста двенадцать миллионов " +
                        "четыреста шестьдесят восемь тысяч сто один"},
                {975313456789L, "девятьсот семьдесят пять миллиардов триста тринадцать миллионов " +
                        "четыреста пятьдесят шесть тысяч семьсот восемьдесят девять"},
        });

    }

    @Test
    public void wordsRus() {
        String actual = NumberToText.WordsRus(actualNumber);
        assertEquals(expected, actual);
    }
}