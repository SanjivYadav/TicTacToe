package tictactoe.model;

public class Cell {
    int row;
    int col;
    Symbol symbol;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public boolean isEmpty(){
        return (symbol==null);
    }

    public void clearCell(){
        this.symbol = null;
    }
}
