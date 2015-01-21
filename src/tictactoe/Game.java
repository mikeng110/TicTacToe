package tictactoe;

import java.util.Observable;
import tictactoe.GameBoard.Board;
import tictactoe.GamePlayer.Player;
import tictactoe.GamePlayer.PlayerType;

public class Game {
    
    private final Board board = new Board();
    private final Player crossPlayer = new Player(board, PlayerType.Cross);
    private final Player circlePlayer = new Player(board, PlayerType.Circle);
    private Player currentPlayer = crossPlayer;
    public int currentSquare = 0;
    
    public Game() {
    }
    public void togglePlayer() {
        if (currentPlayer.equals(crossPlayer)) {
            currentPlayer = circlePlayer;
        } else {
            currentPlayer = crossPlayer;
        }
    }
    /*
        Called when the player clicks on the ith square.
    */
    public void makeMove(int i) {
        
        int row = i / 3;
        int col = i % 3;
        currentSquare = i;
        currentPlayer.makeMove(row, col);
       // frame.markSquare(i, currentPlayer);
        //frame.disableSquare(i);
        togglePlayer();
        display();
    }
            
    /**
     * Display the board in the console, used for debbuging purposes
     */
    public void display() {
        PlayerType markType;
       
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                markType = board.getSquare(i, j).getMark();
                System.out.print(markType.toString());
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    
   private PlayerType getMark(int i, int j)  //rename 
   {
       return board.getSquare(i, j).getMark();
   }
    public PlayerType checkDiag() {
        
        if (getMark(0,0) == getMark(1,1) && getMark(0,0) == getMark(2,2)) {
            return getMark(0,0);
        }
        if (getMark(0,2) == getMark(1,1) && getMark(0,2) == getMark(2,0)) {
            return getMark(0,2);
        }
        return PlayerType.None;
    }
    
    public PlayerType checkCol(int col) {
        if (getMark(0, col) == getMark(1, col) && getMark(0,col) == getMark(2, col)){
            return getMark(0,col);
        }
        return PlayerType.None;
    }
    
    public PlayerType checkRow(int row) {
        
        if (getMark(row, 0) == getMark(row, 1) && getMark(row, 0) == getMark(row, 2)) { //row full
            return getMark(row, 0);
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

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
}
