package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.models.Player;

public class moveRight implements MovementStrat {
    public void move(Player player) {
        if (ableMove(player)) {
            player.setX(player.getX() + 50);
        }
    }
    public boolean ableMove(Player player) {
        return true;
    }
}
