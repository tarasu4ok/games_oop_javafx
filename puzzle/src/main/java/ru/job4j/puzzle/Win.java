package ru.job4j.puzzle;

public class Win {
    public static boolean checkRow(int[][] board, int row) {
        for (int j = 0; j < board[row].length; j++) {
            if (board[row][j] == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumn(int[][] board, int column) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 1) {
                if (checkRow(board, i)) {
                    return true;
                }
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 1) {
                if (checkColumn(board, j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
