package com.softserve.numbersequence.trianglesort;

import java.util.*;

public interface TriangleUtil {

    /**
     * initializes input.
     *
     * @return list of triangles which has been entered
     */

    static List<Triangle> initialize() {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        List<Triangle> triangles = new ArrayList<>();
        do {
            System.out.println("Please, enter name and sides of triangle."
                    + " Format: <Name>,<1-st side>,<2-nd side>,<3-rd side>");
            String textTriangle = deleteSpaces(scanner.nextLine());
            String[] partsOfTriangle = textTriangle.split(",");
            String name = partsOfTriangle[0];
            try {
                double sideA = Double.parseDouble(partsOfTriangle[1]);
                double sideB = Double.parseDouble(partsOfTriangle[2]);
                double sideC = Double.parseDouble(partsOfTriangle[3]);
                triangles.add(Triangle.getInstance(name, sideA, sideB, sideC));
            } catch (NotValidTriangleException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input! " + e.getMessage());
            }
            System.out.println("Do you want to add new one?");
            answer = scanner.nextLine();
        } while (isContinue(answer));
        return triangles;
    }

    /**
     * delete spaces and tabs from name.
     *
     * @param text -  text for processing
     * @return formatted text
     */
    static String deleteSpaces(String text){
        return text.replaceAll("[\\s]{1,}", "");
    }

    /**
     * sorts triangles by square.
     *
     * @param triangles - list of triangle need to sort
     */
    static void sort(List<Triangle> triangles) {
        Collections.sort(triangles, new Comparator<Triangle>() {
            @Override
            public int compare(Triangle triangle1, Triangle triangle2) {
                return Double.compare(triangle2.getSquare(), triangle1.getSquare());
            }
        });
    }

    /**
     * prints triangles.
     *
     * @param triangles - list of triangles that will be printed.
     */
    static void print(List<Triangle> triangles) {
        System.out.println("============= Triangles list: ===============");
        int i = 1;
        for (Triangle triangle : triangles) {
            System.out.println(i + ". [Triangle " + triangle.getName() + "]: "
                    + String.format("%.2f", triangle.getSquare()) + " cm");
            i++;
        }
    }

    /**
     * Checks if answer is positive.
     *
     * @param answer - user's answer
     * @return boolean value(true or false)
     */
    static boolean isContinue(String answer) {
        if (answer.equalsIgnoreCase("yes")
                || answer.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

}
