package org.example.problems;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        Arrays.stream(matrix).forEach(row -> IntStream.range(0, matrix.length / 2)
                .forEach(col -> {
                    int temp = row[col];
                    row[col] = row[matrix.length - 1 - col];
                    row[matrix.length - 1 - col] = temp;
                }));
        // for (int i = 0; i < matrix.length; i++) {
        // for (int j = 0; j < matrix.length / 2; j++) {
        // int temp = matrix[i][j];
        // matrix[i][j] = matrix[i][matrix.length - 1 - j];
        // matrix[i][matrix.length - 1 - j] = temp;
        // }
        // }
    }
}
