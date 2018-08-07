package com.softserve.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Artem on 07.08.2018
 */
public class App {
    public static void main(String[] args) {
        runApplication();
    }

    /**
     * runs the application.
     */
    public static void runApplication() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please, enter two integer parametrs, which represents fibonacci bounds");
        try {
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            System.out.println(Fibonacci.getFibonacciNumbers(a, b));
            System.out.println("\nPlease, enter integer parametr, which represent length of fibonacci numbers");
            int length = Integer.parseInt(reader.readLine());
            System.out.println(Fibonacci.getFibonacciNumbers(length));
        } catch (IOException e) {
            System.out.println("Error, Try again");
        }
    }
}
