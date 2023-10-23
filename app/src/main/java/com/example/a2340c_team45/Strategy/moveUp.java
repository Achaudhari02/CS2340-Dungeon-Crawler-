package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.Observer.Subscriber;
import com.example.a2340c_team45.models.Player;

public class moveUp implements MovementStrat, Subscriber {
    public void move(Player player) {
        if (ableMove(player) & (player.getY() > 0)) {
            player.setY(player.getY() - 10);
        }
    }
    public boolean ableMove(Player player) {
        return true;
    }
    public void update(Player player) {
        player.move();
    }
}
