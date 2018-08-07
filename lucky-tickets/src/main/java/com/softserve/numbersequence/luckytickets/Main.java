package com.softserve.numbersequence.luckytickets;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            LuckyTicket.printInfo();
        } else {
            LuckyTicket luckyTicket = LuckyTicket.getInstance(args[0], args[1]);
            int countSimple = LuckyTicketsCounter.getNumberOfSimpleLuckyTickets(luckyTicket);
            int countComplex = LuckyTicketsCounter.getNumberOfComplexLuckyTickets(luckyTicket);
            LuckyTicket.printLuckyStatistics(countSimple, countComplex);
        }
    }

}
