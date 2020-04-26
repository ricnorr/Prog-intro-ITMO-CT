package mnkGame;

import java.util.Arrays;
import java.util.Map;

public class MnkBoard implements Board, Position {
    private static final Map<Cell, Character> SYMBOLS = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.E, '.'
    );

    private final Cell[][] cells;
    private Cell turn;
    private final int k;
    private int empty;

    public MnkBoard(int m, int n, int k) {
        this.cells = new Cell[m][n];
        this.k = k;
        this.empty = m*n;
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
    }

    @Override
    public Position getPosition() {
        return this;
    }
    @Override
    public int getM() {
        return cells.length;
    }
    @Override
    public int getN() {
        return cells[0].length;
    }
    @Override
    public Cell getCell() {
        return turn;
    }

    @Override
    public Result makeMove(final Move move) {
        if (!isValid(move)) {
            return Result.LOSE;
        }
        cells[move.getRow()][move.getColumn()] = move.getValue();
        empty--;
        if (won(move, 0, 1)
                || won(move, 1, 0)
                || won(move, 1, 1)
                || won(move, -1, 1)) {
            return Result.WIN;
        }
        if (empty == 0) {
            return Result.DRAW;
        }
        turn = turn == Cell.X ? Cell.O : Cell.X;
        return Result.UNKNOWN;
    }

    private boolean won(Move move, int dx, int dy) {
        int posX = move.getColumn();
        int posY = move.getColumn();
        return getRes(dx, dy, posX, posY) + getRes(-dx, -dy, posX, posY) + 1 >= k;
    }

    private int getRes(int dx, int dy, int posX, int posY) {
        int i = posX + dx;
        int j = posY + dy;
        int res = 0;
        while (i >= 0 && j >= 0 && i < cells.length && j < cells[0].length && cells[i][j] == turn) {
            res++;
            i += dx;
            j += dy;
        }
        return res;
    }

    @Override
    public void reset() {
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
    }

    @Override
    public boolean isValid(final Move move) {
        return 0 <= move.getRow() && move.getRow() < getM()
                && 0 <= move.getColumn() && move.getColumn() < getN()
                && cells[move.getRow()][move.getColumn()] == Cell.E
                && turn == getCell();
    }

    @Override
    public Cell getCell(final int r, final int c) {
        return cells[r][c];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int r = 0; r < this.getM(); r++) {
            sb.append(r);
            for (int c = 0; c < this.getN(); c++) {
                sb.append(SYMBOLS.get(cells[r][c]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
