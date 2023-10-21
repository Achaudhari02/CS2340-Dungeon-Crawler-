package com.example.a2340c_team45.models;

import android.graphics.Bitmap;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;

public class Player extends View{
    private int health;
    private String name;
    private int difficulty;
    private static Bitmap sprite;
    private static Player player;
    private static Context context;
    private static float x, y;
//    private Player() {
//
//    }
    public static Player getPlayer() {
        if (player == null) {
            player = new Player(context, 0, 0, sprite);
//            player = new Player();
        }
        return player;
    }


    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    private Player(Context context, float x, float y, Bitmap sprite) {
        super(context);
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    public void updatePosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(sprite, 0, 0, null);
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

    public static void setSprite(Bitmap bm) {
        sprite = bm;
    }
    public static void setContext(Context cn) {
        context = cn;
    }
}
