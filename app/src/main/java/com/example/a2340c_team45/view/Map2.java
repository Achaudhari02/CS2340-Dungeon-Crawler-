package com.example.a2340c_team45.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2340c_team45.R;
import com.example.a2340c_team45.Strategy.moveDown;
import com.example.a2340c_team45.Strategy.moveLeft;
import com.example.a2340c_team45.Strategy.moveRight;
import com.example.a2340c_team45.Strategy.moveUp;
import com.example.a2340c_team45.models.Player;
import com.example.a2340c_team45.viewmodel.Leaderboard;
public class Map2 extends AppCompatActivity {
    private String name;
    private ImageView playerSprite;
    private Player player = Player.getPlayer();
    private Bitmap playerImagePath;
    private TextView scoreView;
    private String diffStr;

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
    }

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
        player.notifySubscribers();
        playerSprite.setX(player.getX());
        playerSprite.setY(player.getY());
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
                scoreView.setText("Score:" + Leaderboard.getScore());
                handler.postDelayed(this, 1000);
            }
        });
    }
}
