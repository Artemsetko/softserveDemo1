package com.softserve.numbersequence.trianglesort;

import java.util.Objects;

public class Triangle {
    private String name;
    private double sideA;
    private double sideB;
    private double sideC;

    private Triangle(String name, double sideA, double sideB, double sideC) {
        this.name = name;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * get Valid Triangle instance
     *
     * @param name - name of Triangle
     * @param sideA - length of side A of triangle
     * @param sideB - length of side B of triangle
     * @param sideC - length of side C of triangle
     * @return Triangle instance
     */
    public static Triangle getInstance(String name, double sideA, double sideB, double sideC) {
        if (isValidTriangle(sideA, sideB, sideC) && name.length() != 0){
            return new Triangle(name, sideA, sideB, sideC);
        } else {
            throw new NotValidTriangleException();
        }
    }

    public String getName() {
        return name;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    /**
     * Checks if triangle is valid.
     *
     * @param sideA - first triangle's side.
     * @param sideB - second triangle's side.
     * @param sideC - third triangle's side.
     * @return - boolean value(true or false)
     */

    private static boolean isValidTriangle(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            return false;
        } else if (((sideA + sideB) <= sideC) || ((sideA + sideC) <= sideB)
                || ((sideB + sideC) <= sideA)) {
            return false;
        }
        return true;
    }

    /**
     * Gets square of triangle by Heron's formula.
     *
     * @return square of triangle.
     */

    public double getSquare() {
        double p = (getSideA() + getSideB() + getSideC()) / 2;
        return Math.sqrt(p * (p - getSideA()) * (p - getSideB()) * (p - getSideC()));
    }

  /**
     * Equals triangles
     *
     * @param o - other triangle
     * @return boolean value(true/false)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.sideA, sideA) == 0 &&
                Double.compare(triangle.sideB, sideB) == 0 &&
                Double.compare(triangle.sideC, sideC) == 0 &&
                Objects.equals(name.toLowerCase(), triangle.name.toLowerCase());
    }

    /**
     * Gets hashcode
     *
     * @return hashcode value
     */
    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), sideA, sideB, sideC);
    }


}
