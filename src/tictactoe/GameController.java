package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import tictactoe.GameGui.MainFrame;
import tictactoe.GamePlayer.Player;

public class GameController {

    private Game game;
    private MainFrame frame;
    
    GameController(Game game, MainFrame frame) {
        this.game = game;
        this.frame = frame;
        
        frame.addSquareListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Player currentPlayer = game.getCurrentPlayer();
                JButton b = (JButton)e.getSource();
                int i = new Integer(b.getName());
                game.makeMove(i);
                frame.markSquare(i, currentPlayer);
            }
        });
    }

    public void makeMove(int i) {
        game.makeMove(i);
    }
    
}
