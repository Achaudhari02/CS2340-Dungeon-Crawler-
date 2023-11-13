package com.example.a2340c_team45;
import static org.junit.Assert.assertEquals;

import com.example.a2340c_team45.models.Enemy;
import com.example.a2340c_team45.models.EnemyFactory;

import org.junit.Test;
public class EnemySpeedTest {
    @Test
    public void testEnemy1() {
        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = factory.getEnemy("enemy1");
        assertEquals(5, enemy.getSpeed());
    }
    @Test
    public void testEnemy2() {
        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = factory.getEnemy("enemy2");
        assertEquals(10, enemy.getSpeed());
    }

    @Test
    public void testEnemy3() {
        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = factory.getEnemy("enemy3");
        assertEquals(15, enemy.getSpeed());
    }
}
