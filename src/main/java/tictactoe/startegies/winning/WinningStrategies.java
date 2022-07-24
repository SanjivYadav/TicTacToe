package tictactoe.startegies.winning;

import tictactoe.model.Board;
import tictactoe.model.Move;
import tictactoe.model.Player;

public interface WinningStrategies {

    boolean checkIfWon(Board board, Player player, Move move);
}
