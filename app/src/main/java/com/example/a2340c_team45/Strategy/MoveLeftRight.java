package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.Observer.EnemySubscriber;
import com.example.a2340c_team45.models.Enemy;
import com.example.a2340c_team45.models.Player;

public class MoveLeftRight implements EnemySubscriber, EnemyMovementStrat {
    int direction = 1;
    boolean movingLeft = true;
    public void move(Enemy enemy) {
        checkDirection(enemy);
        enemy.setX(enemy.getX() - enemy.getSpeed() * direction); // move left
        enemy.checkCollAndHP(Player.getPlayer(),enemy);

    }
    public void checkDirection(Enemy enemy) {
        if (enemy.getX() < 0 && movingLeft) {
            direction = -1;
            movingLeft = false;
        }
        if (enemy.getX() > 1000) {
            direction = 1;
            movingLeft = true;
        }
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
