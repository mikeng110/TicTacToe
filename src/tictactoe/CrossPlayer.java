package tictactoe;

/**
 *
 * @author Mikael
 */
public class CrossPlayer extends Player {

    private Board board;
    
    public CrossPlayer(Board board) {
        super(board, PlayerType.Cross);
        this.board = board;
        
    }
    
}
