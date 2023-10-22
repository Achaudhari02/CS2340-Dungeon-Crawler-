package com.example.a2340c_team45;

import static org.junit.Assert.assertEquals;

import com.example.a2340c_team45.Strategy.moveDown;
import com.example.a2340c_team45.Strategy.moveLeft;
import com.example.a2340c_team45.Strategy.moveRight;
import com.example.a2340c_team45.Strategy.moveUp;
import com.example.a2340c_team45.models.Player;

import org.junit.Test;

public class PlayerMoveTest {
    @Test
    public void testUp() {
        Player player = Player.getPlayer();
        player.setX(0);
        player.setY(0);
        player.setMovementStrat(new moveUp());
        player.move();
        assertEquals(player.getY(), 10);
    }
    @Test
    public void testDown() {
        Player player = Player.getPlayer();
        player.setX(0);
        player.setY(10);
        player.setMovementStrat(new moveDown());
        player.move();
        assertEquals(player.getY(), 0);
    }
}
