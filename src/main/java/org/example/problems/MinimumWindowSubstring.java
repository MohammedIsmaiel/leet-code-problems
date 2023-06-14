package org.example.problems;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "dashksad";
        System.out.println(s.contains("sd"));
    }

    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        int m = s.length(), n = t.length();
        for (int i = 0; i < m; i++) {

        }

        return "";
    }

    public boolean isSubstringContainingAllChars(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return false;
        }
        int[] charCount = new int[26];
        for (char c : t.toCharArray()) {
            charCount[c - 'a']++;
        }
        int left = 0;
        int count = t.length();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (charCount[c - 'a'] > 0) {
                count--;
            }
            charCount[c - 'a']--;
            if (count == 0) {
                return true;
            }
            if (right - left + 1 >= t.length()) {
                char leftChar = s.charAt(left);
                if (charCount[leftChar - 'a'] >= 0) {
                    count++;
                }
                charCount[leftChar - 'a']++;
                left++;
            }
        }
        return false;
    }

}
