package com.softserve.numbersequence.envelopes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Artem on 07.08.2018
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String txtAnswer;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Envelop 1. Write size a & b:");
            System.out.print("a = ");
            String a1 = reader.readLine();
            System.out.print("b =  ");
            String b1 = reader.readLine();
            Envelope envelope1 = Envelope.getEnvelope(a1, b1);
            System.out.println("Envelop 2. Write size a & b:");
            System.out.print("a = ");
            String a2 = reader.readLine();
            System.out.print("b = ");
            String b2 = reader.readLine();
            Envelope envelope2 = Envelope.getEnvelope(a2, b2);
            Envelope.compareEnvelopes(envelope1, envelope2);
            System.out.println("Would you like to continue?");
            txtAnswer = reader.readLine();
        } while (Envelope.isContinue(txtAnswer));
    }
}
