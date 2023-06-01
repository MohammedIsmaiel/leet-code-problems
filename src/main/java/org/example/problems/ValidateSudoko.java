package org.example.problems;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class ValidateSudoko {
    public boolean isValidSudoku(char[][] board) {
        if (validateRow(board) || validateRow(transpose(board)) || validateBox(board))
            return false;
        else
            return true;

    }

    private boolean validateBox(char[][] board) {
        Boolean valid = true;

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                Set box = new HashSet<>();
                for (int row = boxRow; row < boxRow + 3; row++) {
                    for (int col = boxCol; col < boxCol + 3; col++) {

                        if (board[row][col] != '.' && !box.add(board[row][col]))
                            return false;
                    }
                }
            }
        }
        return valid;
    }

    boolean validateRow(char[][] board) {
        boolean hasRepeatingElements = false;
        for (char[] row : board) {
            hasRepeatingElements = IntStream.range(0, row.length)
                    .mapToObj(i -> Character.valueOf(row[i]))
                    .filter(c -> c != '.')
                    .distinct()
                    .count() != row.length;

            if (hasRepeatingElements) {
                return false;
            }
        }
        return true;
    }

    char[][] transpose(char[][] board) {
        char[][] transposedArr = new char[board[0].length][board.length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                transposedArr[j][i] = board[i][j];
            }
        }
        return transposedArr;
    }

    public boolean isValidSudoku2(char[][] board) {
        return isValidRows(board) && isValidCols(board) && isValidBoxes(board);
    }

    private boolean isValidBoxes(char[][] board) {
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                if (!isValidBox(board, boxRow, boxCol)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int startRow, int startCol) {
        Set<Character> set = new HashSet<>();
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (set.contains(board[row][col])) {
                    return false;
                }
                set.add(board[row][col]);
            }
        }
        return true;
    }

    private boolean isValidRows(char[][] board) {
        for (int row = 0; row < 9; row++) {
            if (!isValidRow(board, row)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == '.') {
                continue;
            }
            if (set.contains(board[row][col])) {
                return false;
            }
            set.add(board[row][col]);
        }
        return true;
    }

    private boolean isValidCols(char[][] board) {
        for (int col = 0; col < 9; col++) {
            if (!isValidCol(board, col)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            if (board[row][col] == '.') {
                continue;
            }
            if (set.contains(board[row][col])) {
                return false;
            }
            set.add(board[row][col]);
        }
        return true;

    }
}
