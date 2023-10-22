package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.models.Player;

public class moveDown implements MovementStrat {
    public void move(Player player) {
        if (ableMove(player)) {
            player.setY(player.getY() + 10);
        }
    }
    public boolean ableMove(Player player) {
        return true;
    }
}
