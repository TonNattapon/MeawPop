package th.ac.cmu.demo;


import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PlayerRepository implements PlayerService{
    private Map<String, Player> map = new HashMap<>();

    @Override
    public Player createPlayer(String name) {
        if(map.containsKey(name))
            return map.get(name);
        Player player = new Player(name);
        map.put(name, player);
        return player;
    }

    @Override
    public Player getPlayerInfo(String name) {
        return map.get(name);
    }

    @Override
    public List<Player> getLeaderboard() {
        List<Player> players = new ArrayList<>(map.values());
        players.sort(Comparator.comparingInt(Player::getScore).reversed());
        return players;
    }
}
