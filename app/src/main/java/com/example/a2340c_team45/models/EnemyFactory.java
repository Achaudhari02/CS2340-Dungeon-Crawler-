package com.example.a2340c_team45.models;
import com.example.a2340c_team45.models.Enemy;
import com.example.a2340c_team45.models.Enemy1;
import com.example.a2340c_team45.models.Enemy2;
import com.example.a2340c_team45.models.Enemy3;
import com.example.a2340c_team45.models.Enemy4;
public class EnemyFactory {
    public Enemy getEnemy(String type) {
        if ("enemy1".equalsIgnoreCase(type)) {
            return new Enemy1();
        } else if ("enemy2".equalsIgnoreCase(type)) {
            return new Enemy2();
        } else if ("enemy3".equalsIgnoreCase(type)) {
            return new Enemy3();
        } else if ("enemy4".equalsIgnoreCase(type)) {
            return new Enemy4();
        } else {
            return null;
        }
    }
}
