package org.example.problems;

public class MergeStringsAlternately1768 {

    public static String mergeAlternately(String word1, String word2) {
        var result = new StringBuilder();
        int lenS1 = word1.length();
        int lenS2 = word2.length();
        int maxLen = Math.max(lenS1, lenS2);

        for (int i = 0; i < maxLen; i++) {
            if (i < lenS1) {
                result.append(word1.charAt(i));
            }
            if (i < lenS2) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("null", "null"));
    }

}
