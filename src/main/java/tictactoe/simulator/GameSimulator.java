package tictactoe.simulator;

import tictactoe.controller.GameController;
import tictactoe.model.*;
import tictactoe.startegies.winning.OrderOneWinningStategy;
import tictactoe.startegies.winning.WinningStrategies;
import tictactoe.strategies.bot.BotPlayingStrategies;
import tictactoe.strategies.bot.RandomBotPlayingStrategy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class GameSimulator {
    public static void main(String[] args) {
        Player player1 = new HumanPlayer("Sanjiv", PlayerType.HUMAN,new Symbol('X'));
        WinningStrategies strategies = new OrderOneWinningStategy();
        Player player2 = new Bot("bot", PlayerType.BOT,new Symbol('O'),new RandomBotPlayingStrategy());
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        List<WinningStrategies> winningStrategies = new ArrayList<>();
        winningStrategies.add(strategies);
        GameController gameController = new GameController();
        Game game = gameController.createGame(playerList,winningStrategies,3);
        //game.makeMove();
        gameController.display(game);

        while(!gameController.gameStatus(game).equals(GameStatus.END)){
            System.out.println("Enter your next step");
            gameController.makeMove(game);
            gameController.display(game);
        }
        System.out.println("Game has ended");
        System.out.println("Winner is : "+game.getWinner().getName());
    }
}
