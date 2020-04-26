package mnkGame;

import java.io.PrintStream;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final PrintStream out;
    private final Scanner in;

    public HumanPlayer(final PrintStream out, final Scanner in) {
        this.out = out;
        this.in = in;
    }

    public HumanPlayer() {
        this(System.out, new Scanner(System.in));
    }

    @Override
    public Move move(final Position position, final Cell cell) {
        while (true) {
            System.out.println(position);
            System.out.println(cell + "'s move");
            out.println("Enter row and column");
            final Move move = new Move(readInt(), readInt(), cell);
            if (position.isValid(move)) {
                return move;
            }
            out.println("\n" + "Move " + move + " is invalid");
        }
    }

    private int readInt() {
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                return in.nextInt();
            }
            in.next();
        }
        throw new IllegalStateException();
    }
}
