package org.example.problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 1)
            return new int[][] { { 1 } };
        int[][] matrix = new int[n][n];
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int left = 0;
        int top = 0;
        traverse(matrix, top, rows, left, cols, result);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = result.get(i + j);
            }
        }
        return matrix;
    }

    private void traverse(int[][] matrix, int top, int bottom, int left, int right, List<Integer> result) {
        if (left > right || top > bottom)
            return;
        for (int i = left; i <= right; i++) {
            result.add(matrix[top][i]);
        }
        top++;
        for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
        }
        right--;

        if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
        }

        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        traverse(matrix, top, bottom, left, right, result);

    }
}
