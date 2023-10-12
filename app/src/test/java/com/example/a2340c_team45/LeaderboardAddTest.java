package com.example.a2340c_team45;

import static org.junit.Assert.assertEquals;

import com.example.a2340c_team45.models.LeaderboardEntry;
import com.example.a2340c_team45.viewmodel.Leaderboard;

import org.junit.Test;

import java.util.ArrayList;

public class LeaderboardAddTest {
    @Test
    public void testAdd() {
        Leaderboard lb = Leaderboard.getLeaderboard();

        LeaderboardEntry test5 = new LeaderboardEntry("Test 5", 10);
        LeaderboardEntry test4 = new LeaderboardEntry("Test 4", 8);
        LeaderboardEntry test3 = new LeaderboardEntry("Test 3", 9);
        LeaderboardEntry test2 = new LeaderboardEntry("Test 2", 11);
        LeaderboardEntry test1 = new LeaderboardEntry("Test 1", 12);
        LeaderboardEntry test0 = new LeaderboardEntry("Test 0", 5);

        lb.add(test4);
        lb.add(test3);
        lb.add(test2);
        lb.add(test1);
        lb.add(test5);
        lb.add(test0);

        ArrayList<LeaderboardEntry> answer = new ArrayList<>();
        answer.add(0, test1);
        answer.add(1, test2);
        answer.add(2, test5);
        answer.add(3, test3);
        answer.add(4, test4);

        ArrayList<LeaderboardEntry> lbFirst5 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lbFirst5.add(i, lb.getArrayList().get(i));
        }
        assertEquals(lbFirst5, answer);
    }
}
