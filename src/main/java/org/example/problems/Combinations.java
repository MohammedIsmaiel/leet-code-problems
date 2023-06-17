package org.example.problems;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), n, k, 1);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet,
            int n, int k, int start) {
        if (tempSet.size() == k) {
            resultSets.add(new ArrayList<>(tempSet));
            return;
        }
        for (int i = start; i <= n; i++) {
            tempSet.add(i);
            backtrack(resultSets, tempSet, n, k, i + 1);
            tempSet.remove(tempSet.size() - 1);
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        for (int i = 1; i <= k; i++)
            combination.add(i);
        resultList.add(new ArrayList<>(combination));
        while (true) {
            int i = k - 1;
            while (i >= 0 && combination.get(i) == n - k + i + 1)
                i--;
            if (i < 0)
                break;
            combination.set(i, combination.get(i) + 1);
            for (int j = i + 1; j < k; j++)
                combination.set(j, combination.get(j - 1) + 1);
            resultList.add(new ArrayList<>(combination));
        }
        return resultList;
    }
}
