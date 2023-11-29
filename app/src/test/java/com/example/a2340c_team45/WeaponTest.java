package com.example.a2340c_team45;

import static org.junit.Assert.assertEquals;

import com.example.a2340c_team45.Strategy.MoveLeft;
import com.example.a2340c_team45.Strategy.MoveUp;
import com.example.a2340c_team45.models.Enemy;
import com.example.a2340c_team45.models.EnemyFactory;
import com.example.a2340c_team45.models.Player;
import com.example.a2340c_team45.models.Weapon;

import org.junit.Test;

public class WeaponTest {
    @Test
    public void testSweep1() {
        Player player = Player.getPlayer();
        Weapon weapon = Weapon.getWeapon();
        EnemyFactory enemyFactory = new EnemyFactory();
        Enemy enemy = enemyFactory.getEnemy("enemy1");
        enemy.setX(0);
        enemy.setY(0);
        Enemy[] enemies = {enemy};
        Enemy.setEnemies(enemies);
        for (int i = 0; i < 4; i++) {
            weapon.swing();
        }
        assertEquals(enemies[0], null);
    }
    @Test
    public void testSweep2() {
        Player player = Player.getPlayer();
        Weapon weapon = Weapon.getWeapon();
        EnemyFactory enemyFactory = new EnemyFactory();
        Enemy enemy = enemyFactory.getEnemy("enemy1");
        Enemy enemy2 = enemyFactory.getEnemy("enemy2");
        enemy.setX(0);
        enemy.setY(0);
        enemy2.setX(1000);
        enemy2.setY(1000);
        Enemy[] enemies = {enemy, enemy2};
        Enemy.setEnemies(enemies);
        for (int i = 0; i < 4; i++) {
            weapon.swing();
        }
        assertEquals(enemies[0], null);
        assertEquals(enemies[1], enemy2);
    }
}