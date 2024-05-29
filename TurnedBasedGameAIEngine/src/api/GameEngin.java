package api;

import GameState.*;
import bords.TicTacToeBoard;

public class GameEngin {

    public Board start(String type) {
        if (type.equals("TicTacToe")) {
            return new TicTacToeBoard();
        } else {
            throw new IllegalArgumentException("Unsupported game type: " + type);
        }
    }

    public void move(Board board, Player player, Move move) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
            ticTacToeBoard.setCell(move.getCell(), player.getSymbol());
        } else {
            throw new IllegalArgumentException("Unsupported board type");
        }
    }

    public GameResults isComplete(Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
            // Check all rows
            for (int i = 0; i < 3; i++) {
                String firstCell = ticTacToeBoard.getCell(i, 0);
                if (firstCell != null && firstCell.equals(ticTacToeBoard.getCell(i, 1)) && firstCell.equals(ticTacToeBoard.getCell(i, 2))) {
                    return new GameResults(true, firstCell);
                }
            }

            // Check all columns
            for (int i = 0; i < 3; i++) {
                String firstCell = ticTacToeBoard.getCell(0, i);
                if (firstCell != null && firstCell.equals(ticTacToeBoard.getCell(1, i)) && firstCell.equals(ticTacToeBoard.getCell(2, i))) {
                    return new GameResults(true, firstCell);
                }
            }

            // Check diagonals
            String firstCell = ticTacToeBoard.getCell(0, 0);
            if (firstCell != null && firstCell.equals(ticTacToeBoard.getCell(1, 1)) && firstCell.equals(ticTacToeBoard.getCell(2, 2))) {
                return new GameResults(true, firstCell);
            }

            firstCell = ticTacToeBoard.getCell(0, 2);
            if (firstCell != null && firstCell.equals(ticTacToeBoard.getCell(1, 1)) && firstCell.equals(ticTacToeBoard.getCell(2, 0))) {
                return new GameResults(true, firstCell);
            }

            // Check for draw
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (ticTacToeBoard.getCell(i, j) == null) {
                        return new GameResults(false, "-");
                    }
                }
            }

            return new GameResults(true, "-"); // Draw
        } else {
            throw new IllegalArgumentException("Unsupported board type");
        }
    }

    public Move suggestMove(Player computer, Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (ticTacToeBoard.getCell(i, j) == null) {
                        return new Move(new Cell(i, j));
                    }
                }
            }
            throw new IllegalStateException("No moves left");
        } else {
            throw new IllegalArgumentException("Unsupported board type");
        }
    }
}
