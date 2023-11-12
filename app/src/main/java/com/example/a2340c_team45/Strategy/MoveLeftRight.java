package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.Observer.EnemySubscriber;
import com.example.a2340c_team45.models.Enemy;
import com.example.a2340c_team45.models.Player;

public class MoveLeftRight implements EnemySubscriber, EnemyMovementStrat {
    public void move(Enemy enemy) {
        if (ableMove(enemy)) {
            enemy.setX(enemy.getX() - enemy.getSpeed()); // move left
        } else {
            enemy.setX(enemy.getX() + enemy.getSpeed()); //move right
        }

    }
    public boolean ableMove(Enemy enemy) {

        if (enemy.getX() < 0) {
            return false;
        }
        return true;
    }
    public boolean ableMoveRight(Enemy enemy) {
        if (enemy.getX() > 1000) {

            return false;
        }
        return true;
    }
    public void updateEnemy(Enemy enemy) {
        enemy.move();
    }
}
