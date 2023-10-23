package com.example.a2340c_team45;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.example.a2340c_team45.Strategy.moveDown;
import com.example.a2340c_team45.Strategy.MoveLeft;
import com.example.a2340c_team45.Strategy.MoveRight;
import com.example.a2340c_team45.models.Player;

public class PlayerDirectionTest {
    @Test
    public void testLeft() {
        Player player = Player.getPlayer();
        player.setX(10);
        player.setY(0);
        player.setMovementStrat(new MoveLeft());
        player.move();
        assertEquals(player.getX(), 0);
    }
    @Test
    public void testRight() {
        Player player = Player.getPlayer();
        player.setX(0);
        player.setY(0);
        player.setMovementStrat(new MoveRight());
        player.move();
        assertEquals(player.getX(), 10);
    }

    @Test
    public void testDownLeft() {
        Player player = Player.getPlayer();
        player.setX(10);
        player.setY(0);
        player.setMovementStrat(new moveDown());
        player.move();
        player.setMovementStrat(new MoveLeft());
        player.move();
        assertEquals(0, player.getX());
        assertEquals(10, player.getY());
    }

    @Test
    public void testDownRight() {
        Player player = Player.getPlayer();
        player.setX(0);
        player.setY(0);
        player.setMovementStrat(new moveDown());
        player.move();
        player.setMovementStrat(new MoveRight());
        player.move();
        assertEquals(10, player.getX());
        assertEquals(10, player.getY());
    }

}
