package com.softserve.numbersequence.luckytickets;

import java.util.regex.Pattern;

public class LuckyTicket {

    private String minNumber;
    private String maxNumber;

    private LuckyTicket(String minNumber, String maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    public String getMinNumber() {
        return minNumber;
    }

    public String getMaxNumber() {
        return maxNumber;
    }

    /**
     * Checks if ticket is valid.
     *
     * @param minNumber - minimal number of ticket.
     * @param maxNumber - maximal number of ticket.
     * @return boolean value (true/false).
     */
    public static LuckyTicket getInstance(String minNumber, String maxNumber) {
        Pattern pattern = Pattern.compile("[0-9]{6}");

        if (!pattern.matcher(minNumber).matches() || !pattern.matcher(maxNumber).matches()) {
            throw new NumberFormatException("One or both parameters are incorrect. \n"
                    + "You should enter two numbers: "
                    + "Example: 000001, 131340, 219876 etc.");
        }
        if (Integer.parseInt(maxNumber) < Integer.parseInt(minNumber)) {
            throw new IllegalArgumentException("Error: maxNumber is less than minNumber");
        }
        return new LuckyTicket(minNumber, maxNumber);
    }

    /**
     * Method, which displays the rules of using this program, if there are no arguments passed from
     * the command-line.
     */
    public static void printInfo() {
        System.out.println(
                "This program counts lucky tickets within numerical limits defined by user.\n"
                        + " It counts using two methods at a time: simple and complex.\n"
                        + " You have to enter two valid numbers numbers like in an example: 000001, 131340 etc.\n");
    }

    /**
     * Print statistics of lucky tickets
     *
     * @param countSimple - number of simple lucky tickets
     * @param countComplex - number of complex lucky tickets
     */
    public static void printLuckyStatistics(int countSimple, int countComplex){
        if (countSimple > countComplex) {
            System.out.println("Simple method win: " + countSimple + " vs. " + countComplex);
        } else if (countComplex > countSimple) {
            System.out.println("Complex method win: " + countComplex + " vs. " + countSimple);
        } else {
            System.out.println("Both methods are equals: " + countComplex + " vs. " + countSimple);
        }
    }

}



