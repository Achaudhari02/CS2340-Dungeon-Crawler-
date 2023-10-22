package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.models.Player;

public class moveRight implements MovementStrat {
    public void move(Player player) {
        if (ableMove(player) & (player.getX() < 1000)) {
            player.setX(player.getX() + 10);
        }
    }
    public boolean ableMove(Player player) {
        return true;
    }
}
