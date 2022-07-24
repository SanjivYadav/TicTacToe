package tictactoe.controller;

import tictactoe.model.Game;
import tictactoe.model.GameStatus;
import tictactoe.model.Player;
import tictactoe.startegies.winning.WinningStrategies;

import java.util.List;

public class GameController {
    public Game createGame(List<Player> players, List<WinningStrategies> strategies, int dim){
        try {
            return Game.builder()
                        .addPlayers(players)
                    .addWinningStartegies(strategies).
                    addDimension(dim).build();
        } catch (Exception e) {
            throw new RuntimeException("There is something wrong in the game. Try Again ...");
        }
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public GameStatus gameStatus(Game game){
        return game.getGameStatus();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void undo(Game game){
        game.undo();
    }

    public void display(Game game){
        game.getBoard().printBoard();
    }



}
