/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectwork.routes.demo.controller;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import projectwork.routes.demo.model.Game;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author antti
 */

@Controller
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
        game2.setGameId(2);
        game2.setGameType("2x2 + 2x2 + 1x1");
        gameRepository.put(game2.getGameId(), game2);
    }
    
    // *****************************
    // * CRUD operations for games *
    // *****************************
    
    // CREATE
    @RequestMapping(value="/games", method=RequestMethod.POST)
    public String add(@Valid Game game, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "error";
        }
        
        if (!gameRepository.containsKey(game.getGameId()))
        {
            gameRepository.put(game.getGameId(), game);
            return "result";
        }
        return "error";
    }
    
    // READ
    @GetMapping("/")
    public String games(Model model) {
        model.addAttribute("games", this.gameRepository.values());
        return "index";
    }

    // UPDATE
    // Missing
    
    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        int intId = Integer.parseInt(id);
        if (gameRepository.containsKey(intId))
        {
            gameRepository.remove(intId);
            return "result";
        }
        return "error";
    }
    
    // ADDITIONAL ROUTES FOR NAVIGATION BETWEEN PAGES
    
    // ROUTE FOR DISPLAYING ADD GAME -FORM
    @GetMapping("/add")
    public String addGame() {
        return "add";
    }
}
