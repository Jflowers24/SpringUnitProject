package com.example.demo.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> GetPlayers() {
        return playerService.GetPlayers();
    }
    /*check*/

    @DeleteMapping(path = "{playerId}")
    public void deletePlayer(@PathVariable(
            "playerId") Long playerId) {
        playerService.deletePlayer(playerId);
        /*check*/
    }

    @PostMapping
    public void registerNewPlayer(@RequestBody Player player) {
        playerService.addNewPlayer(player);
        /*check*/


    }
    @GetMapping(path = "{playerId}")
    public Optional<Player> SearchPlayer(@PathVariable("playerId") Long playerId){
        return playerService.SearchPlayer(playerId);
        /*check*/
    }
}