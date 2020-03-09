package codecool.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileWordAnalyzerMockTests {

    FilePartReader filePartReader = Mockito.mock(FilePartReader.class);
    FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

    @Test
    void getWordsOrderedAlphabeticallyTest() throws IOException {
        String text = "he a coder is";
        Mockito.when(filePartReader.readLines()).thenReturn(text);
        String[] expectedArray = {"a", "coder", "he", "is"};
        List<String> actualList = fileWordAnalyzer.getWordsOrderedAlphabetically();
        List<String> expectedList = Arrays.asList(expectedArray);
        assertEquals(expectedList, actualList);
    }

    @Test
    void getPalindromesTest() throws IOException {
        String text = "ala bab oops lol jack";
        Mockito.when(filePartReader.readLines()).thenReturn(text);
        String[] expectedArray = {"ala", "bab", "lol"};
        List<String> expectedList = Arrays.asList(expectedArray);
        List<String> actualList = fileWordAnalyzer.getStringsWhichPalindromes();
        assertEquals(expectedList, actualList);
    }

    @Test
    void getSubstringTest() throws IOException {
        String text = "It will be okay soon, bee";
        Mockito.when(filePartReader.readLines()).thenReturn(text);
        String[] expectedArray = {"be", "bee"};
        List<String> expectedList = Arrays.asList(expectedArray);
        List<String> actualList = fileWordAnalyzer.getWordsContainingSubstring("be");
        assertEquals(expectedList, actualList);
    }
}
