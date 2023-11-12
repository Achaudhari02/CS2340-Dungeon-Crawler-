package com.example.a2340c_team45.Strategy;

import com.example.a2340c_team45.models.Enemy;

public interface EnemyMovementStrat {
    void move(Enemy enemy);
    void checkDirection(Enemy enemy);
}