package codecool.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    void setupFromLineIsLessThemToLineTestError() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FilePartReader filePartReader = new FilePartReader();
            filePartReader.setup("tests/codecool/java/test1.txt", 5, 2);
        });
    }

    @Test
    void setupToLineIsLessNeededTestError() throws IllegalArgumentException {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FilePartReader filePartReader = new FilePartReader();
            filePartReader.setup("tests/codecool/java/test1.txt", 0, 2);
        });
    }

    @Test
    void readTest() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("tests/codecool/java/test2.txt", 1, 1);
        String text = filePartReader.read();
        assertEquals("Some text\n", text);
    }

    @Test
    void readLinesTest() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("tests/codecool/java/test2.txt", 1, 1);
        String text = filePartReader.readLines();
        assertEquals("Some text", text);
    }
}