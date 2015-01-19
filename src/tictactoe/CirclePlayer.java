package tictactoe;

/**
 *
 * @author Mikael
 */
public class CirclePlayer extends Player {

    private Board board;
    
    public CirclePlayer(Board board) {
        
        super(board, PlayerType.Circle);
        this.board = board;
    }
    
}
