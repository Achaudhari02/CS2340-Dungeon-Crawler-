package com.example.a2340c_team45;

import static org.junit.Assert.assertEquals;

import com.example.a2340c_team45.Strategy.MoveDown;
import com.example.a2340c_team45.Strategy.MoveUp;
import com.example.a2340c_team45.models.Player;

import org.junit.Test;

public class PlayerMoveTest {
    @Test
    public void testUp() {
        Player player = Player.getPlayer();
        player.setX(0);
        player.setY(0);
        player.setMovementStrat(new MoveUp());
        player.move();
        assertEquals(player.getY(), 10);
    }
    @Test
    public void testDown() {
        Player player = Player.getPlayer();
        player.setX(0);
        player.setY(10);
        player.setMovementStrat(new MoveDown());
        player.move();
        assertEquals(player.getY(), 0);
    }
}
