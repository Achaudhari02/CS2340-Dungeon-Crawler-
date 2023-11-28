package com.example.a2340c_team45;
import static org.junit.Assert.assertTrue;

import com.example.a2340c_team45.models.Player;

import org.junit.Test;

public class HasPowerup1Test {
    @Test
    public void testHasP1() {
        Player player = Player.getPlayer();
        player.setHasPowerup1(true);

        assertTrue(player.getHasPowerup1());
    }

}
