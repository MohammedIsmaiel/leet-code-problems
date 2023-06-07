package org.example.problems;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        var lineBuilder = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            if (lineBuilder.length() + words[i + 1].length() > maxWidth) {
                result.add(addSpaces(lineBuilder, maxWidth).toString());
                lineBuilder.setLength(0);
            } else {
                lineBuilder.append(words[i] + " ");
            }
        }
        return result;
    }

    private StringBuilder addSpaces(StringBuilder sb, int maxWidth) {
        StringBuilder resultLine = new StringBuilder();
        String[] lineWords = sb.toString().split("\\s+");
        var remainingSpaces = maxWidth - sb.toString().length();
        for (int j = 0; j < lineWords.length - 1; j++) {
            resultLine.append(lineWords[j]);
            if (remainingSpaces > 0) {
                resultLine.append(" ");
                remainingSpaces--;
            }
        }
        resultLine.append(lineWords[lineWords.length - 1]);
        return resultLine;
    }

    public static void main(String[] args) {
        System.out.println("asdasd");
    }

    public List<String> fullJustify2(String[] words, int maxWidth) {
        List<String> processedStrings = new ArrayList<>();
        int width = 0, wordsCount = 0;
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            width += words[wordIndex].length();
            wordsCount++;
            if (wordIndex == words.length - 1
                    || width + words[wordIndex + 1].length() + wordsCount - 1 >= maxWidth) {
                int allSpaces = maxWidth - width;
                StringBuilder processedString = new StringBuilder();
                while (--wordsCount >= 0) {
                    processedString.append(words[wordIndex - wordsCount]);
                    int spaces = wordIndex == words.length - 1
                            ? 1
                            : (int) Math.ceil((double) allSpaces / wordsCount);
                    // processedString.append(" ".repeat(Math.max(0, Math.min(spaces, allSpaces))));
                    allSpaces -= spaces;
                }
                // processedString.append(" ".repeat(Math.max(0, allSpaces)));
                processedStrings.add(processedString.toString());
                wordsCount = 0;
                width = 0;
            }
        }
        return processedStrings;
    }
}
