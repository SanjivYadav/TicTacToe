package tictactoe.startegies.winning;

import tictactoe.model.Board;
import tictactoe.model.Move;
import tictactoe.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneWinningStategy implements WinningStrategies{
    List<Map<Character, Integer>> rowCharCount;// = new ArrayList<>();
    List<Map<Character, Integer>> colCharCount;// = new ArrayList<>();
    List<Map<Character, Integer>> diagCharCount;// = new ArrayList<>();
    List<Map<Character, Integer>> revDiagCharCount;// = new ArrayList<>();
    private void initialize(int dim){
        rowCharCount = new ArrayList<>();
        colCharCount = new ArrayList<>();
        diagCharCount = new ArrayList<>();
        revDiagCharCount = new ArrayList<>();
        for(int i=0;i<dim;i++) {
            rowCharCount.add(new HashMap<>());
            colCharCount.add(new HashMap<>());
            diagCharCount.add(new HashMap<>());
            revDiagCharCount.add(new HashMap<>());
        }
    }
    @Override
    public boolean checkIfWon(Board board, Player player, Move move) {
        if(rowCharCount == null){
            initialize(board.getDimension());
        }


        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        // check the row if won
        boolean rowCheck = updateAndCheckCount(board, player, row, rowCharCount);

        //check and update column count
        boolean colCheck = updateAndCheckCount(board, player, col, colCharCount);

        boolean primaryDiagCheck = false;
        boolean revDiagCheck = false;

        //check and update primary diagonal count
        if(row == col)
            primaryDiagCheck = updateAndCheckCount(board, player, row, diagCharCount);

        //check and update secondry diagonal count
        if(row+col == board.getDimension()-1)
            revDiagCheck = updateAndCheckCount(board,player,row+col,revDiagCharCount);

        return rowCheck || colCheck || primaryDiagCheck || revDiagCheck;
    }

    private boolean updateAndCheckCount(Board board, Player player, int diag, List<Map<Character, Integer>> charCount) {
        if(!charCount.get(diag).containsKey(player.getSymbol().getCharacter())){
            charCount.get(diag).put(player.getSymbol().getCharacter(),0);
        }
        charCount.get(diag)
                .put(player.getSymbol().getCharacter(),
                        charCount.get(diag).get(player.getSymbol().getCharacter())+1);
        return charCount.get(diag).get(player.getSymbol().getCharacter()).equals(board.getDimension());
    }


}
