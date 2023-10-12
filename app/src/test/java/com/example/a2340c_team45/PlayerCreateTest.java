package com.example.a2340c_team45;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.example.a2340c_team45.models.Player;

import org.junit.Test;


public class PlayerCreateTest {
    @Test
    public void TestDifficulty() {
        Player player = Player.getPlayer();
        player.setDifficulty(5);

        assertEquals(player.getDifficulty(), 5);
    }

    @Test
    public void TestInitialized() {
        Player player = Player.getPlayer();
        assertNotEquals(player, null);
    }

}
