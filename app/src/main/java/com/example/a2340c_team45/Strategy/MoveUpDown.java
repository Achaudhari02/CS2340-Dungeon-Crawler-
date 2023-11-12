package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.models.Enemy;

public class MoveUpDown {
    public void moveUp(Enemy enemy) {
        if (ableMoveUp(enemy)) {
            enemy.setY(enemy.getY() - enemy.getSpeed());
        }
    }
    public boolean ableMoveUp(Enemy enemy) {

        if (enemy.getY() < 0) {
            return false;
        }
        return true;
    }
    public void moveDown(Enemy enemy) {
        if (ableMoveDown(enemy)) {
            enemy.setY(enemy.getY() + enemy.getSpeed());
        }
    }
    public boolean ableMoveDown(Enemy enemy) {

        if (enemy.getY() > 1800) {
            return false;
        }
        return true;
    }
}
