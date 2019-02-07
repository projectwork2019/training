/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectwork.routes.demo.model;

/**
 *
 * @author antti
 */
public class Game {
    private int gameId;
    private String gameType;
    
    @Override
    public String toString() {
        return "Game id: " + this.gameId + " Game footprint: " + this.gameType;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
    
}
