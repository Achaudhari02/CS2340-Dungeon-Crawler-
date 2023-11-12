package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.models.Enemy;

public class MoveLeftRight {
    public void moveLeft(Enemy enemy) {
        if (ableMoveLeft(enemy)) {
            enemy.setX(enemy.getX() - enemy.getSpeed());
        }

    }
    public boolean ableMoveLeft(Enemy enemy) {

        if (enemy.getX() < 0) {
            return false;
        }
        return true;
    }
    public void moveRight(Enemy enemy) {
        if (ableMoveRight(enemy)) {
            enemy.setX(enemy.getX() + enemy.getSpeed());
        }
    }
    public boolean ableMoveRight(Enemy enemy) {
        if (enemy.getX() > 1000) {

            return false;
        }
        return true;
    }
}
