package com.example.a2340c_team45.models;

public abstract class Enemy {
    private int x;
    private int y;
    public abstract int getSpeed();
    public abstract int getStrength();
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void moveDown(Player player) {
        if (ableMoveDown(player)) {
            player.setY(player.getY() + getSpeed());
        }
    }
    public boolean ableMoveDown(Player player) {

        if (player.getY() > 1800) {
            return false;
        }
        return true;
    }

    public void moveLeft(Player player) {
        if (ableMoveLeft(player)) {
            player.setX(player.getX() - getSpeed());
        }

    }
    public boolean ableMoveLeft(Player player) {

        if (player.getX() < 0) {
            return false;
        }
        return true;
    }
    public void moveRight(Player player) {
        if (ableMoveRight(player)) {
            player.setX(player.getX() + getSpeed());
        }
    }
    public boolean ableMoveRight(Player player) {
        if (player.getX() > 1000) {

            return false;
        }
        return true;
    }
    public void moveUp(Player player) {
        if (ableMoveUp(player)) {
            player.setY(player.getY() - getSpeed());
        }
    }
    public boolean ableMoveUp(Player player) {

        if (player.getY() < 0) {
            return false;
        }
        return true;
    }
}
