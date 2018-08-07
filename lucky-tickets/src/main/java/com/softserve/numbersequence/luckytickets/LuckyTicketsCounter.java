package com.softserve.numbersequence.luckytickets;

/**
 * @author Artem on 07.08.2018
 */
public class LuckyTicketsCounter {
    /**
     * Simple method that counts lucky tickets within a range in a specific way: if sum of left 3
     * numbers equals to sum of right 3 numbers of a ticket number, then the ticket is lucky
     *
     * @param ticket - object that contains min and max numbers of tickets
     * @return Number of found lucky tickets
     */
    public static int getNumberOfSimpleLuckyTickets(LuckyTicket ticket) {
        int minNumber = Integer.parseInt(ticket.getMinNumber());
        int maxNumber = Integer.parseInt(ticket.getMaxNumber());
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
     *
     * @param ticket - object that contains min and max numbers of tickets
     * @return Number of found lucky tickets
     */
    public static int getNumberOfComplexLuckyTickets(LuckyTicket ticket) {
        int minNumber = Integer.parseInt(ticket.getMinNumber());
        int maxNumber = Integer.parseInt(ticket.getMaxNumber());
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
}
