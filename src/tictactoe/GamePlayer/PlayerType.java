package tictactoe.GamePlayer;

public enum PlayerType {
    None("*"),
    Cross("X"),
    Circle("O");
    
    private final String symbol;
    
    PlayerType(String symbol) {
        this.symbol = symbol;
    }
    @Override
    public String toString() {
        return symbol;
    }
}
