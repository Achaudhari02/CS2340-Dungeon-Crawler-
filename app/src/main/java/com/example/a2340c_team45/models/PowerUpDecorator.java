package com.example.a2340c_team45.models;

public class PowerUp1Decorator extends PlayerDecorator {
    private Player player;
    public PowerUp1Decorator(Player player) {
        super(player);
    }

    public boolean getPowerUp1() {
        return player.getHasPowerup1();
    }
}
