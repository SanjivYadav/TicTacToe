package tictactoe.model;

import com.sun.source.util.SourcePositions;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(String name, PlayerType type, Symbol symbol) {
        super(name, type, symbol);
    }

    @Override
    public Move makeMove(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Row number : ");
        int row = sc.nextInt();
        System.out.println(" ");
        System.out.print("Enter the Col number : ");
        int col = sc.nextInt();
        System.out.println(" ");
        Cell cell = board.getBoard().get(row).get(col);
        //Cell cell = new Cell(row, col);
        cell.setSymbol(this.getSymbol());
        Move move = new Move();
        move.setCell(cell);
        move.setPlayer(this);
        move.setSymbol(this.getSymbol());
        return move;
    }
}
