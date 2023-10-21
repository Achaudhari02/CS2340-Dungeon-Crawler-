package com.example.a2340c_team45.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Calendar;

import android.os.Handler;

import com.example.a2340c_team45.models.LeaderboardEntry;
import com.example.a2340c_team45.R;
import com.example.a2340c_team45.viewmodel.Leaderboard;
import com.example.a2340c_team45.models.Player;


public class GameActivity extends AppCompatActivity {
    private TextView recieverMsgName;
    private TextView recieverMagDiff;
    private TextView startingHp;
    private Button endButton;
    private Button nextButton;
    private TextView scoreView;
    private int score = 1000;
    private int time;
    private String name;
    private boolean running;
    public Player player;
    private float playerX = 0, playerY = 0;
    RelativeLayout gameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        gameLayout = findViewById(R.id.gameLayout);


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
        Bitmap playerImagePath = intent.getParcelableExtra("skin");
        Player.setSprite(playerImagePath);
        Player.setContext(this);
        player = player.getPlayer();
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        player.updatePosition(screenWidth, screenHeight);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        params.leftMargin = 107;
//        gameLayout.addView(player, params);

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
                LeaderboardEntry newEntry = new LeaderboardEntry(name, score);
                lb.add(newEntry);
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                playerX -= 50;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                playerX += 50;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                playerY += 50;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                playerY += 50;
                break;
        }
        player.updatePosition(playerX, playerY);
        return true;
    }

    public int getScore() {
        return score;
    }

}