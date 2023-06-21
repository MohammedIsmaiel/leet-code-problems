package org.example.problems;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        var count = 0;
        var result = 0;
        var temp = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (temp != nums[i]) {
                count = 0;
                temp = nums[i];
            }
            count++;
            if (count > 2) {
                nums[i] = 11111;
            }
        }
        Arrays.sort(nums);
        for (int i : nums) {
            if (nums[i] != 11111) {
                result++;
            }
        }
        return result;
    }
}
