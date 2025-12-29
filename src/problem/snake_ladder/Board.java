package problem.snake_ladder;

import java.util.List;

public class Board {
    private final int size;
    private final List<Ladder> ladders;
    private final List<Snake> snakes;

    public Board(int size, List<Ladder> ladders, List<Snake> snakes) {
        this.size = size;
        this.ladders = ladders;
        this.snakes = snakes;
    }

    public int getSize() {
        return size;
    }

    public int getNextPosition(int currentPosition) {
        for (Snake snake : snakes) {
            if (snake.getHead() == currentPosition) {
                System.out.println("Oops ! Bitten by snake from " + currentPosition + " to " + snake.getTail());
                return snake.getTail();
            }
        }

        for (Ladder ladder : ladders) {
            if (ladder.getStart() == currentPosition) {
                System.out.println("Yay climbed ladder from " + currentPosition + " to " + ladder.getEnd());
                return ladder.getEnd();
            }
        }

        return currentPosition;
    }
}
