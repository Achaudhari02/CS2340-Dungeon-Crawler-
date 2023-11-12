package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.Observer.EnemySubscriber;
import com.example.a2340c_team45.models.Enemy;

public class MoveUpDown implements EnemySubscriber, EnemyMovementStrat{
    int direction = 1;
    boolean movingUp = true;
    public void move(Enemy enemy) {
        checkDirection(enemy);
        enemy.setY(enemy.getY() - enemy.getSpeed() * direction); // move up
    }

    public void checkDirection(Enemy enemy) {
        if (enemy.getY() < 0) {
            movingUp = false;
            direction = -1;
        }
        if (enemy.getY() > 1800) {
            movingUp = true;
            direction = 1;
        }
    }

    public void updateEnemy(Enemy enemy) {
        enemy.move();
    }
}
