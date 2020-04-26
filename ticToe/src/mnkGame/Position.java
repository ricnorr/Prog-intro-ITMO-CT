package mnkGame;


public interface Position {
    boolean isValid(Move move);
    int getM();
    int getN();
    Cell getCell(int r, int c);
}
