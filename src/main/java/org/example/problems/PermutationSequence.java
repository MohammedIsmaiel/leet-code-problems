package org.example.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationSequence {
    int stop = 0;
    List<Integer> permutation;

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        permute(nums, 0, k);
        return permutation.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public void permute(int[] nums, int start, int k) {
        if (start == nums.length || stop == k) {
            permutation = Arrays.stream(nums).boxed().collect(Collectors.toList());
            stop++;
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap2Numbers(nums, start, i);
            permute(nums, start + 1, k);
            swap2Numbers(nums, start, i);
        }
    }

    public void swap2Numbers(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public String getPermutation2(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        k--; // Convert k to 0-based index
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(nums.get(index));
            nums.remove(index);
            k -= index * factorial[n - i];
        }

        return sb.toString();
    }
}
