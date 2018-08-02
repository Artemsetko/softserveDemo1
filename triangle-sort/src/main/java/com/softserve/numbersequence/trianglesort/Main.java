package com.softserve.numbersequence.trianglesort;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        startApplication();
    }

    /**
     * runs the application
     */
    public static void startApplication() {
        List<Triangle> triangles = TriangleUtil.initialize();
        TriangleUtil.sort(triangles);
        TriangleUtil.print(triangles);
    }
}

