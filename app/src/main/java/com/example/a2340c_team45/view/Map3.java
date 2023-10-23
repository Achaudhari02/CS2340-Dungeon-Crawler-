package com.example.a2340c_team45.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2340c_team45.R;
import com.example.a2340c_team45.Strategy.MoveDown;
import com.example.a2340c_team45.Strategy.MoveLeft;
import com.example.a2340c_team45.Strategy.MoveRight;
import com.example.a2340c_team45.Strategy.MoveUp;
import com.example.a2340c_team45.models.Player;
import com.example.a2340c_team45.viewmodel.Leaderboard;
public class Map3 extends AppCompatActivity {
    private String name;
    private ImageView playerSprite;
    private Player player = Player.getPlayer();
    private String diffStr;
    private TextView scoreView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map3);
        int diff = getIntent().getIntExtra("diff", 1);
        diffStr = String.valueOf(diff);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        Bitmap playerImagePath = intent.getParcelableExtra("skin");
        scoreView = findViewById(R.id.scoreView);
        updateScore();
        playerSprite = findViewById(R.id.player_sprite_id4);
        playerSprite.setImageBitmap(playerImagePath);
        player.setX(0);
        player.setY(0);
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
        if (player.getX() <= 50 && player.getY() >= 400 && player.getY() <= 500) {
            goToNextScene();
        }
        return true;
    }

    private void goToNextScene() {
        Intent intent = new Intent(getApplicationContext(), EndActivity.class);
        intent.putExtra("diff", diffStr);
        intent.putExtra("name", name);
        intent.putExtra("msg", "Congratulations! You won!");
        Player.setLocation("EndActivity");
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
