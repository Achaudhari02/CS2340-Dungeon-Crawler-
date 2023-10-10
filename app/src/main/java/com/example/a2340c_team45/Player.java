package com.example.a2340c_team45;

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

}
