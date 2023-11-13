package com.example.a2340c_team45.models;

import android.os.Handler;

import com.example.a2340c_team45.Observer.EnemySubscriber;
import com.example.a2340c_team45.Strategy.EnemyMovementStrat;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemy {
    private int x;
    private int y;
    public abstract int getSpeed();
    public abstract int getStrength();
    private EnemyMovementStrat movementStrat;
    private static List<EnemySubscriber> subscribers = new ArrayList<>();
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void subscribe(EnemySubscriber subscriber) {
        subscribers.add(subscriber);
    }
    public void notifySubscribers() {
        for (EnemySubscriber subscriber: subscribers) {
            subscriber.updateEnemy(this);
        }
    }

    public void updateEnemy(Enemy this) {
        move();
    }

    public void setMovementStrat(EnemyMovementStrat movementStrat) {
        this.movementStrat = movementStrat;
    }
    public void move() {
        if (movementStrat != null) {
            movementStrat.move(this);
        }
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void checkCollAndHP(Player player, Enemy enemy) {
        if (isColliding(player, enemy)) {
            player.decreaseHealth(enemy.getStrength());
        }
            if (isColliding(player, enemy) && canHit) {
                player.decreaseHealth(enemy.getStrength());
                Handler h = new Handler();
                canHit = false;
                h.postDelayed(toggleCanHit, 1000);
            }
    }

    public boolean isColliding(Player player, Enemy enemy) {
        return Math.abs(player.getX() - enemy.getX()) < 25
                || Math.abs(player.getY() - enemy.getY()) < 25;
    }

    private static boolean canHit = true;
    Runnable toggleCanHit = new Runnable() {
        public void run() {canHit = true; }
    };
}
