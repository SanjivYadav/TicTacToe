package tictactoe.model;

import tictactoe.strategies.bot.BotPlayingStrategies;

public class Bot extends Player{
    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategies playingStrategies;

    public Bot(String name, PlayerType type, Symbol symbol, BotPlayingStrategies botPlayingStrategies) {
        super(name, type, symbol);
        this.playingStrategies = botPlayingStrategies;
    }

    @Override
    public Move makeMove(Board board) {
        return this.playingStrategies.makeNextMove(board,this);
    }
}
