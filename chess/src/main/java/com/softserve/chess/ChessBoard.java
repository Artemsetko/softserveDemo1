package com.softserve.chess;

class ChessBoard {
    private int height;
    private int width;

    private ChessBoard(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    /**
     * print chessboard.
     */
    void print() throws NullPointerException {
        for (int i = 1; i <= getHeight(); i++) {
            for (int j = 1; j <= getWidth(); j++) {
                if (i % 2 != 0) {
                    if (j % 2 != 0) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    if (j % 2 != 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * get valid ChessBoard Instance.
     *
     * @param args - height and width values which has been entered by user.
     */
    static ChessBoard getInstance(String[] args) {
        if (args == null || args.length != 2) {
            System.out.println("Please, call a class with two parameters: 1 - height,"
                    + " 2 - width of chess board.");
        } else {
            try {
                int height = Integer.parseInt(args[0]);
                int width = Integer.parseInt(args[1]);
                if (height <= 0 || width <= 0) {
                    System.out.println("Please, input correct data");
                }
                return new ChessBoard(height, width);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Incorrect height and weight");
            }
        }
        //default chessboard
        return new ChessBoard(8, 8);
    }
}
