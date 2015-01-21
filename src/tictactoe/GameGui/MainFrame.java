/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.GameGui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tictactoe.GamePlayer.Player;

public class MainFrame extends JFrame{
    
    private final List<JButton> squares = new ArrayList<>();  
    private JPanel squaresPanel = new JPanel();
    
    private final int WIN_HEIGHT = 300;
    private final int WIN_WIDTH = 300;
    private final int NR_SQUARES = 9;
    
    public MainFrame() {
        super("Tic Tac Toe");
        initWindow();
        initSquares();  
        initSquaresPanel();
        
        
        
    }
    private void initWindow() {
        
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void initSquares() {
      
        for (int i = 0; i < NR_SQUARES; i++) {
            JButton b = new JButton();
            b.setFont(b.getFont().deriveFont(18.0f));
           // b.addActionListener(this);
            squaresPanel.add(b);
            squares.add(b);
        }
    }
     
    private void initSquaresPanel() {
        
        squaresPanel.setLayout(new GridLayout(3,3)); 
        add(squaresPanel);
    }
   
    public void markSquare(int i, Player p) {
        squares.get(i).setText(p.getType().toString());
    }
    public void disableAllSquares() {
        for (int i = 0; i < NR_SQUARES; i++) {
            disableSquare(i);
        }
    }
    
    public void disableSquare(int i) {
        squares.get(i).setEnabled(false);
    }
    public void addSquareListener(ActionListener listenForSquareClicked) {
        for (int i = 0; i < NR_SQUARES; i++) {
            squares.get(i).addActionListener(listenForSquareClicked);
            squares.get(i).setName(""+i);
        }
            
    }
    
}
