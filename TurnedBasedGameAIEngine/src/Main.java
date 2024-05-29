import java.util.Scanner;
import GameState.Cell;
import GameState.Move;
import GameState.Player;
import api.GameEngin;
import GameState.Board;

public class Main {
    public static void main(String[] args) {
        GameEngin gameEngin = new GameEngin();
        Board board = gameEngin.start("TicTacToe");
        Scanner scanner = new Scanner(System.in);

        while (!gameEngin.isComplete(board).isOver()) {
            System.out.println(board);
            System.out.println("Make your move!");
            Player opponent = new Player("X");
            Player computer = new Player("O");

            int row = scanner.nextInt();
            int col = scanner.nextInt();
            Move oppMove = new Move(new Cell(row, col));
            gameEngin.move(board, opponent, oppMove);

            if (!gameEngin.isComplete(board).isOver()) {
                Move computerMove = gameEngin.suggestMove(computer, board);
                gameEngin.move(board, computer, computerMove);
            }
        }

        System.out.println(board);
        System.out.println("Game over! Winner: " + gameEngin.isComplete(board).getWinner());
    }
}
