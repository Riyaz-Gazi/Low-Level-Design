package problem.snake_ladder;

import java.util.*;

public class Game {
    private final Board board;
    private final Dice dice;
    private final Queue<Player> players;


    public Game(Board board, Dice dice, List<Player> players) {
        this.board = board;
        this.dice = dice;
        this.players = new LinkedList<>(players);
    }

    public void start() {
        boolean gameWon = false;

        while (!gameWon) {
            Player currentPlayer = players.poll();
            System.out.println(currentPlayer.getName() + "'s turn");
            int roll = dice.roll();
            System.out.println("Rolled a " + roll);

            int nextPosition = currentPlayer.getPosition() + roll;
            if (nextPosition > board.getSize()) {
                System.out.println("Roll exceeds board limit. Try again next turn.");
            }else{
                nextPosition = board.getNextPosition(nextPosition);
                currentPlayer.setPosition(nextPosition);
                System.out.println(currentPlayer.getName() + " moved to the position "+currentPlayer.getPosition());
            }

            if(nextPosition == board.getSize()){
                System.out.println(currentPlayer.getName() + " won the game");
                gameWon = true;
            }else{
                players.offer(currentPlayer);
            }
        }
    }
}
