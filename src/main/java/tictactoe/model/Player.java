package tictactoe.model;

public abstract class Player {
    private Symbol symbol;
    private PlayerType type;
    private String name;
    public Player(String name, PlayerType type,Symbol symbol){
        this.name = name;
        this.type = type;
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public abstract Move makeMove(Board board);
}
