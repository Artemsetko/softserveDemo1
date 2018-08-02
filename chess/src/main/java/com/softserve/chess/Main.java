package com.softserve.chess;/*
*
      Шахматная доска
Вывести шахматную доску с заданными размерами высоты и ширины, по принципу:
*  *  *  *  *  *
  *  *  *  *  *  *
*  *  *  *  *  *
  *  *  *  *  *  *
Программа запускается через вызов главного класса с параметрами.
* */


import com.softserve.chess.ChessBoard;

public class Main {
    /**
     * run Main App.
     */
    public static void main(String[] args) {
        try {
            ChessBoard chessBoard = ChessBoard.getInstance(args);
            chessBoard.print();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}

