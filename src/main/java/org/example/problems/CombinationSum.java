package org.example.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum {
    List<Integer> compination;
    List<List<Integer>> output = new ArrayList<>();
    int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        compination = new ArrayList<>();
        sum = 0;
        output.add(getCompination(candidates, compination, target, target));
        return this.output;
    }

    private List<Integer> getCompination(int[] candidates, List<Integer> compination, int target, int sum) {
        for (int number : candidates) {
            if (number == target) {
                return compination;
            }
            while (number < target && sum + number < target) {
                compination.add(number);
                sum += number;
            }
            if (sum == target) {
                return compination;
            }
        }
        return null;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path, result);
            path.remove(path.size() - 1);
        }
    }

    /**
     * InnerCombinationSum
     */
    public class InnerCombinationSum {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> CombinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            Backtrack(new ArrayList<Integer>(), candidates, target, 0);
            return res;
        }

        void Backtrack(List<Integer> comb, int[] nums, int diff, int start) {
            if (diff == 0) {
                res.add(comb);
                return;
            }
            var set = new HashSet<Integer>();
            for (var i = start; i < nums.length; i++) {
                if (diff - nums[i] >= 0 && !set.contains(nums[i])) {
                    set.add(nums[i]);
                    comb.add(nums[i]);
                    Backtrack(comb, nums, diff - nums[i], i + 1);
                    comb.remove(comb.size() - 1);
                }
            }
        }
    }
}
