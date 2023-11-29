package com.example.a2340c_team45.models;

import android.view.View;

import com.example.a2340c_team45.viewmodel.Leaderboard;

public class Weapon {
    private static Weapon weapon;
    private int x;
    private int y;
    private int currAngle = 0;
    private Weapon() {
        x = Player.getPlayer().getX();
        y = Player.getPlayer().getY();
        currAngle = 0;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getCurrAngle() {
        return currAngle;
    }

    public boolean swing() {
        Player player = Player.getPlayer();
        switch(currAngle) {
            case 0:
                weapon.setX(player.getX());
                weapon.setY(player.getY() + 100);
                break;
            case 90:
                weapon.setX(player.getX() + 100);
                weapon.setY(player.getY());
                break;
            case 180:
                weapon.setX(player.getX());
                weapon.setY(player.getY() - 100);
                break;
            case 270:
                weapon.setX(player.getX() - 100);
                weapon.setY(player.getY());
                break;
            default:
                break;
        }
        currAngle += 90;
        if (currAngle == 360) {
            currAngle = 0;
        }
        Enemy[] enemies = Enemy.getEnemies();
        boolean hitEnemy = false;
        for (int i = 0; i < enemies.length; i++) {
            if(enemies[i] != null && checkCollisionWithEnemy(enemies[i])) {
                hitEnemy = true;
                enemies[i] = null;
            }
        }
        Enemy.setEnemies(enemies);
        return hitEnemy;
    }

    public static boolean checkCollisionWithEnemy(Enemy enemy) {
        return (Math.abs(weapon.getX() - enemy.getX()) < 25
                        || Math.abs(weapon.getY() - enemy.getY()) < 25);

    }

    public static Weapon getWeapon() {
        if (weapon == null) {
            weapon = new Weapon();
        }
        return weapon;
    }

    private static boolean canAttack = true;
    public static boolean willAttack() {
        if (canAttack) {
            toggleCanAttack();
            return true;
        }
        return canAttack;
    }
    public static void toggleCanAttack() {
        canAttack = !canAttack;
    }





}
