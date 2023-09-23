package com.example.a2340c_team45;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class InitialActivity extends AppCompatActivity {

    ImageButton spr1Button, spr2Button, spr3Button;

    Button continueToGameButton;
    String name;
    Player player = new Player();
    Bitmap playerImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        spr1Button = findViewById(R.id.spr1Button);
        spr2Button = findViewById(R.id.spr2Button);
        spr3Button = findViewById(R.id.spr3Button);
        continueToGameButton = findViewById(R.id.continueToGame);

        spr1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImagePath = ((BitmapDrawable)spr1Button.getDrawable()).getBitmap();
            }
        });

        spr2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImagePath = ((BitmapDrawable)spr2Button.getDrawable()).getBitmap();
            }
        });

        spr3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImagePath = ((BitmapDrawable)spr3Button.getDrawable()).getBitmap();
            }
        });

        continueToGameButton.setOnClickListener(v -> {
            RadioGroup difficultySelection = findViewById(R.id.diffSel);
            int selectedId = difficultySelection.getCheckedRadioButtonId();
            name = ((EditText)findViewById(R.id.name)).getText().toString();
            System.out.println(name);

            RadioButton radioButton = (RadioButton) findViewById(selectedId);

            int difficulty = 1;

            int diff = difficultySelection.getCheckedRadioButtonId();

            if (diff == R.id.easyDiff) {
                difficulty = 1;
            } else if (diff == R.id.medDiff) {
                difficulty = 2;
            } else {
                difficulty = 3;
            }
            Intent next = new Intent(getApplicationContext(), GameActivity.class);
            next.putExtra("diff", difficulty);
            next.putExtra("skin", playerImagePath);
            next.putExtra("name", name);
            startActivity(next);
        });

    }

}