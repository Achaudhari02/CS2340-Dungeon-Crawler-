package com.example.a2340c_team45;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {
    private TextView scoreboard;
    private TextView lbReciever;

    private Button restart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        // initializing restart button
        restart = findViewById(R.id.restartButton);
        // creating testView to display leaderboard positions
        lbReciever = findViewById(R.id.leaderboardPOS1);

        //creating a listener for restart button
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InitialActivity.class);
                startActivities(new Intent[]{intent});
            }
        });

        Leaderboard lb = Leaderboard.getLeaderboard();
        lbReciever.setText(lb.toString());
        Log.d("MainActivity", lb.toString());

//        ArrayList<LeaderboardEntry> leaderboardText = Leaderboard.getLeaderboard().getArrayList();
//        int score = getIntent().getIntExtra("score", 0);
//        String name = getIntent().getStringExtra("name");
//        Leaderboard t = Leaderboard.getLeaderboard();
//        t.add(new LeaderboardEntry(name, score));
//        t.add(new LeaderboardEntry("test", 5)); // entries temporarily added to test functionality
//        t.add(new LeaderboardEntry("test1", 7));
//        t.add(new LeaderboardEntry("test2", 8));
//        t.add(new LeaderboardEntry("test3", 9));
//        t.add(new LeaderboardEntry("test4", 10));


//        scoreboard = findViewById(R.id.scoreboard);
//        scoreboard.setText(t.toString());

    }
}