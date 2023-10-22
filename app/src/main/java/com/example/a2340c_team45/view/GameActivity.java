package com.example.a2340c_team45.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;

import android.os.Handler;
import com.example.a2340c_team45.Strategy.moveUp;
import com.example.a2340c_team45.Strategy.moveDown;
import com.example.a2340c_team45.Strategy.moveRight;
import com.example.a2340c_team45.Strategy.moveLeft;
import com.example.a2340c_team45.models.LeaderboardEntry;
import com.example.a2340c_team45.R;
import com.example.a2340c_team45.models.Player;
import com.example.a2340c_team45.viewmodel.Leaderboard;

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
    private ImageView playerSprite;

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

        playerSprite = findViewById(R.id.player_sprite_id);
        Bitmap playerImagePath = intent.getParcelableExtra("skin");
        playerSprite.setImageBitmap(playerImagePath);


        //player sprite movement




        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Map1.class);
                intent.putExtra("diff", diffStr);
                intent.putExtra("skin", playerImagePath);
                intent.putExtra("name", name);
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
                intent.putExtra("msg", "Congratulations! You won!");
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
    // player movement

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Player player = Player.getPlayer();
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                player.setMovementStrat(new moveUp());
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                player.setMovementStrat(new moveDown());
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                player.setMovementStrat(new moveRight());
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                player.setMovementStrat(new moveLeft());
                break;
            default:
                return super.onKeyDown(keyCode, event);
        }
        player.move();
        playerSprite.setX(player.getX());
        playerSprite.setY(player.getY());
        return true;
    }

    public int getScore() {
        return score;
    }

}