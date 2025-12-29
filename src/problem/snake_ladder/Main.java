package problem.snake_ladder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Snake> snakes = Arrays.asList(
                new Snake(14, 7),
                new Snake(31, 26),
                new Snake(98, 79)
        );

        List<Ladder> ladders = Arrays.asList(
                new Ladder(2, 38),
                new Ladder(15, 44),
                new Ladder(70, 90)
        );

        Board board = new Board(100, ladders, snakes);
        Dice dice = new Dice(6);

        List<Player> players = Arrays.asList(
                new Player("Riyaz"),
                new Player("Alex")
        );

        Game game = new Game(board,dice,players);
        game.start();
    }
}
