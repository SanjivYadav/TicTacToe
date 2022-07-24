package tictactoe.model;

import tictactoe.startegies.winning.WinningStrategies;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;

    public Board getBoard() {
        return board;
    }

    private List<Player> players;

    private List<WinningStrategies> winningStrategies;
    private int dimension;

    private int lastMovedPlayerIndex;

    private GameStatus gameStatus;
    private Player winner;
    private List<Move> moves;
    private Game(){
        this.players = new ArrayList<>();
        winningStrategies = new ArrayList<>();
        moves = new ArrayList<>();
        lastMovedPlayerIndex = -1;
        gameStatus = GameStatus.INPROGRESS;
    }


    public static GameBuilder builder(){
        return new GameBuilder();
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void undo(){
        if(this.moves.size() == 0){
            throw new RuntimeException("Can not undo on empty move list");
        }
        Move lastMove = moves.remove((lastMovedPlayerIndex-1+players.size())%players.size());
        lastMove.getCell().clearCell();
        lastMovedPlayerIndex = (lastMovedPlayerIndex-1+players.size())%players.size();
    }

    public static class GameBuilder{
        private List<Player> players;

        private List<WinningStrategies> winningStrategies;
        private int dimension;
        public GameBuilder(){
            players = new ArrayList<>();
            winningStrategies = new ArrayList<>();
        }

        public GameBuilder addPlayers(List<Player> players){
            this.players.addAll(players);
            return this;
        }

        public GameBuilder addPlayer(Player player){
            this.players.add(player);
            return this;
        }

        public GameBuilder addWinningStartegies(List<WinningStrategies> winningStrategies){
            this.winningStrategies.addAll(winningStrategies);
            return this;
        }

        public GameBuilder addWinningStartegy(WinningStrategies winningStrategies){
            this.winningStrategies.add(winningStrategies);
            return this;
        }

        public GameBuilder addDimension(int dim){
            this.dimension = dim;
            return this;
        }

        private boolean isMultipleBot(List<Player> players){
            int count =0;
            for(Player player : players){
                if(player.getType().equals(PlayerType.BOT)){
                    count++;
                }
            }
            return count >1;
        }

        public Game build() throws Exception {
            if(isMultipleBot(this.players)){
                throw new Exception("Multiple Bot is not supported");
            }
            Game game = new Game();
            game.players.addAll(this.players);
            game.dimension = this.dimension;
            game.winningStrategies.addAll(this.winningStrategies);
            game.board = new Board(game.dimension);

            return game;

        }

    }

    public void makeMove(){
        lastMovedPlayerIndex = (lastMovedPlayerIndex+1)%this.players.size();
        Player player = this.players.get(lastMovedPlayerIndex);
        Move move = player.makeMove(this.board);
        moves.add(move);
        move.setSymbol(move.getCell().getSymbol());
        for(WinningStrategies strategies : winningStrategies){
            boolean status = strategies.checkIfWon(this.board, player, move);
            if(status){
                gameStatus = GameStatus.END;
                winner = player;
            }
        }

    }
}
