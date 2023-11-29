package com.example.a2340c_team45.models;

public abstract class PlayerDecorator {
    private int x;
    private int y;

    private boolean isCollected = false;

    public PlayerDecorator() {

    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }



}
