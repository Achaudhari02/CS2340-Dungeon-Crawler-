package com.example.a2340c_team45;

import static org.junit.Assert.assertEquals;
import com.example.a2340c_team45.models.Player;

import org.junit.Test;

public class PlayerChangeMapTest {
    @Test
    public void testMap1toMap2() {
        Player.setLocation("Map1");
        Player.setLocation("Map2");
        assertEquals(Player.getLocation(), "Map2");
    }
    @Test
    public void testMap3toEndActivity() {
        Player.setLocation("Map3");
        Player.setLocation("EndActivity");
        assertEquals(Player.getLocation(), "EndActivity");
    }
}
