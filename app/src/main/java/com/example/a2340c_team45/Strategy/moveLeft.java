package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.Observer.Subscriber;
import com.example.a2340c_team45.models.Player;

public class moveLeft implements MovementStrat, Subscriber {
    public void move(Player player) {
        if (ableMove(player) & (player.getX() > 0)) {
            player.setX(player.getX() - 10);
        }
    }
    public boolean ableMove(Player player) {
        return true;
    }

    @Override
    public void update(Player player) {
        player.move();
    }
}
