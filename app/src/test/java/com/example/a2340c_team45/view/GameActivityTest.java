package com.example.a2340c_team45.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.example.a2340c_team45.models.LeaderboardEntry;
public class GameActivityTest {
    @Test
    public void testDateIsCorrect() {
        LeaderboardEntry la = new LeaderboardEntry("Joseph", 500);
        assertEquals(la.getDate(), new java.util.Date());
    }

    @Test
    public void testEntryIsCorrect() {
        LeaderboardEntry la = new LeaderboardEntry("Joseph", 500);
        assertEquals(la.getEntry(), "Name: Joseph  Score: 500  Date: " + la.getDate());
    }
}