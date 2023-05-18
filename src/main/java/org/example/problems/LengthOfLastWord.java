package org.example.problems;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        // Split the string into words by spaces//{\\s+ represents one or more
        // consicutive white space}
        String[] words = s.split("\\s+");
        if (words.length == 0) {
            return 0;
        }
        return words[words.length - 1].length();
    }

}
