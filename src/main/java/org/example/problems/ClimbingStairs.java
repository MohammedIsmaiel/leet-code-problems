package org.example.problems;

import java.util.HashSet;
import java.util.Set;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(35));
    }

    public static int climbStairs(int n) {
        if (n <= 3)
            return n;
        Set<String> result = new HashSet<>();
        StringBuilder s = new StringBuilder();
        backtrack(n, s, result);
        return result.size();
    }

    static void backtrack(int n, StringBuilder s, Set<String> result) {
        if (n == 0) {
            result.add(s.toString());
            return;
        }
        if (n >= 1) {
            s.append("1");
            backtrack(n - 1, s, result);
            s.deleteCharAt(s.length() - 1);
        }
        if (n >= 2) {
            s.append("2");
            backtrack(n - 2, s, result);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static int climbStairs2(int n) {
        if (n <= 3)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
