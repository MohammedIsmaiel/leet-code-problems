package org.example.problems;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int left = 0;
        int right = rowLength * colLength - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / colLength;
            int col = mid % colLength;
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
