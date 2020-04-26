package mnkGame;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Player> players = List.of(
                new RandomPlayer(), new RandomPlayer(), new RandomPlayer(),
                new RandomPlayer(), new RandomPlayer(), new RandomPlayer(),
                new RandomPlayer(), new RandomPlayer(), new RandomPlayer(),
                new RandomPlayer(), new RandomPlayer(), new RandomPlayer()
        );

        Game[][] games = new Game[players.size()][players.size()];
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                games[i][j] = new Game(false, players.get(i), players.get(j));
            }
        }

        Tournament tournament = new Tournament(11, players, new MnkBoard(3,3, 2), games, true);
        tournament.play();
        tournament.printFinalScores();
        tournament.printPlayersScores(1);
    }
}
