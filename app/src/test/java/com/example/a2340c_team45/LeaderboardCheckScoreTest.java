package com.example.a2340c_team45;

import static org.junit.Assert.assertEquals;

import com.example.a2340c_team45.models.LeaderboardEntry;
import com.example.a2340c_team45.models.Player;
import com.example.a2340c_team45.viewmodel.Leaderboard;

import org.junit.Test;

public class LeaderboardCheckScoreTest {
    @Test
    public void TestName() {
        Leaderboard lb = Leaderboard.getLeaderboard();
        LeaderboardEntry entry = new LeaderboardEntry("test", 5);
        lb.add(entry);
        int ans = entry.getScore();
        assertEquals(ans, 5);
    }
}
