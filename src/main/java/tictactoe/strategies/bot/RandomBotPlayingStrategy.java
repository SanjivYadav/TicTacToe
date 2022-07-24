package tictactoe.strategies.bot;

import tictactoe.model.Board;
import tictactoe.model.Cell;
import tictactoe.model.Move;
import tictactoe.model.Player;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategies{
    @Override
    public Move makeNextMove(Board board, Player player) {
        for(List<Cell> rows : board.getBoard()){
            for(Cell cell : rows){
                if(cell.isEmpty()){
                    cell.setSymbol(player.getSymbol());
                    Move move = new Move();
                    move.setCell(cell);
                    move.setPlayer(player);
                    move.setSymbol(player.getSymbol());
                    return move;
                }
            }
        }
        return null;
    }
}
