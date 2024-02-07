package th.ac.cmu.demo;

import java.util.List;

public interface PlayerService {
    Player createPlayer(String name);

    Player getPlayerInfo(String name);

    List<Player> getLeaderboard();
}
