package com.example.a2340c_team45.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a2340c_team45.R;
import com.example.a2340c_team45.Strategy.MoveDown;
import com.example.a2340c_team45.Strategy.MoveLeft;
import com.example.a2340c_team45.Strategy.MoveLeftRight;
import com.example.a2340c_team45.Strategy.MoveRight;
import com.example.a2340c_team45.Strategy.MoveUp;
import com.example.a2340c_team45.Strategy.MoveUpDown;
import com.example.a2340c_team45.models.Enemy;
import com.example.a2340c_team45.models.EnemyFactory;
import com.example.a2340c_team45.models.Player;
import com.example.a2340c_team45.viewmodel.Leaderboard;

public class Map1 extends AppCompatActivity {
    private String name;
    private ImageView playerSprite;
    private Player player = Player.getPlayer();
    private Bitmap playerImagePath;
    private String diffStr;
    private TextView scoreView;

    Enemy[] enemies;
    private ImageView[] enemySprites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map1);

        int diff = getIntent().getIntExtra("diff", 1);
        diffStr = String.valueOf(diff);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        scoreView = findViewById(R.id.scoreView);
        playerImagePath = intent.getParcelableExtra("skin");
        playerSprite = findViewById(R.id.player_sprite_id2);
        playerSprite.setImageBitmap(playerImagePath);
        player.setX(0);
        player.setY(0);
        updateScore();
        enemies = initializeEnemies();
        startEnemyMovement();
    }
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
        if (player.getX() >= 300 && player.getX() <= 380 && player.getY() >= 500 && player.getY()
                <= 600) {
            goToNextScene();
        }
        return true;
    }

    private void goToNextScene() {
        Intent intent = new Intent(getApplicationContext(), Map2.class);
        intent.putExtra("diff", diffStr);
        intent.putExtra("skin", playerImagePath);
        intent.putExtra("name", name);
        if (player.getHealth() <= 0) {
            Player.setLocation("EndActivity");
            intent.putExtra("msg2", "Game Over :(");
        } else {
            Player.setLocation("Map2");
        }

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

        enemyArray[0] = enemyFactory.getEnemy("enemy2");
        enemyArray[1] = enemyFactory.getEnemy("enemy2");
        enemyArray[2] = enemyFactory.getEnemy("enemy3");
        enemyArray[3] = enemyFactory.getEnemy("enemy3");

        enemyArray[0].setMovementStrat(new MoveUpDown());
        enemyArray[1].setMovementStrat(new MoveUpDown());
        enemyArray[2].setMovementStrat(new MoveLeftRight());
        enemyArray[3].setMovementStrat(new MoveLeftRight());

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
                    enemies[i].move();
                    enemySprites[i].setX(enemies[i].getX());
                    enemySprites[i].setY(enemies[i].getY());
                }
                handler.postDelayed(this, 100);
            }
        });
    }


}
