package com.example.a2340c_team45;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    @Test
    public void testEnemy1Collision() {
        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = factory.getEnemy("enemy1");
        enemy.setX(10);
        enemy.setY(0);
        Player player = Player.getPlayer();
        player.setX(10);
        player.setY(0);
        enemy.move();
        assertEquals(enemy.isColliding(player,enemy),true);

    }
    @Test
    public void testEnemy2Collision() {
        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = factory.getEnemy("enemy2");
        enemy.setX(999);
        enemy.setY(999);
        Player player = Player.getPlayer();
        player.setX(999);
        player.setY(999);
        enemy.move();
        assertEquals(enemy.isColliding(player,enemy),true);

    }

    @Test
    public void testEnemy3Collision() {
        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = factory.getEnemy("enemy3");
        enemy.setX(10);
        enemy.setY(0);
        Player player = Player.getPlayer();
        player.setX(10);
        player.setY(0);
        enemy.move();
        assertTrue(enemy.isColliding(player, enemy));
    }
    @Test
    public void testEnemy4Collision() {
        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = factory.getEnemy("enemy4");
        enemy.setX(999);
        enemy.setY(999);
        Player player = Player.getPlayer();
        player.setX(999);
        player.setY(999);
        enemy.move();
        assertTrue(enemy.isColliding(player, enemy));
    }
}