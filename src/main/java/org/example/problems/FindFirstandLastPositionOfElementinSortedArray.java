package org.example.problems;

public class FindFirstandLastPositionOfElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                while (target == nums[mid]) {
                    result[0] = mid;
                    mid--;
                }
                mid = (left + right) / 2;
                while (target == nums[mid]) {
                    result[1] = mid;
                    mid++;
                }
                return result;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int left = 0, right = nums.length - 1;
        // find the first occurrence of the target
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            return result; // target not found
        } else {
            result[0] = left;
        }
        // find the last occurrence of the target
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        result[1] = left;
        return result;
    }
}
