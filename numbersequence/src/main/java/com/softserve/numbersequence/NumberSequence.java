package com.softserve.numbersequence;

public class NumberSequence {
    public static void main(String[] args) {
        final int length;
        final int minSquare;

        try {
            length = Integer.parseInt(args[0]);
            minSquare = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Error, please input correct params");
            printHelp();
            return;
        }
        String result = getNumberSequence(length, minSquare);
        System.out.println(result);
    }

    private static void printHelp() {
        System.out.println("Выводит через запятую ряд длиной n, состоящий из натуральных чисел, квадрат которых не меньше заданного m.\n"
                + "Входные параметры: длина и значение минимального квадрата.\n"
                + "Выход: строка с рядом чисел.\n"
                + "Example:\n"
                + "java com.softserve.numbersequence.NumberSequence 8 10");
    }

    public static String getNumberSequence(int length, int minSquare) {
        if (length == 0 && minSquare == 0) return "";
        if (length <= 0 || minSquare < 0) throw new IllegalArgumentException("Данные должны быть положительными");
        StringBuilder sb = new StringBuilder();
        for (int i = 0, count = 0; count != length; i++) {
            if (i * i >= minSquare) {
                sb.append(i).append(", ");
                count++;
            }
        }
        return sb.delete(sb.length() - 2, sb.length()).toString();
    }
}

