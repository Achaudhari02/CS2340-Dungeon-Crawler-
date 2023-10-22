package com.example.a2340c_team45.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a2340c_team45.R;
import com.example.a2340c_team45.Strategy.moveDown;
import com.example.a2340c_team45.Strategy.moveLeft;
import com.example.a2340c_team45.Strategy.moveRight;
import com.example.a2340c_team45.Strategy.moveUp;
import com.example.a2340c_team45.models.Player;

public class Map1 extends AppCompatActivity {
    private Button map1Next;
    private String name;
    private ImageView playerSprite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map1);

        int diff = getIntent().getIntExtra("diff", 1);
        String diffStr = String.valueOf(diff);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        Bitmap playerImagePath = intent.getParcelableExtra("skin");
        map1Next = findViewById(R.id.map1_next);
        playerSprite.findViewById(R.id.player_sprite_id2);

        map1Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Map2.class);
                intent.putExtra("diff", diffStr);
                intent.putExtra("skin", playerImagePath);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
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
        player.move();
        playerSprite.setX(player.getX());
        playerSprite.setY(player.getY());
        return true;
    }
}
