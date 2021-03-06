package com.softserve.numbersequence.envelopes;

public class Envelope implements Comparable<Envelope> {
    private double sideA;
    private double sideB;

    private Envelope(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    /**
     * Checks if envelop is valid.
     *
     * @param sideAStr- one side of envelop
     * @param sideBStr  - other side of envelop
     * @return boolean value
     */
    public static boolean isCorrectEnvelopSize(String sideAStr, String sideBStr) {
        if (sideAStr.length() == 0 || sideBStr.length() == 0) return false;
        try {
            double sideA = Double.parseDouble(sideAStr);
            double sideB = Double.parseDouble(sideBStr);
            if (sideA <= 0 || sideB <= 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect size of Envelop");
        }
        return true;
    }

    /**
     * Prints envelop's info.
     *
     * @param sideA - string that represents length of side A
     * @param sideB - string that represents length of side B
     */
    public static Envelope getEnvelope(String sideA, String sideB) {
        if (isCorrectEnvelopSize(sideA, sideB)) {
            double A = Double.parseDouble(sideA);
            double B = Double.parseDouble(sideB);
            return new Envelope(A, B);
        } else {
            throw new IllegalArgumentException("Incorrect size of Envelop");
        }
    }

    /**
     * Compare two envelopes.
     *
     * @param envelope - envelope to compare
     */
    @Override
    public int compareTo(Envelope envelope) {
        if ((getSideA() > envelope.getSideA() && getSideB() > envelope.getSideB())
                || (getSideA() < envelope.getSideA() && getSideB() < envelope.getSideB())) {
            return 1;
        }
        changeOrientation();
        if ((getSideA() > envelope.getSideA() && getSideB() > envelope.getSideB())
                || (getSideA() < envelope.getSideA() && getSideB() < envelope.getSideB())) {
            return -1;
        }
        return 0;
    }

    /**
     * Change orientation this Envelope
     * side A becomes side B and viceversa
     */
    private void changeOrientation() {
        double tmpSideA = getSideA();
        setSideA(getSideB());
        setSideB(tmpSideA);
    }

    /**
     * Prints envelop's info.
     *
     * @param envelope1 - first envelop
     * @param envelope2 - second envelop
     */
    public static void compareEnvelopes(Envelope envelope1, Envelope envelope2) {
        if (envelope1.compareTo(envelope2) != 0) {
            System.out.println("You can put one envelop to another");
        } else {
            System.out.println("You can't put one envelop to another.");
        }
    }

    /**
     * Checks if answer is positive or negative.
     *
     * @param answer - user's answer.
     * @return boolean value (true or false).
     */
    public static boolean isContinue(String answer) {
        if (answer.equalsIgnoreCase("yes")
                || answer.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }


}
