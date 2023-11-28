package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.Observer.Subscriber;
import com.example.a2340c_team45.models.Player;
import com.example.a2340c_team45.models.Enemy;

import java.util.ArrayList;
import java.util.List;


public class MoveDown implements MovementStrat, Subscriber {
    private List<Enemy> ls = new ArrayList<>();

    public void move(Player player) {
        if (ableMove(player)) {
            if (player.getHasPowerup2()) {
                player.setY(player.getY() + 20);
            } else {
                player.setY(player.getY() + 10);
            }
        }
    }
    public boolean ableMove(Player player) {

        if (player.getY() > 1800) {
            return false;
        }
        return true;
    }

    public void update(Player player) {
        player.move();

    }
}
