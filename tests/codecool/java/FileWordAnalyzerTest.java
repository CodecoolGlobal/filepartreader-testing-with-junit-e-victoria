package codecool.java;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    void getWordsOrderedAlphabeticallyTest() throws IOException {
       FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader());
       fileWordAnalyzer.filePartReader.setup("tests/codecool/java/test1.txt", 1, 1);
       List<String> actual = fileWordAnalyzer.getWordsOrderedAlphabetically();
       String[] expectedArray = {"anna", "are", "are", "blue", "generous", "is", "people", "red", "some", "some"};
       List<String> expectedList = Arrays.asList(expectedArray);
       assertEquals(expectedList, actual);
    }

    @Test
    void getPalindromesTest() throws IOException {
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader());
        fileWordAnalyzer.filePartReader.setup("tests/codecool/java/test1.txt", 1, 5);
        List<String> actual = fileWordAnalyzer.getStringsWhichPalindromes();
        String[] expectedArray = {"anna", "radar", "civic", "wow", "madam"};
        List<String> expectedList = Arrays.asList(expectedArray);
        assertEquals(expectedList, actual);
    }

    @Test
    void getContainingSubstringTest() throws IOException {
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader());
        fileWordAnalyzer.filePartReader.setup("tests/codecool/java/test1.txt", 1, 5);
        List<String> actual = fileWordAnalyzer.getWordsContainingSubstring("ow");
        String[] expectedArray = {"down", "wow", "slow", "down"};
        List<String> expectedList = Arrays.asList(expectedArray);
        assertEquals(expectedList, actual);
    }

    @Test
    void getOrderedAlphabeticallyTest() throws IOException {
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader());
        fileWordAnalyzer.filePartReader.setup("tests/codecool/java/test1.txt", 2, 2);
        List<String> actual = fileWordAnalyzer.getWordsOrderedAlphabetically();
        String[] expectedArray = {"is", "on", "radar", "the", "way"};
        List<String> expectedList = Arrays.asList(expectedArray);
        assertEquals(expectedList, actual);
    }
}