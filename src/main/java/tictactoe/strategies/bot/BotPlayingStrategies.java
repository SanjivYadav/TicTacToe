package tictactoe.strategies.bot;

import tictactoe.model.Board;
import tictactoe.model.Move;
import tictactoe.model.Player;

public interface BotPlayingStrategies {
    Move makeNextMove(Board borad, Player player);
}
