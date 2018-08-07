package com.softserve.numbersequence.luckytickets;

import java.util.regex.Pattern;

public class LuckyTicket {

    private String minNumber;
    private String maxNumber;

    private LuckyTicket(String minNumber, String maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
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
     * Simple method that counts lucky tickets within a range in a specific way: if sum of left 3
     * numbers equals to sum of right 3 numbers of a ticket number, then the ticket is lucky
     *
     * @return Number of found lucky tickets
     */
    public int getNumberOfSimpleLuckyTickets() {
        int minNumber = Integer.parseInt(getMinNumber());
        int maxNumber = Integer.parseInt(getMaxNumber());
        int totalAmount = 0;
        for (int i = minNumber; i <= maxNumber; i++) {
            int i1 = i / 100000 % 10,
                    i2 = i / 10000 % 10,
                    i3 = i / 1000 % 10,
                    i4 = i / 100 % 10,
                    i5 = i / 10 % 10,
                    i6 = i % 10;
            if ((i1 + i2 + i3) == (i4 + i5 + i6)) {
                totalAmount++;
            }
        }
        return totalAmount;
    }

    /**
     * Complicated method - if the sum of even numbers of the ticket is equal
     * to the sum of odd numbers of the ticket,
     * then the ticket is considered to be lucky.
     * @return Number of found lucky tickets
     */
    public int getNumberOfComplexLuckyTickets() {
        int minNumber = Integer.parseInt(getMinNumber());
        int maxNumber = Integer.parseInt(getMaxNumber());
        int totalAmount = 0;
        for (int i = minNumber; i <= maxNumber; i++) {
            String checkNumber = String.valueOf(i);
            char[] numberArray = checkNumber.toCharArray();
            int evenSum = 0;
            int oddSum = 0;
            for (char symbol : numberArray) {
                if (((int) symbol) % 2 == 0) {
                    evenSum += Character.getNumericValue(symbol);
                } else {
                    oddSum += Character.getNumericValue(symbol);
                }
            }
            if (evenSum == oddSum) {
                totalAmount++;
            }
        }
        return totalAmount;
    }

    public String getMinNumber() {
        return minNumber;
    }

    public String getMaxNumber() {
        return maxNumber;
    }


}



