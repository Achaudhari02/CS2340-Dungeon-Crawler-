package com.example.a2340c_team45;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import android.os.Handler;

public class GameActivity extends AppCompatActivity {
    private TextView recieverMsgName;
    private TextView recieverMagDiff;
    private TextView startingHp;
    private Button endButton, nextButton;
    private TextView scoreView;
    private int score = 1000;
    private int time;
    private String name;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);


        // creating textviews for difficulty, hp, name and lel selected
        recieverMsgName = findViewById(R.id.textView2);
        recieverMagDiff = findViewById(R.id.sel_diff_id);
        startingHp = findViewById(R.id.starting_hp_id);
        endButton = findViewById(R.id.endButton);
        nextButton = findViewById(R.id.next);

        //using intent to get selected difficulty and entered name
        int diff = getIntent().getIntExtra("diff", 1);
        String diffStr = String.valueOf(diff);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        //passing the values to textview to be displayed
        recieverMsgName.setText(name);
        recieverMagDiff.setText(diffStr);
        scoreView = findViewById(R.id.scoreView);
        running = true;
        doTime();
        //creating leaderboard arraylist
        ArrayList<LeaderboardEntry> leaderboard = Leaderboard.getLeaderboard().getArrayList();

        ImageView playerSprite = findViewById(R.id.player_sprite_id);
        Bitmap playerImagePath = intent.getParcelableExtra("skin");
        playerSprite.setImageBitmap(playerImagePath);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Map1.class);
                startActivity(intent);
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cl2 = Calendar.getInstance();
                running = false;
                score -= time;
                Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("name", name);
                startActivities(new Intent[]{intent});

                //adding the current player and score to leaderboard
                Leaderboard lb = Leaderboard.getLeaderboard();
                lb.add(new LeaderboardEntry(name,score));
            }
        });


        if (diff == 1) {

            startingHp.setText("100");
        } else if (diff == 2) {

            startingHp.setText("75");
        } else {
            startingHp.setText("50");
        }
    }

    private void doTime() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                if (running) {
                    time++;
                    scoreView.setText("Score:" + (score - time));
                }
                handler.postDelayed(this, 1000);
            }
        });

    }

}