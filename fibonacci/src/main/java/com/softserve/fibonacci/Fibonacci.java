package com.softserve.fibonacci;

public class Fibonacci {

    /**
     * Prints fibonacci numbers.
     *
     * @param length number - length of Fibonacci numbers
     */
    public static String getFibonacciNumbers(int length) {
        if (length <= 0) throw new IllegalArgumentException("please enter positive length");
        long previousFirst = 1;
        long previousSecond = 1;
        long sum = 0;
        String result = "";
        if (length == 1) {
            result = previousFirst + ", " + previousSecond + ", ";
        }
        StringBuilder sb = new StringBuilder();
        while (sum <= Long.MAX_VALUE) {
            sum = previousFirst + previousSecond;
            if (getLengthOfNumber(sum) == length) {
                sb.append(sum).append(", ");
            } else if (getLengthOfNumber(sum) > length) {
                break;
            }
            previousFirst = previousSecond;
            previousSecond = sum;
        }
        result = result + sb.delete(sb.length() - 2, sb.length()).toString();
        return result;
    }

    /**
     *
     * @param number - number to find its length
     * @return length of number
     */
    private static int getLengthOfNumber(long number) {
        return (int) Math.ceil(Math.log10(number + 0.5));
    }

    /**
     * Prints fibonacci numbers.
     *
     * @param a number - first bound
     * @param b number - second bound
     */
    public static String getFibonacciNumbers(int a, int b) {
        if (a >= b) throw new IllegalArgumentException("please enter first parametr less than second one");
        int previousFirst = 1;
        int previousSecond = 1;
        String result = "";
        if (previousFirst >= a) {
            result = previousFirst + ", " + previousSecond + ", ";
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while (previousSecond <= b) {
            sum = previousFirst + previousSecond;
            if (sum >= a && sum <= b) {
                sb.append(sum).append(", ");
            }
            previousFirst = previousSecond;
            previousSecond = sum;
        }
        result = result + sb.delete(sb.length() - 2, sb.length()).toString();
        return result;
    }
}
