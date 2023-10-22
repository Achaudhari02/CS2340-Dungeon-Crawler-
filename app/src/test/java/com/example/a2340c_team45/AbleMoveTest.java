package com.example.a2340c_team45;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.example.a2340c_team45.Strategy.moveLeft;
import com.example.a2340c_team45.Strategy.moveRight;
import com.example.a2340c_team45.Strategy.moveUp;
import com.example.a2340c_team45.models.Player;

public class AbleMoveTest {
    @Test
    public void testRightSide() {
        Player player = Player.getPlayer();
        moveLeft ml = new moveLeft();
        player.setX(-1);
        player.setY(0);
        player.setMovementStrat(new moveLeft());
        player.move();
        assertEquals(ml.ableMove(player),
                false);
    }
    @Test
    public void testTop() {
        Player player = Player.getPlayer();
        moveUp mu = new moveUp();
        player.setX(0);
        player.setY(-1);
        player.setMovementStrat(new moveUp());
        player.move();
        assertEquals(mu.ableMove(player), false);
    }
}