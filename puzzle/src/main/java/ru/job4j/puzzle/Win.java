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
        for (int commonIndex = 0; commonIndex < board.length; commonIndex++) {
            if (board[commonIndex][commonIndex] == 1) {
                if (checkRow(board, commonIndex) || checkColumn(board, commonIndex)) {
                    return true;
                }
            }
        }
        return false;
    }
}
