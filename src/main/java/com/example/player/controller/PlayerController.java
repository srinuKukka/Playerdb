/*
 * 
 * You can use the following import statemets
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */
package com.example.player.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.player.model.Player;
import com.example.player.service.PlayerH2Service;

@RestController
public class PlayerController {

  @Autowired
  public PlayerH2Service playerService;

  @GetMapping("/players")
  public ArrayList<Player> getPlayers() {
    return playerService.getPlayers();
  }

  @GetMapping("/players/{playerId}")
  public Player getPlayerById(@PathVariable("playerId") int playerId) {
    return playerService.getPlayerById(playerId);
  }

  @PostMapping("/players")
  public Player addPlayer(@RequestBody Player player) {
    return playerService.addPlayer(player);
  }

  @PutMapping("/player/{playerId}")
  public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player) {
    return playerService.updatePlayer(playerId, player);
  }

  @DeleteMapping("/player/{playerId}")
  public void deletePlayer(@PathVariable("playerId") int playerId) {
    playerService.deletePlayer(playerId);
  }

}
