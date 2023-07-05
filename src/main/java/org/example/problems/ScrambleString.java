package org.example.problems;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length())
            return false;
        return isScrambleHelper(s1, s2, new HashMap<>());
    }

    private boolean isScrambleHelper(String s1, String s2, Map<String, Boolean> memo) {
        if (s1.equals(s2))
            return true;
        int[] count = new int[26];
        int n = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i : count)
            if (i != 0)
                return false;
        String key = s1 + "#" + s2;
        if (memo.containsKey(key))
            return memo.get(key);
        for (int i = 1; i < s1.length(); i++) {
            if ((isScrambleHelper(s1.substring(0, i), s2.substring(0, i), memo)
                    && isScrambleHelper(s1.substring(i), s2.substring(i), memo))
                    || (isScrambleHelper(s1.substring(0, i), s2.substring(n - i), memo)
                            && isScrambleHelper(s1.substring(i), s2.substring(0, n - i), memo))) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }
}
