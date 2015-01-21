package tictactoe;

import tictactoe.GameGui.MainFrame;

public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Game g = new Game(); 
        MainFrame frame = new MainFrame();
        GameController c = new GameController(g,frame);
        
    }
    
}
