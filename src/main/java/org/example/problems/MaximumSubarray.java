package org.example.problems;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        var n = nums.length;
        var sum = 0;
        var maxSum = 0;
        if (n == 0)
            return nums[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] >= maxSum)
                maxSum = nums[i];
            sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public int maxSubArray3(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            currSum = Math.max(currSum, 0);
        }

        return maxSum;
    }

}
