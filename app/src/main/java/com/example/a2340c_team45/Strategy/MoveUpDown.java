package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.Observer.EnemySubscriber;
import com.example.a2340c_team45.models.Enemy;

public class MoveUpDown implements EnemySubscriber, EnemyMovementStrat{
    public void move(Enemy enemy) {
        if (ableMove(enemy)) {
            enemy.setY(enemy.getY() - enemy.getSpeed()); // move up
        } else {
            enemy.setY(enemy.getY() + enemy.getSpeed()); // move down
        }
    }
    public boolean ableMove(Enemy enemy) {

        if (enemy.getY() < 0) {
            return false;
        }
        return true;
    }
    public boolean ableMoveDown(Enemy enemy) {

        if (enemy.getY() > 1800) {
            return false;
        }
        return true;
    }
    public void updateEnemy(Enemy enemy) {
        enemy.move();
    }
}
