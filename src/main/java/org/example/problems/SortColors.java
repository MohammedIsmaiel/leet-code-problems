package org.example.problems;

public class SortColors {
    public void sortColors(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int i : nums) {
            switch (i) {
                case 0:
                    a++;
                    break;
                case 1:
                    b++;
                    break;
                default:
                    c++;
                    break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (a > 0) {
                nums[i] = 0;
                a--;
                continue;
            }
            if (b > 0) {
                nums[i] = 1;
                b--;
                continue;
            }
            if (c > 0) {
                nums[i] = 2;
                c--;
                continue;
            }
        }
    }
}
