package com.softserve.numbersequence.envelopes;

import org.junit.Test;

/**
 * @author Artem on 29.07.2018
 * @project SoftServeElementaryTasks
 */
public class EnvelopeCreateTest {

    @Test(expected = IllegalArgumentException.class)
    public void getEnvelopeZeroSides() {
        String a = "0";
        String b = "0";
        Envelope.getEnvelope(a, b);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getEnvelopeNegativeSides() {
        String a = "-4";
        String b = "-6";
        Envelope.getEnvelope(a, b);
    }

    @Test(expected = NumberFormatException.class)
    public void getEnvelopeWrongFormatSize() {
        String a = "a";
        String b = "b";
        Envelope.getEnvelope(a, b);
    }
}