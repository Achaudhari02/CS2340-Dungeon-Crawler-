package com.example.a2340c_team45.models;

import android.graphics.Bitmap;

import com.example.a2340c_team45.Observer.Subscriber;
import com.example.a2340c_team45.Strategy.MovementStrat;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int health;
    private String name;
    private int difficulty;
    private Bitmap playerImage;
    private static Player player;
    private int x;
    private int y;
    private MovementStrat movementStrat;
    private List<Subscriber> subscribers = new ArrayList<>();
    private static String location;
    private Player() {

    }
    public static Player getPlayer() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
    public void notifySubscribers() {
        for (Subscriber subscriber: subscribers) {
            subscriber.update(this);
        }
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
    public static String getLocation() {
        return location;
    }
    public static void setLocation(String lc) {
        location = lc;
    }

    public void decreaseHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

}

