package tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> cells;
    private int dimension;

    public Board(int dimension){
        this.dimension = dimension;
        cells = new ArrayList<>(dimension);
        for(int i=0;i<dimension;i++){
            cells.add(new ArrayList<>(dimension));
            for(int j=0;j<dimension;j++){
                cells.get(i).add(new Cell(i,j));
            }
        }
    }

    public List<List<Cell>> getBoard() {
        return cells;
    }

    public int getDimension() {
        return dimension;
    }

    public void setCell(Cell cell) {
        this.cells.get(cell.getRow()).add(cell);
    }

    public void printBoard(){
        for(List<Cell> row : cells){
            for(Cell cell : row){
                if(cell.getSymbol() == null){
                    System.out.print(" | " + " | ");
                }else {
                    System.out.print(" | " + cell.getSymbol().getCharacter() + " | ");
                }
            }
            System.out.println(" ");
        }
    }
}
