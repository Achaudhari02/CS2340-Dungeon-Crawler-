package com.example.a2340c_team45;

import static org.junit.Assert.assertEquals;

import com.example.a2340c_team45.Strategy.MoveDown;
import com.example.a2340c_team45.Strategy.MoveLeft;
import com.example.a2340c_team45.Strategy.MoveRight;
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
    @Test
    public void testLeft() {
        Player player = Player.getPlayer();
        player.setX(10);
        player.setY(10);
        player.setMovementStrat(new MoveLeft());
        player.move();
        assertEquals(player.getX(), 0);
    }

    @Test
    public void testRight() {
        Player player = Player.getPlayer();
        player.setX(0);
        player.setY(10);
        player.setMovementStrat(new MoveRight());
        player.move();
        assertEquals(player.getX(), 10);
    }
}
