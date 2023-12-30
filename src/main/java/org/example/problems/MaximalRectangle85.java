package org.example.problems;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaximalRectangle85 {

    public int maximalRectangle(char[][] matrix) {
        var intArray = sumColumns(matrix);
        return largestRectangleArea(intArray);
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }
        int[] leftBoundaries = new int[n];
        int[] rightBoundaries = new int[n];
        leftBoundaries[0] = -1;
        rightBoundaries[n - 1] = n;
        for (int i = 1; i < n; i++) {
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left = leftBoundaries[left];
            }
            leftBoundaries[i] = left;
        }
        for (int i = n - 2; i >= 0; i--) {
            int right = i + 1;
            while (right < n && heights[right] >= heights[i]) {
                right = rightBoundaries[right];
            }
            rightBoundaries[i] = right;
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = (rightBoundaries[i] - leftBoundaries[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static int[] sumColumns(char[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[] sumArray = new int[numCols];

        for (int col = 0; col < numCols; col++) {
            int colSum = 0;
            for (int row = 0; row < numRows; row++) {
                colSum += matrix[row][col] - '0'; // Convert character to integer
            }
            sumArray[col] = colSum;
        }

        return sumArray;
    }

    public static void main(String[] args) {
        char[][] arr = { { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };

        var sum = sumColumns(arr);
        for (int i : sum) {
            System.out.println(i);
        }
    }

}
