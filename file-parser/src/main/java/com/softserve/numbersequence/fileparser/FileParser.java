package com.softserve.numbersequence.fileparser;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class that represents file parser.
 *
 * @author Artem
 * @version 1.0
 */
public class FileParser {
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
                    + getNumberOfCoincidence(path, textToCount));

        } else if (args.length == 3) {
            Path path = Paths.get(args[0]);
            String textToFind = args[1];
            String textToReplace = args[2];
            replaceText(path, textToFind, textToReplace);

        } else {
            System.out.println("Wrong arguments!");
        }
    }


    /**
     * Replaces text.
     *
     * @param path          - file path.
     * @param textToFind    - text to find.
     * @param textToReplace - text to replace.
     * @throws IOException - IOException.
     */
    public static void replaceText(Path path, String textToFind, String textToReplace) {
        PrintWriter out = null;
        try {
            List<String> stringList = Files.readAllLines(path, Charset.forName("UTF-8"));
            StringBuilder textToWrite = new StringBuilder();
            for (String s : stringList) {
                String updatedText = s.replaceAll(textToFind, textToReplace);
                textToWrite.append(updatedText);
                textToWrite.append("\n");
            }
            out = new PrintWriter(path.toString());
            out.println(textToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    /**
     * Gets number of coincidence.
     *
     * @param path        - file path.
     * @param textToCount - text to count.
     * @return number of coincidence.
     * @throws IOException - IOException.
     */
    public static int getNumberOfCoincidence(Path path, String textToCount) {
        int counter = 0;
        try {
            List<String> stringList = Files.readAllLines(path, Charset.forName("UTF-8"));
            counter = 0;
            for (String line : stringList) {
                Pattern p = Pattern.compile(textToCount);
                Matcher m = p.matcher(line);
                while (m.find()) {
                    counter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }
}
