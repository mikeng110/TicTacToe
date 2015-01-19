package tictactoe.GamePlayer;

import tictactoe.GameBoard.Board;

public class Player {
    private PlayerType type;
    private Board board;
    
    public Player(Board board, PlayerType type) {
        this.type = type;
        this.board = board;
    }
    public void makeMove(int row, int col) {
        board.setSquare(row, col, type);
    }
    public PlayerType getType() {
        return this.type;
    }
}
