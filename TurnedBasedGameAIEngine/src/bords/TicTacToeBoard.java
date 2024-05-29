package bords;

import GameState.Cell;
import GameState.Board;

public class TicTacToeBoard extends Board {
    private String[][] board;

    public TicTacToeBoard() {
        board = new String[3][3];
    }

    public void setCell(Cell cell, String symbol) {
        if (cell != null) {
            board[cell.getRow()][cell.getCol()] = symbol;
        } else {
            throw new IllegalArgumentException("Cell cannot be null");
        }
    }

    public String getCell(int row, int col) {
        return board[row][col];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result.append(board[i][j] != null ? board[i][j] : "-");
                if (j < 2) result.append(" | ");
            }
            result.append("\n");
            if (i < 2) result.append("---------\n");
        }
        return result.toString();
    }
}
