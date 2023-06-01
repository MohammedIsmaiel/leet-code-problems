package org.example.problems;

public class SudokuSolver {
    static int N = 9;
    static char[] values = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public static boolean solveSudoku(char board[][], int row,
            int col) {

        if (row == N - 1 && col == N)
            return true;

        if (col == N) {
            row++;
            col = 0;
        }

        if (board[row][col] != '.')
            return solveSudoku(board, row, col + 1);

        for (int value = 0; value < 9; value++) {

            if (isSafe(board, row, col, values[value])) {

                board[row][col] = values[value];

                if (solveSudoku(board, row, col + 1))
                    return true;
            }

            board[row][col] = '.';
        }
        return false;
    }

    static boolean isSafe(char[][] board, int row, int col,
            char value) {

        for (int x = 0; x <= 8; x++)
            if (board[row][x] == value)
                return false;

        for (int x = 0; x <= 8; x++)
            if (board[x][col] == value)
                return false;

        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i + startRow][j + startCol] == value)
                    return false;

        return true;
    }

    public static void printt(char[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    /// ffffffffffffffffffffffff
    // public void solveSudoku(char[][] board) {
    // char[] values = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    // for (int i = 1; i < 10; i++) {
    // for (int j = 1; j < 10; j++) {
    // for (char c : values) {
    // if (board[i][j] == '.') {
    // board[i][j] = c;
    // if (!isValid(board)) {
    // board[i][j] = '.';
    // }
    // }
    // }
    // }
    // }
    // }

    // private boolean isValid(char[][] board) {
    // return isValidRows(board) && isValidCols(board) && isValidBoxes(board);
    // }

    // private boolean isValidBoxes(char[][] board) {
    // for (int boxRow = 0; boxRow < 9; boxRow += 3) {
    // for (int boxCol = 0; boxCol < 9; boxCol += 3) {
    // if (!isValidBox(board, boxRow, boxCol)) {
    // return false;
    // }
    // }
    // }
    // return true;
    // }

    // private boolean isValidBox(char[][] board, int startRow, int startCol) {
    // Set<Character> set = new HashSet<>();
    // for (int row = startRow; row < startRow + 3; row++) {
    // for (int col = startCol; col < startCol + 3; col++) {
    // if (board[row][col] == '.') {
    // continue;
    // }
    // if (set.contains(board[row][col])) {
    // return false;
    // }
    // set.add(board[row][col]);
    // }
    // }
    // return true;
    // }

    // private boolean isValidRows(char[][] board) {
    // for (int row = 0; row < 9; row++) {
    // if (!isValidRow(board, row)) {
    // return false;
    // }
    // }
    // return true;
    // }

    // private boolean isValidRow(char[][] board, int row) {
    // Set<Character> set = new HashSet<>();
    // for (int col = 0; col < 9; col++) {
    // if (board[row][col] == '.') {
    // continue;
    // }
    // if (set.contains(board[row][col])) {
    // return false;
    // }
    // set.add(board[row][col]);
    // }
    // return true;
    // }

    // private boolean isValidCols(char[][] board) {
    // for (int col = 0; col < 9; col++) {
    // if (!isValidCol(board, col)) {
    // return false;
    // }
    // }
    // return true;
    // }

    // private boolean isValidCol(char[][] board, int col) {
    // Set<Character> set = new HashSet<>();
    // for (int row = 0; row < 9; row++) {
    // if (board[row][col] == '.') {
    // continue;
    // }
    // if (set.contains(board[row][col])) {
    // return false;
    // }
    // set.add(board[row][col]);
    // }
    // return true;

    // }

    // private boolean tryValue(char[][] board, char value, int index) {

    // return true;
    // }
}
