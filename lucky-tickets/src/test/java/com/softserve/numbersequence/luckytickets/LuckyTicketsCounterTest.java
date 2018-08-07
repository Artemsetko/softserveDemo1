package com.softserve.numbersequence.luckytickets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Artem on 07.08.2018
 */
public class LuckyTicketsCounterTest {


    @Test
    public void getNumberOfSimpleLuckyTickets() {
        LuckyTicket ticket = LuckyTicket.getInstance("000000", "999999");
        int actual = LuckyTicketsCounter.getNumberOfSimpleLuckyTickets(ticket);
        int expected = 55252;
        assertEquals(actual, expected);
    }

    @Test
    public void getNumberOfComplexLuckyTickets() {
        LuckyTicket ticket = LuckyTicket.getInstance("000000", "999999");
        int actual = LuckyTicketsCounter.getNumberOfComplexLuckyTickets(ticket);
        int expected = 25081;
        assertEquals(actual, expected);
    }

    @Test
    public void getMinNumberOfSimpleLuckyTicketsShouldEqualOne() {
        LuckyTicket ticket = LuckyTicket.getInstance("000001", "001001");
        int actual = LuckyTicketsCounter.getNumberOfSimpleLuckyTickets(ticket);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void getMinNumberOfComplexLuckyTicketsShouldEqualOne() {
        LuckyTicket ticket = LuckyTicket.getInstance("000001", "000112");
        int actual = LuckyTicketsCounter.getNumberOfComplexLuckyTickets(ticket);
        int expected = 1;
        assertEquals(expected, actual);
    }
}