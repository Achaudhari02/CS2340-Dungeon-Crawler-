package com.example.a2340c_team45.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.a2340c_team45.models.PowerUp2Decorator;
import com.example.a2340c_team45.models.Weapon;
import com.example.a2340c_team45.viewmodel.Leaderboard;
public class Map2 extends AppCompatActivity {
    private String name;
    private ImageView playerSprite;
    private Player player = Player.getPlayer();
    private Bitmap playerImagePath;
    private TextView scoreView;
    private String diffStr;
    private Enemy[] enemies;
    private ImageView[] enemySprites;
    private ImageView powerup2Sprite;
    private TextView playerHealth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map2);


        int diff = getIntent().getIntExtra("diff", 1);
        diffStr = String.valueOf(diff);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        playerImagePath = intent.getParcelableExtra("skin");
        playerSprite = findViewById(R.id.player_sprite_id3);
        scoreView = findViewById(R.id.scoreView);
        updateScore();
        playerSprite.setImageBitmap(playerImagePath);
        player.setX(0);
        player.setY(0);
        playerHealth = findViewById(R.id.playerHealth);
        player.setHasPowerup1(false);
        powerup2Sprite = findViewById(R.id.powerup2);
        powerup2Sprite.setX(87);
        powerup2Sprite.setY(139);
        Enemy.setEnemies(initializeEnemies());
        enemies = Enemy.getEnemies();
        startEnemyMovement();

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
                                Player.getPlayer().setHealth(Player.getPlayer().getHealth() + 50);
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
        if (player.getX() + 50 >= powerup2Sprite.getX() && player.getX() - 50 <= powerup2Sprite.getX()
                && player.getY() + 50 >= powerup2Sprite.getY() && player.getY() - 50 <= powerup2Sprite.getY()) {
            player.setHasPowerup2(true);
            powerup2Sprite.setImageAlpha(0);
        }
        if (player.getX() >= 930 && player.getY() >= 500 && player.getY() <= 600) {
            goToNextScene();
        }
        return true;
    }

    private void goToNextScene() {
        Intent intent = new Intent(getApplicationContext(), Map3.class);
        intent.putExtra("diff", diffStr);
        intent.putExtra("skin", playerImagePath);
        intent.putExtra("name", name);
        Player.setLocation("Map3");
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

        enemyArray[0] = enemyFactory.getEnemy("enemy3");
        enemyArray[1] = enemyFactory.getEnemy("enemy3");
        enemyArray[2] = enemyFactory.getEnemy("enemy4");
        enemyArray[3] = enemyFactory.getEnemy("enemy4");

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

    boolean doOnce = true;
    private void updateHealth() {
        int health = Player.getPlayer().getHealth();
        if (health == 0 && doOnce) {
            doOnce = false;
            Intent intent = new Intent(getApplicationContext(), EndActivity.class);
            intent.putExtra("msg", "Game Over :(");
            startActivity(intent);
        } else {
            playerHealth.setText("" + health);
        }
    }
}
