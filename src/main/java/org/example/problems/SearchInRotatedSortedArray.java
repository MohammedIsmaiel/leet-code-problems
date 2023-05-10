package org.example.problems;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int i = 0;
        for (int num : nums) {
            if (num == target) return i;
            i += 1;
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else {
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    return -1;
    }
}
