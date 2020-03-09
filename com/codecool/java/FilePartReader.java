package codecool.java;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilePartReader {
    public String filePath;
    public Integer fromLine;
    public Integer toLine;

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        this.filePath = filePath;
        if (fromLine >= 1 && toLine >= fromLine) {
            this.fromLine = fromLine;
            this.toLine = toLine;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String read() throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        Stream<String> stream = Files.lines( Paths.get(this.filePath), StandardCharsets.UTF_8);
        stream.forEach(s -> contentBuilder.append(s).append("\n"));
        return contentBuilder.toString();
    }

    public String readLines() throws IOException {
        String file = this.read();
        String result = "";
        String[] lines = file.split("\n");
        try {
        for (int i = this.fromLine; i <= this.toLine; i++) {
            result += lines[i-1];
        }} catch (IndexOutOfBoundsException e) {
            System.out.println("no such line in the file");
        }
        return result;
    }
}
