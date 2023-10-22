package com.example.a2340c_team45.models;

import android.graphics.Bitmap;

import com.example.a2340c_team45.Strategy.MovementStrat;

public class Player {
    private int health;
    private String name;
    private int difficulty;
    private Bitmap playerImage;
    private static Player player;
    private int x;
    private int y;
    private MovementStrat movementStrat;
    private Player() {

    }
    public static Player getPlayer() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }
    public void setMovementStrat(MovementStrat movementStrat) {
        this.movementStrat = movementStrat;
    }
    public void move() {
        if (movementStrat != null) {
            movementStrat.move(this);
        }
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
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
