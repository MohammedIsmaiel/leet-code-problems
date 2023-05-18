package org.example.problems;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (i > last) {
                return false;
            }
            last = Math.max(last, i + nums[i]);
            if (last >= n - 1) {
                return true;
            }
        }
        return true;
    }

}
