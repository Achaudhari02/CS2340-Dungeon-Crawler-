package com.example.a2340c_team45.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

import android.os.Handler;

import com.example.a2340c_team45.Observer.EnemySubscriber;
import com.example.a2340c_team45.Strategy.MoveLeftRight;
import com.example.a2340c_team45.Strategy.MoveUp;
import com.example.a2340c_team45.Strategy.MoveDown;
import com.example.a2340c_team45.Strategy.MoveRight;
import com.example.a2340c_team45.Strategy.MoveLeft;
import com.example.a2340c_team45.Strategy.MoveUpDown;
import com.example.a2340c_team45.models.Enemy;
import com.example.a2340c_team45.models.EnemyFactory;
import com.example.a2340c_team45.models.LeaderboardEntry;
import com.example.a2340c_team45.R;
import com.example.a2340c_team45.models.Player;
import com.example.a2340c_team45.viewmodel.Leaderboard;

public class GameActivity extends AppCompatActivity {
    private TextView recieverMsgName;
    private TextView recieverMagDiff;
    private TextView startingHp;
    private TextView scoreView;
    private int score = 1000;
    private int time;
    private String name;
    private boolean running;
    private ImageView playerSprite;
    private String diffStr;
    private Bitmap playerImagePath;

    //Enemy ImageViews
    Enemy baseEnemy;
    Enemy[] enemies;
    private ImageView[] enemySprites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);


        // creating textviews for difficulty, hp, name and lel selected
        recieverMsgName = findViewById(R.id.textView2);
        recieverMagDiff = findViewById(R.id.sel_diff_id);
        startingHp = findViewById(R.id.starting_hp_id);

        //using intent to get selected difficulty and entered name
        int diff = getIntent().getIntExtra("diff", 1);
        diffStr = String.valueOf(diff);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        //passing the values to textview to be displayed
        recieverMsgName.setText(name);
        recieverMagDiff.setText(diffStr);
        scoreView = findViewById(R.id.scoreView);
        //creating leaderboard arraylist
        ArrayList<LeaderboardEntry> leaderboard = Leaderboard.getLeaderboard().getArrayList();

        playerSprite = findViewById(R.id.player_sprite_id);
        playerImagePath = intent.getParcelableExtra("skin");
        playerSprite.setImageBitmap(playerImagePath);
        Player player = Player.getPlayer();
        player.subscribe(new MoveDown());
        player.subscribe(new MoveUp());
        player.subscribe(new MoveLeft());
        player.subscribe(new MoveRight());
        player.setX(0);
        player.setY(0);
        updateScore();
        Leaderboard lb = Leaderboard.getLeaderboard();

        //Initialize Enemies
        enemies = initializeEnemies();

        enemyMovement();


        //        endButton.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                Calendar cl2 = Calendar.getInstance();
        //                running = false;
        //                score -= time;
        //                Intent intent = new Intent(getApplicationContext(), EndActivity.class);
        //                intent.putExtra("score", score);
        //                intent.putExtra("name", name);
        //                intent.putExtra("msg", "Congratulations! You won!");
        //                startActivities(new Intent[]{intent});
        //
        //                //adding the current player and score to leaderboard
        //                Leaderboard lb = Leaderboard.getLeaderboard();
        //                LeaderboardEntry newEntry = new LeaderboardEntry(name, score);
        //                lb.add(newEntry);
        //            }
        //        });


        if (diff == 1) {

            startingHp.setText("100");
        } else if (diff == 2) {

            startingHp.setText("75");
        } else {
            startingHp.setText("50");
        }
    }
    // player movement

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Player player = Player.getPlayer();
        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_UP:
            player.setMovementStrat(new MoveUp());
            break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
            player.setMovementStrat(new MoveDown());
            break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
            player.setMovementStrat(new MoveRight());
            break;
        case KeyEvent.KEYCODE_DPAD_LEFT:
            player.setMovementStrat(new MoveLeft());
            break;
        default:
            return super.onKeyDown(keyCode, event);
        }
        player.notifySubscribers();
        playerSprite.setX(player.getX());
        playerSprite.setY(player.getY());
        if (player.getX() >= 100 && player.getX() <= 200 && player.getY() >= 100 && player.getY()
                <= 200) {
            goToNextScene();
        }
        return true;
    }

    private void goToNextScene() {
        Intent intent = new Intent(getApplicationContext(), Map1.class);
        intent.putExtra("diff", diffStr);
        intent.putExtra("skin", playerImagePath);
        intent.putExtra("name", name);
        Player.setLocation("Map1");
        startActivity(intent);
    }

    private void updateScore() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                scoreView.setText("Score:" + Leaderboard.getScore());
                handler.postDelayed(this, 1000);
            }
        });
    }

    private Enemy[] initializeEnemies() {
        EnemyFactory enemyFactory = new EnemyFactory();
        Enemy[] enemyArray = new Enemy[4];

        enemyArray[0] = enemyFactory.getEnemy("enemy1");
        enemyArray[1] = enemyFactory.getEnemy("enemy1");
        enemyArray[2] = enemyFactory.getEnemy("enemy2");
        enemyArray[3] = enemyFactory.getEnemy("enemy2");

        enemyArray[0].setMovementStrat(new MoveLeftRight());
        enemyArray[1].setMovementStrat(new MoveUpDown());
        enemyArray[2].setMovementStrat(new MoveLeftRight());
        enemyArray[3].setMovementStrat(new MoveUpDown());

        enemySprites = new ImageView[4];
        enemySprites[0] = findViewById(R.id.enemy1);
        enemySprites[1] = findViewById(R.id.enemy2);
        enemySprites[2] = findViewById(R.id.enemy3);
        enemySprites[3] = findViewById(R.id.enemy4);
        for (int i = 0; i < enemySprites.length; i++) {
            enemySprites[i].setX(100);
            enemySprites[i].setY(100);
        }

        return enemyArray;
    }

    private void enemyMovement() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                for (int i = 0; i < enemies.length; i++) {
                    enemies[i].move();
                    enemySprites[i].setX(enemies[i].getX());
                    enemySprites[i].setY(enemies[i].getY());
//                    System.out.println("Enemy X, Y")
                }
                handler.postDelayed(this, 100);
            }
        });
    }

}