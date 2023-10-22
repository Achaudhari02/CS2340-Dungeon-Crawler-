package com.example.a2340c_team45;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.example.a2340c_team45.Strategy.moveLeft;
import com.example.a2340c_team45.Strategy.moveRight;
import com.example.a2340c_team45.models.Player;

public class PlayerDirectionTest {
    @Test
    public void testLeft() {
        Player player = Player.getPlayer();
        player.setX(10);
        player.setY(0);
        player.setMovementStrat(new moveLeft());
        player.move();
        assertEquals(player.getX(), 0);
    }
    @Test
    public void testRight() {
        Player player = Player.getPlayer();
        player.setX(0);
        player.setY(0);
        player.setMovementStrat(new moveRight());
        player.move();
        assertEquals(player.getX(), 10);
    }
}
