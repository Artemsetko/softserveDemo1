package com.softserve.numbersequence.trianglesort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem on 31.07.2018
 */
public class TriangleUtilTest {

    @Test
    public void testSortTriangles() {
        // Arrange
        List<Triangle> actualTriangles = new ArrayList<>();
        actualTriangles.add(Triangle.getInstance("first", 2, 2, 2));
        actualTriangles.add(Triangle.getInstance("second", 4, 4, 4));
        actualTriangles.add(Triangle.getInstance("third", 2.4, 2.4, 2.4));
        actualTriangles.add(Triangle.getInstance("fourth", 6, 6, 6));

        List<Triangle> expectedTriangles = new ArrayList<>();
        expectedTriangles.add(Triangle.getInstance("fourth", 6, 6, 6));
        expectedTriangles.add(Triangle.getInstance("second", 4, 4, 4));
        expectedTriangles.add(Triangle.getInstance("third", 2.4, 2.4, 2.4));
        expectedTriangles.add(Triangle.getInstance("first", 2, 2, 2));
        //Act
        TriangleUtil.sort(actualTriangles);

        //Assert
        Assert.assertEquals(actualTriangles, expectedTriangles);
    }

    @Test
    public void isContinue_ShortPositiveAnswer() {
        //Arrange
        String text = "y";
        boolean expectedAnswer = true;

        //Act
        boolean actualAnswer = TriangleUtil.isContinue(text);

        //Assert
        Assert.assertEquals(actualAnswer, expectedAnswer);

    }

    @Test
    public void isContinue_NegativeAnswer() {
        //Arrange
        String text = "no";
        boolean expectedAnswer = false;

        //Act
        boolean actualAnswer = TriangleUtil.isContinue(text);

        //Assert
        Assert.assertEquals(actualAnswer, expectedAnswer);

    }

    @Test
    public void testDeleteSpaces() {
        String givenString = "      \tname    \t   ";

        String expectedResult = "name";

        Assert.assertEquals(TriangleUtil.deleteSpaces(givenString), expectedResult);
    }
}