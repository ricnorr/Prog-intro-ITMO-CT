package mnkGame;

import java.util.List;

public class Tournament {

    private final int c;
    private final List<Player> players;
    private int[][] table;
    private int[] finalTable;
    private final boolean tourLog;
    private final Game[][] games;
    private Board board;

    public Tournament(int c, List<Player> players, Board board, Game[][] games, boolean tourLog) {
        this.c = c;
        this.board = board;
        this.players = players;
        this.tourLog = tourLog;
        finalTable = new int[players.size()];
        this.games = games;
    }

    void play() {
        for (int i = 0; i < c; i++) {
            table = new int[players.size()][players.size()];
            for (int j = 0; j < players.size(); j++) {
                for (int u = j + 1; u < players.size(); u++) {
                    board.reset();
                    int result = games[j][u].play(board);
                    if (result == 0) {
                        table[j][u]++;
                        finalTable[j]++;
                        finalTable[u]++;
                        table[u][j]++;
                    } else if (result == 1) {
                        table[j][u] += 3;
                        finalTable[j] += 3;
                    } else {
                        table[u][j] += 3;
                        finalTable[u] += 3;
                    }
                }
            }
            logTable(i);
        }
    }

    private void logTable(int i) {
        if (tourLog) {
            System.out.println("Table after circle " + (i+1));
            printTable();
        }
    }

    public void printTable() {
        System.out.printf(" %10d", 1);
        for (int i = 1; i < table.length; i++) {
            System.out.printf(" %5d", i + 1);
        }
        for (int i = 0; i < table.length; i++) {
            System.out.printf("\n%5d", (i+1));
            for (int j = 0; j < table.length; j++) {
                System.out.printf(" %5d", table[i][j]);
            }
        }
        System.out.println();
    }

    public void printFinalScores() {
        for (int i = 1; i < table.length + 1; i++) {
            printPlayersScores(i);
        }
    }

    public void printPlayersScores(int i) {
        int sum = 0;
        if (i < 1 || i > table.length) {
            System.out.println("No such player");
            return;
        }
        i -= 1;
        System.out.println("Player " + (i+1) + " has " + finalTable[i] + " scores" );
    }

}
