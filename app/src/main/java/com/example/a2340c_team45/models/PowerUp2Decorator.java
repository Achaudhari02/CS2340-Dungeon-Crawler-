package com.example.a2340c_team45.models;

public class PowerUp2Decorator extends PlayerDecorator {
    private Player player;
    public PowerUp2Decorator(Player player) {
        super(player);
    }

    public boolean getPowerUp2() {
        return player.getHasPowerup2();
    }
}
