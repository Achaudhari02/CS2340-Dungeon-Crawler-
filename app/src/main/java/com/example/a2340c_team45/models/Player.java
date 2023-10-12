package com.example.a2340c_team45.models;

import android.graphics.Bitmap;

public class Player {
    private int health;
    private String name;
    private int difficulty;
    private Bitmap playerImage;
    private static Player player;
    private Player() {

    }
    public static Player getPlayer() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }
    public void setDifficulty(int i) {
        difficulty = i;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
