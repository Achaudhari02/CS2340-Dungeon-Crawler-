package com.example.a2340c_team45;

import android.graphics.Bitmap;

public class PlayerModel {
    private int health;
    private String name;
    private int difficulty;
    private Bitmap playerImage;
    private static PlayerModel playerModel;
    private PlayerModel() {

    }
    public static PlayerModel getPlayer() {
        if (playerModel == null) {
            playerModel = new PlayerModel();
        }
        return playerModel;
    }


}
