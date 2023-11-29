package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.Observer.Subscriber;
import com.example.a2340c_team45.models.Player;

public class MoveUp implements MovementStrat, Subscriber {
    public void move(Player player) {
        if (ableMove(player)) {
            if (player.getHasPowerup2()) {
                player.setY(player.getY() - 20);
            } else {
                player.setY(player.getY() - 10);
            }
        }
    }
    public boolean ableMove(Player player) {

        if (player.getY() < 0) {
            return false;
        }
        return true;
    }
    @@Override
    public void update(Player player) {
        player.move();
    }
}
