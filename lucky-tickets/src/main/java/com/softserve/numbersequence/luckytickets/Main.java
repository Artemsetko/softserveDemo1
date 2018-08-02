package com.softserve.numbersequence.luckytickets;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            printInfo();
        } else {
            LuckyTicket luckyTicket = LuckyTicket.getInstance(args[0], args[1]);
            int countSimple = luckyTicket.getNumberOfSimpleLuckyTickets();
            int countComplex = luckyTicket.getNumberOfComplexLuckyTickets();
            if (countSimple > countComplex) {
                System.out.println("Simple method win: " + countSimple + " vs. " + countComplex);
            } else if (countComplex > countSimple) {
                System.out.println("Complex method win: " + countComplex + " vs. " + countSimple);
            } else {
                System.out.println("Both methods are equals");
            }
        }
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
}
