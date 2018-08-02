package com.softserve.numbersequence.envelopes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author Artem on 29.07.2018
 * @project SoftServeElementaryTasks
 */
@RunWith(Parameterized.class)
public class EnvelopeComparingTest {
    private int envelope1Input;
    private int envelope2Input;

    private int envelope3Input;
    private int envelope4Input;
    private int expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {5, 8, 6, 7, 0}, {5, 4, 100, 1, 0}, {30, 40, 50, 10, 0},
                {8, 10, 6, 7, 1}, {20, 28, 29, 26, -1}
        });
    }

    public EnvelopeComparingTest(int envelope1Input, int envelope2Input, int envelope3Input, int envelope4Input,
                                        int expected) {
        this.envelope1Input = envelope1Input;
        this.envelope2Input = envelope2Input;
        this.envelope3Input = envelope3Input;
        this.envelope4Input = envelope4Input;
        this.expected = expected;
    }

    @Test
    public void comparing_two_Valid_Envelopes() {
          Envelope envelope1 = Envelope.getEnvelope(String.valueOf(envelope1Input), String.valueOf(envelope2Input));
          Envelope envelope2 = Envelope.getEnvelope(String.valueOf(envelope3Input), String.valueOf(envelope4Input));
          assertEquals(expected, envelope1.compareTo(envelope2));
    }
}
