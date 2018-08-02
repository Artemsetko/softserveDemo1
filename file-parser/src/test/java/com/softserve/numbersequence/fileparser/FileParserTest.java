package com.softserve.numbersequence.fileparser;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.junit.Assert.assertEquals;

/**
 * @author Artem on 31.07.2018
 */
public class FileParserTest {
    Path tempFile, wordFile;

    @Before
    public void setUp() throws Exception {
        //Get file from resources folder
        wordFile = Paths.get(FileParserTest.class
                .getResource("/testfile/Text.txt").toURI());
        tempFile = Files.createTempFile("temp-", ".tmp");
        Files.copy(wordFile, tempFile, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void replaceText() {
        String oldString = "строки в текстовом";
        int occurrences = FileParser.getNumberOfCoincidence(tempFile, oldString);

        FileParser.replaceText(tempFile, oldString, "New String");
        int actualOccurrences = FileParser.getNumberOfCoincidence(tempFile, oldString);

        assertEquals(1, occurrences);
        assertEquals(0, actualOccurrences);

    }

    @Test
    public void getNumberOfCoincidencePoints() {
        int actual = FileParser.getNumberOfCoincidence(tempFile, "\\.");
        int expected = 4;
        assertEquals(expected, actual);
    }

}