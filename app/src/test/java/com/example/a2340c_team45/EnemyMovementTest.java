package com.example.a2340c_team45;

import static org.junit.Assert.assertEquals;

import com.example.a2340c_team45.Strategy.MoveLeft;
import com.example.a2340c_team45.Strategy.MoveLeftRight;
import com.example.a2340c_team45.Strategy.MoveUp;
import com.example.a2340c_team45.Strategy.MoveUpDown;
import com.example.a2340c_team45.models.Enemy;
import com.example.a2340c_team45.models.EnemyFactory;
import com.example.a2340c_team45.models.Player;

import org.junit.Test;

public class EnemyMovementTest {
    @Test
    public void testLeftRight() {
        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = factory.getEnemy("enemy1");
        enemy.setMovementStrat(new MoveLeftRight());
        enemy.setX(0);
        enemy.setY(0);
        enemy.move();
        assertEquals(-1 * enemy.getSpeed(), enemy.getX());
        enemy.move();
        assertEquals(0, enemy.getX());
    }

    @Test
    public void testUpDown() {
        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = factory.getEnemy("enemy1");
        enemy.setMovementStrat(new MoveUpDown());
        enemy.setY(0);
        enemy.move();
        assertEquals(-1 * enemy.getSpeed(), enemy.getY());
        enemy.move();
        assertEquals(0, enemy.getY());
    }
}