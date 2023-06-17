package org.example.problems;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int numRows = board.length;
        int numCols = board[0].length;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (dfs(board, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int index) {
        int numRows = board.length;
        int numCols = board[0].length;
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || board[row][col] != word.charAt(index)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found = dfs(board, row + 1, col, word, index + 1) ||
                dfs(board, row - 1, col, word, index + 1) ||
                dfs(board, row, col + 1, word, index + 1) ||
                dfs(board, row, col - 1, word, index + 1);
        board[row][col] = temp;
        return found;
    }
}
