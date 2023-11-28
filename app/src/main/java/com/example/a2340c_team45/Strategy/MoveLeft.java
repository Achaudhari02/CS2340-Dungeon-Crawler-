package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.Observer.Subscriber;
import com.example.a2340c_team45.models.Player;

public class MoveLeft implements MovementStrat, Subscriber {
    public void move(Player player) {
        if (ableMove(player)) {
            if (player.getHasPowerup2()) {
                player.setX(player.getY() - 20);
            } else {
                player.setX(player.getX() - 10);
            }
        }

    }
    public boolean ableMove(Player player) {

        if (player.getX() < 0) {
            return false;
        }
        return true;
    }

    @Override
    public void update(Player player) {
        player.move();
    }
}
