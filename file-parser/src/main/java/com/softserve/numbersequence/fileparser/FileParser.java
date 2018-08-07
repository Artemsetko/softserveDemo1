package com.softserve.numbersequence.fileparser;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public static void printHelp() {
       System.out.printf("Program works with files%n" +
                "Supported operations:%n" +
                "\tReplace all words in file with word to replace%n" +
                "\tCount coincidence of given word in given file%n" +
                "Params should be strings which depend on operation%n" +
                "\t1 Operation need three strings, example:%n" +
                "\t[path to the file] [string for being replaced] [string for replacing]%n" +
                "\t2 Operation need two string, example:%n" +
                "\t[path to the file] [string which program finds and counts]%n");
    }
}
