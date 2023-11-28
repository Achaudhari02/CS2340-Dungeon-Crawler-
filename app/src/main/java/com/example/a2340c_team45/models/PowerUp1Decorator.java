package com.example.a2340c_team45.models;

public class PowerUpDecorator extends PlayerDecorator {
    private Player player;
    public PowerUpDecorator(Player player) {
        super(player);
    }

    public boolean getPowerUp1() {
        return player.getHasPowerup1();
    }
}
