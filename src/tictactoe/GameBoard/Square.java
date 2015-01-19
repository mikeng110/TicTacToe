package tictactoe.GameBoard;

import tictactoe.GamePlayer.PlayerType;

public class Square {
    private PlayerType mark = PlayerType.None;

    public PlayerType getMark() {
        return mark;
    }

    public void setMark(PlayerType mark) {
        this.mark = mark;
    }
    
}
