package com.example.a2340c_team45.models;

import android.graphics.Bitmap;
import android.view.View;
import android.content.Context;

public class Player extends View {
    private int health;
    private String name;
    private int difficulty;
    private Bitmap playerImage;
    private static Player player;
    private float x, y;
//    private Player() {
//
//    }
    public static Player getPlayer() {
        if (player == null) {
            player = new Player(player.getContext(), 0, 0);
        }
        return player;
    }


    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    private Player(Context context, float x, float y) {
        super(context);
        this.x = x;
        this.y = y;
    }

    public void updatePosition(float x, float y) {
        this.x = x;
        this.y = y;

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
