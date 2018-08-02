package com.softserve.numbersequence.trianglesort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Artem on 31.07.2018
 */
public class TriangleTest {

    @Test (expected = NotValidTriangleException.class)
    public void CreateObject_NegativeSides_ExceptionThrown() {
        // Arrange
        double aSide = -2;
        double bSide = -2;
        double cSide = -2;

        // Act
        Triangle.getInstance("first", aSide, bSide, cSide);

        // Assert
    }
    @Test (expected = NotValidTriangleException.class)
    public void CreateObject_NotValidSides_ExceptionThrown() {
        // Arrange
        double aSide = 2;
        double bSide = 2;
        double cSide = 4;

        // Act
        Triangle.getInstance("first", aSide, bSide, cSide);

        // Assert
    }

    @Test
    public void testGetSquare() {
        // Arrange
        Triangle triangle = Triangle.getInstance("first", 3,4,5);
        double expectedSquare = 6.0;

        //Act
        double actualSquare = triangle.getSquare();

        //Assert

        Assert.assertEquals(expectedSquare, actualSquare, 0.00001);
    }
}