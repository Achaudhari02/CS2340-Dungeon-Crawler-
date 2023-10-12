package com.example.a2340c_team45.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2340c_team45.R;
import com.example.a2340c_team45.viewmodel.Leaderboard;

public class EndActivity extends AppCompatActivity {
    private TextView scoreboard;
    private TextView lbReciever;

    private Button restart;
    private TextView score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        // initializing restart button
        restart = findViewById(R.id.restartButton);
        // creating testView to display leaderboard positions
        lbReciever = findViewById(R.id.leaderboardPOS1);

        score = findViewById(R.id.recentScore);

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
        Intent intent = getIntent();

        String newScore = "Current Score: " + intent.getIntExtra("score", 1)
                + " Name: " + intent.getStringExtra("name") + " Date: " + new java.util.Date();
        score.setText(newScore);
    }
}