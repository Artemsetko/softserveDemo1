package com.softserve.chess;

import com.softserve.chess.ChessBoard;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Artem on 30.07.2018
 */
public class ChessBoardTest {

    @Test
    public void testGetDefaultInstance() {

        String[] args = null;
        ChessBoard chessBoard = ChessBoard.getInstance(args);
        int actualHeight = chessBoard.getHeight();
        int actualWidth = chessBoard.getWidth();
        int expectedHeight = 8;
        int expectedWidth = 8;

        Assert.assertEquals(expectedHeight, actualHeight);
        Assert.assertEquals(expectedWidth, actualWidth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetInstanceStringIncorectArguments() {

        String[] args = {"a", "b"};
        ChessBoard chessBoard = ChessBoard.getInstance(args);

    }
}