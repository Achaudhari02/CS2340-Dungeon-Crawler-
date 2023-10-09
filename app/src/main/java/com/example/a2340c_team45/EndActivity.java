package com.example.a2340c_team45;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class EndActivity extends AppCompatActivity {
    private TextView scoreboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        ArrayList<LeaderboardEntry> leaderboardText = Leaderboard.getLeaderboard().getArrayList();

        Leaderboard t = Leaderboard.getLeaderboard();
        t.add(new LeaderboardEntry("test", 5));
        t.add(new LeaderboardEntry("test1", 7));
        t.add(new LeaderboardEntry("test2", 8));
        t.add(new LeaderboardEntry("test3", 9));
        t.add(new LeaderboardEntry("test4", 10));


        scoreboard = findViewById(R.id.scoreboard);
        scoreboard.setText(t.toString());

    }
}