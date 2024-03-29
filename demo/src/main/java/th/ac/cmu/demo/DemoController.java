package th.ac.cmu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DemoController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/")
    public String HelloWorld() {
        return "Hello CPE Tuesday!";
    }
    @PostMapping("/player")
    public Player createNewPlayer(@RequestBody String body){
        return this.playerService.createPlayer(body);
    }


    @GetMapping("/player/{name}")
    public ResponseEntity<Object> getPlayerInfo(@PathVariable String name) {
        Player player = playerService.getPlayerInfo(name);
        if (player == null) {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PutMapping("/player/{name}")
    public ResponseEntity<String> incrementClicked(@PathVariable String name) {
        Player player = playerService.getPlayerInfo(name);
        if (player == null) {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }

        playerService.incrementClickCount(name);
        return new ResponseEntity<>("Click count for player " + name + " incremented", HttpStatus.OK);
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<List<Player>> getLeaderboard() {
        List<Player> leaderboard = playerService.getLeaderboard();
        return new ResponseEntity<>(leaderboard, HttpStatus.OK);
    }
}
