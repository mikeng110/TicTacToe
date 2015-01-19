/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.Gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tictactoe.Game;
import tictactoe.Player;
import tictactoe.PlayerType;

public class MainFrame extends JFrame implements ActionListener{
    private JPanel panel = new JPanel();
    private ArrayList<JButton> squares;
    private Game game;
    
    public MainFrame(Game game) {
        super("Tic Tac Toe");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        this.game = game;
        panel.setLayout(new GridLayout(3,3));
        
        squares = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            JButton b = new JButton();
            b.setFont(b.getFont().deriveFont(18.0f));
            b.addActionListener(this);
            panel.add(b);
            squares.add(b);
        }
        
        add(panel);
    }
    public void setSquare(int i, Player p) {
        if (p.getType() == PlayerType.Cross) {
            squares.get(i).setText("X");
        }else {
            squares.get(i).setText("O");
        }
        
    }
    public void disableAllSquares() {
        for (int i = 0; i < 9; i++)
            disableSquare(i);
    }
    public void disableSquare(int i) {
        squares.get(i).setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        for (int i = 0; i < 9; i++) {
            if (b.equals(squares.get(i))) {
                game.makeMove(i);
            }
        } 
    }
    
}
