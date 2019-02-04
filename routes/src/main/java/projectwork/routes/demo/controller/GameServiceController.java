/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectwork.routes.demo.controller;

import java.util.HashMap;
import java.util.Map;
import projectwork.routes.demo.model.Game;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author antti
 */

@RestController
public class GameServiceController {
    // set up storage for different games since no database yet
    private static Map<Integer, Game> gameRepository = new HashMap<>();
    
    static {
        // seed the game repository with 2 predefined games
        Game game = new Game();
        game.setGameId(1);
        game.setGameType("1x1 + 2x2");
        gameRepository.put(game.getGameId(), game);
        
        Game game2 = new Game();
        game.setGameId(2);
        game.setGameType("2x2 + 2x2 + 1x1");
        gameRepository.put(game.getGameId(), game);
    }
    
    // *****************************
    // * CRUD operations for games *
    // *****************************
    
    // CREATE
    @RequestMapping(value = "/games", method = RequestMethod.POST)
    public ResponseEntity<Object> createGame(@RequestBody Game game) {
        this.gameRepository.put(game.getGameId(), game);
        return new ResponseEntity<>("Game is created successfully", HttpStatus.CREATED);
    }
    
    // READ
    @RequestMapping(value = "/games")
    public ResponseEntity<Object> getGame() {
        return new ResponseEntity<>(this.gameRepository.values(), HttpStatus.OK);
    }
    
    // UPDATE
    @RequestMapping(value = "/games/{id]", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateGame(@PathVariable("id") String id, @RequestBody Game game) {
        int intId = Integer.parseInt(id);
        this.gameRepository.remove(intId);
        game.setGameId(intId);
        gameRepository.put(intId, game);
        return new ResponseEntity<>("Game is updated successfully", HttpStatus.OK);
    }
    
    // DELETE
    @RequestMapping(value = "/games/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        int intId = Integer.parseInt(id);
        this.gameRepository.remove(intId);
        return new ResponseEntity<>("Game " + intId + " is deleted successfully", HttpStatus.OK);
    }
}
