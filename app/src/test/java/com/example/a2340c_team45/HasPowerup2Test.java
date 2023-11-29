package com.example.a2340c_team45;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.a2340c_team45.models.Player;

import org.junit.Test;

public class HasPowerup2Test {
    @Test
    public void testHasP2() {
        Player player = Player.getPlayer();
        player.setHasPowerup2(true);

        assertTrue(player.getHasPowerup2());
    }
}
