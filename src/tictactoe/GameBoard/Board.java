package tictactoe.GameBoard;

import tictactoe.GamePlayer.PlayerType;

public class Board {
    private Square  board[][] = new Square [3][3];
    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new Square();
            }
        }
    }
    public void setSquare (int row, int col, PlayerType type) {
        board[row][col].setMark(type);
    }
    public Square getSquare(int row, int col) {
        return board[row][col];
    }
}
