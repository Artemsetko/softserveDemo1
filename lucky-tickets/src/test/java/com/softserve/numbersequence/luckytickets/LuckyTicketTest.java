package com.softserve.numbersequence.luckytickets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Artem on 31.07.2018
 */
public class LuckyTicketTest {

    @Test
    public void createObjectValidNumber() {
        //Arrange
        String expectedMinNumber = "123456";
        String expectedMaxNumber = "654321";
        //Act
        LuckyTicket luckyTicket = LuckyTicket.getInstance("123456", "654321");
        //Assert
        assertEquals(expectedMinNumber, luckyTicket.getMinNumber());
        assertEquals(expectedMaxNumber, luckyTicket.getMaxNumber());
    }

    @Test(expected = NumberFormatException.class)
    public void createObjectNumbersMoreThanSix() {
        //Arrange
        String givenMinNumber = "12345678";
        String givenMaxNumber = "87654321";

        //Act
        LuckyTicket ticket = LuckyTicket.getInstance(givenMinNumber, givenMaxNumber);

    }

    @Test(expected = IllegalArgumentException.class)
    public void create_InCorrect_Tickets_With_Wrong_Order_Numbers_Object() {
        //Arrange
        String givenMinNumber = "654321";
        String givenMaxNumber = "123456";
        //Act
        LuckyTicket luckyTicket = LuckyTicket.getInstance(givenMinNumber, givenMaxNumber);

    }

    @Test(expected = NumberFormatException.class)
    public void createNegativeObject() {
        //Arrange
        String givenMinNumber = "-123456";
        String givenMaxNumber = "-654321";

        //Act
        LuckyTicket ticket = LuckyTicket.getInstance(givenMinNumber, givenMaxNumber);

    }

    @Test
    public void getNumberOfSimpleLuckyTickets() {
        int actual = LuckyTicket.getInstance("000000", "999999").getNumberOfSimpleLuckyTickets();
        int expected = 55252;
        assertEquals(actual, expected);
    }

    @Test
    public void getNumberOfComplexLuckyTickets() {
        int actual = LuckyTicket.getInstance("000000", "999999").getNumberOfComplexLuckyTickets();
        int expected = 25081;
        assertEquals(actual, expected);
    }
}