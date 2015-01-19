/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.GameGui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tictactoe.Game;
import tictactoe.GamePlayer.Player;
import tictactoe.GamePlayer.PlayerType;

public class MainFrame extends JFrame implements ActionListener{
    
    private ArrayList<JButton> squares;         //Squares that the player can mark X or O.
    private JPanel SquaresPanel = new JPanel(); //The panel that holds the squares on the window.
    private Game game;
    
    private final int WinHeight = 300;
    private final int WinWidth = 300;
    private final int nrOffSquares = 9;
            
    
    public MainFrame(Game game) {
        super("Tic Tac Toe");
        this.game = game;
        
        initWindow();
        initSquares();  
        initSquaresPanel();
        
    }
    private void initWindow() {
        
        setSize(WinWidth, WinHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void initSquares() {
        squares = new ArrayList<>();
        
        for (int i = 0; i < nrOffSquares; i++) {
            JButton b = new JButton();
            b.setFont(b.getFont().deriveFont(18.0f));
            b.addActionListener(this);
            SquaresPanel.add(b);
            squares.add(b);
        }
    }
     
    private void initSquaresPanel() {
        
        SquaresPanel.setLayout(new GridLayout(3,3)); 
        add(SquaresPanel);
    }
   
    public void markSquare(int i, Player p) {
        if (p.getType() == PlayerType.Cross) {
            squares.get(i).setText("X");
        }else {
            squares.get(i).setText("O");
        }
    }
    public void disableAllSquares() {
        for (int i = 0; i < nrOffSquares; i++)
            disableSquare(i);
    }
    public void disableSquare(int i) {
        squares.get(i).setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        
        for (int i = 0; i < nrOffSquares; i++) {
            if (b.equals(squares.get(i))) {        //if the ith square is clicked
                game.makeMove(i);                  //Make a move on the ith square.
            }
        } 
    }
    
}
