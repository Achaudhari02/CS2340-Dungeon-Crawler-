package com.example.a2340c_team45.models;

public class PowerUp3Decorator extends PlayerDecorator {
    private Player player;
    public PowerUp3Decorator(Player player) {
        super(player);
    }

    public boolean getPowerUp3() {
        return player.getHasPowerup3();
    }
}
