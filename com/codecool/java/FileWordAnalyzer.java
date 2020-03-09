package codecool.java;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
        this.filePartReader.setup("tests/codecool/java/test1.txt", 1, 5);
    }

    private List<String> getWordsList(String text) {
        String[] splittedText = text.split("[ .,:;!]");
        List<String> wordsList = new ArrayList<>();
        for (String word: splittedText) {
            word = word.toLowerCase();
            if (word.length() > 0) {
                wordsList.add(word);
            }
        }
        return wordsList;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String text = this.filePartReader.readLines();
        List<String> orderedWords = getWordsList(text);
        Collections.sort(orderedWords);
        return orderedWords;
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        List<String> result = new ArrayList<>();
        String text = this.filePartReader.readLines();
        List<String> wordsList = getWordsList(text);
        for (String word: wordsList) {
            if (word.contains(subString)) {
                result.add(word);
            }
        }
        return result;
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        List<String> result = new ArrayList<>();
        String text = this.filePartReader.readLines();
        List<String> wordsList = getWordsList(text);
        for (String word: wordsList) {
            if (word.equals(new StringBuffer(word).reverse().toString()) && word.length() > 1) {
                System.out.println(word);
                result.add(word);
            }
        }
        if (result.size() <= 0) {
            System.out.println("no palindromes found");
        }
        return result;
    }
}
