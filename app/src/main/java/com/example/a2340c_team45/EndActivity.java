package com.example.a2340c_team45;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {
    private TextView leaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        String leaderboardText = Leaderboard.getLeaderboard().toString();

        Leaderboard t = Leaderboard.getLeaderboard();
        t.add(new LeaderboardEntry("test", 5));
        t.add(new LeaderboardEntry("test1", 6));
        t.add(new LeaderboardEntry("test2", 7));
        t.add(new LeaderboardEntry("test3", 8));
        t.add(new LeaderboardEntry("test4", 9));

        leaderboard = findViewById(R.id.leaderboard);
        leaderboard.setText(leaderboardText);

    }
}