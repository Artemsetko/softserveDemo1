package com.softserve.numbersequence.fileparser;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Artem on 07.08.2018
 */
public class Main {
    /**
     * runs the application.
     *
     * @param args - user's input(path and text to count or path, textToFind and textToReplace)
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            Path path = Paths.get(args[0]);
            String textToCount = args[1];
            System.out.println("Number of coincidence = "
                    + FileParser.getNumberOfCoincidence(path, textToCount));

        } else if (args.length == 3) {
            Path path = Paths.get(args[0]);
            String textToFind = args[1];
            String textToReplace = args[2];
            FileParser.replaceText(path, textToFind, textToReplace);

        } else {
            FileParser.printHelp();
        }
    }
}
