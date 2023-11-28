package com.example.a2340c_team45;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

import android.os.Handler;

import com.example.a2340c_team45.models.Enemy;
import com.example.a2340c_team45.models.EnemyFactory;
import com.example.a2340c_team45.models.Player;
import com.example.a2340c_team45.viewmodel.Leaderboard;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ScoreTest {
    @Mock Leaderboard lb = Leaderboard.getLeaderBoardTest();
    @Mock
    final Handler handler = new Handler();
    @Test
    public void testScoreCollision() {

        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = factory.getEnemy("enemy1");
        Player player = Player.getPlayer();
        player.setX(10);
        enemy.setX(10);
        lb.setInitialScore();
        if (enemy.isColliding(player, enemy)) {
            lb.setScore(lb.getScore() - 50);
        }
        assertEquals(lb.getScore(), 950);
    }
    @Test
    public void testMultipleCollision() {
        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = factory.getEnemy("enemy1");
        Player player = Player.getPlayer();
        player.setX(10);
        enemy.setX(10);
        Enemy enemy2 = factory.getEnemy("enemy2");
        enemy2.setX(10);
        lb.setInitialScore();
        if (enemy.isColliding(player, enemy)) {
            lb.setScore(lb.getScore() - 50);
        }
        if (enemy.isColliding(player, enemy2)) {
            lb.setScore(lb.getScore() - 50);
        }
        assertEquals(lb.getScore(), 900);
    }

}