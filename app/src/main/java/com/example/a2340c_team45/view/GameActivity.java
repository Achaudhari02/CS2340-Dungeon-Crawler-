package com.example.a2340c_team45.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import android.os.Handler;

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
import com.example.a2340c_team45.models.Weapon;
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
    private ImageView[] enemySprites;
    private Enemy[] enemies;

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
        player.setHasPowerup2(false);

        //Initialize Enemies
        Enemy.setEnemies(initializeEnemies());
        enemies = Enemy.getEnemies();
        startEnemyMovement();

        if (diff == 1) {
            startingHp.setText("100");
            player.setHealth(100);
        } else if (diff == 2) {
            startingHp.setText("75");
            player.setHealth(75);
        } else {
            startingHp.setText("50");
            player.setHealth(50);
        }

        ImageButton attackButton = findViewById(R.id.attackButton);
        attackButton.setOnClickListener(v -> {
            attack();
        });

    }

    private void attack() {
        Weapon weapon = Weapon.getWeapon();
        if (weapon.willAttack()) {
            final Handler handler = new Handler();
            ImageView weaponSprite = findViewById(R.id.weapon);
            weaponSprite.setVisibility(View.VISIBLE);
            handler.post(new Runnable() {
                public void run() {
                    if (weapon.swing()) {
                        enemies = Enemy.getEnemies();
                        for (int i = 0; i < enemies.length; i++) {
                            if (enemies[i] == null) {
                                enemySprites[i].setVisibility(View.INVISIBLE);
                                Leaderboard.setScore(Leaderboard.getScore() + 500);
                                Player.getPlayer().setHealth(Player.getPlayer().getHealth() + 2);
                            }
                        }
                    }
                    weaponSprite.setRotation(weapon.getCurrAngle());
                    weaponSprite.setX(weapon.getX());
                    weaponSprite.setY(weapon.getY());
                    if (weapon.getCurrAngle() != 0) {
                        handler.postDelayed(this, 100);
                    } else {
                        weaponSprite.setVisibility(View.INVISIBLE);
                        weapon.toggleCanAttack();
                    }
                }
            });
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
                scoreView.setText("Score:" + Leaderboard.updateScore());
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
        enemyArray[1].setMovementStrat(new MoveLeftRight());
        enemyArray[2].setMovementStrat(new MoveUpDown());
        enemyArray[3].setMovementStrat(new MoveUpDown());

        enemySprites = new ImageView[4];
        enemySprites[0] = findViewById(R.id.enemy1);
        enemySprites[1] = findViewById(R.id.enemy2);
        enemySprites[2] = findViewById(R.id.enemy3);
        enemySprites[3] = findViewById(R.id.enemy4);

        //setup initial positions
        int[] xPositions = {500, 600, 700, 800};
        int[] yPositions = {500, 600, 700, 800};
        for (int i = 0; i < enemySprites.length; i++) {
            enemySprites[i].setX(xPositions[i]);
            enemyArray[i].setX(xPositions[i]);
            enemySprites[i].setY(yPositions[i]);
            enemyArray[i].setY(yPositions[i]);
        }
        return enemyArray;
    }

    private void startEnemyMovement() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                for (int i = 0; i < enemies.length; i++) {
                    if (enemies[i] != null) {
                        enemies[i].move();
                        enemySprites[i].setX(enemies[i].getX());
                        enemySprites[i].setY(enemies[i].getY());
                    }
                    updateHealth();
                }
                handler.postDelayed(this, 300);
            }
        });
    }
    private boolean doOnce = true;
    private void updateHealth() {
        int health = Player.getPlayer().getHealth();
        if (health == 0 && doOnce) {
            doOnce = false;
            Intent intent = new Intent(getApplicationContext(), EndActivity.class);
            intent.putExtra("msg", "Game Over :(");
            startActivity(intent);
        } else {
            startingHp.setText("" + health);
        }
    }

}