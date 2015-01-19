package tictactoe;

import tictactoe.Gui.MainFrame;

/**
 *
 * @author Mikael
 */
public class Game {
    private Board board;
    private CrossPlayer crossPlayer;
    private CirclePlayer circlePlayer;
    
    private Player currentPlayer;
    private MainFrame frame;
    
    public Game() {
        
        board = new Board();
        crossPlayer = new CrossPlayer(board);
        circlePlayer = new CirclePlayer(board);
        currentPlayer = crossPlayer;

        frame = new MainFrame(this);
        
    }
    public void togglePlayer() {
        if (currentPlayer.equals(crossPlayer)) {
            currentPlayer = circlePlayer;
        } else {
            currentPlayer = crossPlayer;
        }
    }
    public void makeMove(int i) {
        int row = i/3;
        int col = i%3;
        
        currentPlayer.makeMove(row, col);
        frame.setSquare(i, currentPlayer);
        frame.disableSquare(i);
        togglePlayer();
        display();
    }
            
    public void display() {
        PlayerType markType;
       
        for (int i = 0; i < 3; i++) {
            
            for (int j = 0; j < 3; j++) {
                markType = board.getSquare(i, j).getMark();
                
                if (markType  == PlayerType.None) {
                    System.out.print("*");
                }
                else if(markType == PlayerType.Cross) {
                    System.out.print("X");
                }
                else if(markType == PlayerType.Circle) {
                    System.out.print("O");
                }
            }
            System.out.print("\n");
        }
    }
    public PlayerType checkDiag() {
        
        if (board.getSquare(0, 0).getMark() == board.getSquare(1, 1).getMark() &&
                board.getSquare(0, 0).getMark() == board.getSquare(2, 2).getMark()) {
            return board.getSquare(0, 0).getMark();
        }
        if (board.getSquare(0, 2).getMark() == board.getSquare(1, 1).getMark() &&
                board.getSquare(0, 2).getMark() == board.getSquare(2, 0).getMark()) {
            return board.getSquare(0, 2).getMark();
        }
        return PlayerType.None;
    }
    public PlayerType checkCol(int col) {
        if (board.getSquare(0, col).getMark() == board.getSquare(1, col).getMark() &&
                board.getSquare(0, col).getMark() == board.getSquare(2, col).getMark()){
            return board.getSquare(0, col).getMark();
        }
        return PlayerType.None;
    }
    public PlayerType checkRow(int row) {
        
        
        if (board.getSquare(row, 0).getMark() == board.getSquare(row, 1).getMark() &&
                board.getSquare(row, 0).getMark() == board.getSquare(row, 2).getMark()) { //row full
            return board.getSquare(row, 0).getMark();
        }
        
        return PlayerType.None;
    }
    public PlayerType playerWon() {
        PlayerType winner;
        for (int i = 0; i < 3; i++) {
            winner = checkRow(i);
            if (winner != PlayerType.None) {
                return winner;
            }
            
            winner = checkCol(i);
            if (winner != PlayerType.None) {
                return winner;
            }
        }
        return checkDiag();
    }
    
}
