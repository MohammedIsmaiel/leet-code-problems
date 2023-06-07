package org.example.problems;

public class SqrtX {
    class Solution {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            int left = 1;
            int right = x;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                    return mid;
                } else if (mid > x / mid) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

    }

    public int mySqrt2(int x) {
        if (x == 0)
            return 0;
        long sqrt = x;
        while (sqrt * sqrt > x) {
            sqrt = (sqrt + x / sqrt) / 2;
        }
        return (int) sqrt;
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        for (int i = 1;; i++) {
            if (i <= x / i && (i + 1) > x / (i + 1))
                return i;
        }
    }

}
